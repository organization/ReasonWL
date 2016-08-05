package reasonwl.player;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.network.SourceInterface;
import reasonwl.event.PlayerWhitelistKickEvent;

public class WlPlayer extends Player {

	public WlPlayer(SourceInterface interfaz, Long clientID, String ip, int port) {
		super(interfaz, clientID, ip, port);
	}

	@Override
	protected void processLogin() {
        if (!this.server.isWhitelisted((this.getName()).toLowerCase())) {
        	PlayerWhitelistKickEvent ev = new PlayerWhitelistKickEvent(this, "Server is white-listed");
        	Server.getInstance().getPluginManager().callEvent(ev);
        	if (!ev.isCancelled()) {
        		this.close(this.getLeaveMessage(), ev.getWhitelistMessage());
        		return;
        	}
        }
        super.processLogin();
    }
}
