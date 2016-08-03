package reasonwl.listener;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCreationEvent;
import reasonwl.Main;
import reasonwl.database.DataBase;
import reasonwl.event.PlayerWhitelistKickEvent;
import reasonwl.player.WlPlayer;

public class EventListener implements Listener {
	private Main plugin;
	private DataBase db;
	
	public EventListener(Main plugin) {
		this.plugin = plugin;
		db = plugin.getDB();
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length < 1) {
			return false;
		}
		String reason = String.join(" ", args);
		db.getDB("config").set("reason", reason.replaceAll("\\n", "\n"));
		db.message(sender, "Set <" + reason + "> whitelist message.");
		return true;
	}
	
	@EventHandler
	public void onPlayerCreate(PlayerCreationEvent event) {
		event.setPlayerClass(WlPlayer.class);
	}
	
	@EventHandler
	public void onWhitelistKick(PlayerWhitelistKickEvent event) {
		event.setWhitelistMessage(db.getDB("config").getString("reason"));
	}
}
