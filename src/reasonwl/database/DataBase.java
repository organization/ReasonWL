package reasonwl.database;

import java.io.File;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import reasonwl.Main;

public class DataBase extends BaseDB<Main> {

	public DataBase(Main plugin) {
		super(plugin);
		
		initDB("config", new File(plugin.getDataFolder(), "config.yml"), Config.YAML, new ConfigSection() {{
			put("reason", "server is whitelist");
		}});
		setPrefix("[¼­¹ö]");
	}
}
