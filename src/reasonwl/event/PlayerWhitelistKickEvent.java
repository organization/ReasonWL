package reasonwl.event;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;

public class PlayerWhitelistKickEvent extends PlayerEvent implements Cancellable {
	private String whitelistMessage;
	
	private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }
	
	public PlayerWhitelistKickEvent(Player player, String whitelistMessage) {
		this.player = player;
		this.whitelistMessage = whitelistMessage;
	}
	
	public void setWhitelistMessage(String message) {
		whitelistMessage = message;
	}
	
	public String getWhitelistMessage() {
		return whitelistMessage;
	}
}
