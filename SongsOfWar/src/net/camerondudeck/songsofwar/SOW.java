package net.camerondudeck.songsofwar;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class SOW extends JavaPlugin {

	@Getter private static SOW instance;

	public void onEnable(){
		instance = this;
	}
}
