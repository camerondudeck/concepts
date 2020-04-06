package net.camerondudeck.songsofwar;

import net.camerondudeck.songsofwar.utils.ConsoleMessage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Lang {

	public static String PREFIX(ChatColor color) {
		return ChatColor.GRAY + "(" + color.toString() + ChatColor.BOLD.toString() + "❖" + ChatColor.RESET + ChatColor.GRAY + ") " + color.toString();
	}
	public static String PLAYER_OFFLINE(Player player) {
		return PREFIX(ChatColor.RED) + player.getDisplayName() + " is not online.";
	}
	public static String NULL_PLAYER = PREFIX(ChatColor.RED) + "Player could not be found.";
	public static String MUST_BE_PLAYER = ConsoleMessage.RED + "(!) You must be a player to do this :(" + ConsoleMessage.RESET;
	public static String USAGE(String cmd){
		return PREFIX(ChatColor.DARK_GRAY) + "Incorrect usage. Try " + ChatColor.ITALIC + cmd;
	}
	public static String NO_PERMISSION = PREFIX(ChatColor.DARK_RED) + ChatColor.DARK_GRAY + "You do not have permission to use this.";
}
