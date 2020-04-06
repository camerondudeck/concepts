package net.camerondudeck.songsofwar;

import lombok.Getter;
import net.camerondudeck.songsofwar.gui.GuiManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class SOW extends JavaPlugin {

	@Getter private static SOW instance;

	@Getter private static CommandMap commandMap;

	@Getter private GuiManager guiManager;

	public void onEnable(){
		instance = this;

		this.guiManager = new GuiManager();
	}

	public static void registerCommand(CommandBase command) {
		getCommandMap().register(instance.getName(), command);
	}

	private static CommandMap getCommandMap() {
		if(commandMap == null) {

			try {
				if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
					Field f = SimplePluginManager.class.getDeclaredField("commandMap");
					f.setAccessible(true);

					commandMap = (CommandMap) f.get(Bukkit.getPluginManager());
				}
			} catch (Exception e) {
				e.printStackTrace();
				commandMap = null;
			}
		}
		return commandMap;
	}
}
