package reasonwl;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import reasonwl.database.DataBase;
import reasonwl.listener.EventListener;

public class Main extends PluginBase {
	private DataBase db;
	private EventListener listener;
	
	@Override
	public void onEnable() {
		db = new DataBase(this);
		listener = new EventListener(this);
		
		getServer().getPluginManager().registerEvents(listener, this);
	}
	
	@Override
	public void onDisable() {
		db.save();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return listener.onCommand(sender, command, label, args);
	}
	
	public DataBase getDB() {
		return db;
	}
}
