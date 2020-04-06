package net.camerondudeck.songsofwar.utils;

import net.minecraft.server.v1_15_R1.IChatBaseComponent;
import net.minecraft.server.v1_15_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * @JsonMessageUtil allows you to send Json format messages to the player
 */
public class JsonMessageUtil {

	/**
	 *
	 * @param player the target player
	 * @param text message to be sent
	 * @param clickableText text that you cna click on
	 * @param hoverText  text that will show
	 * @param runCommand command that will be run on click
	 */
	public static void sendClickableHoverableMessage(Player player, String text, String clickableText, String hoverText, String runCommand) {
		IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\",\"extra\":" + "[{\"text\":\"" + clickableText + "\",\"hoverEvent\":{\"action\":\"show_text\", " + "\"value\":\"" + hoverText + "\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":" + "\"/" + runCommand + "\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(chat);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
	}

	/**
	 *
	 * @param player the target player
	 * @param text message to be sent
	 * @param hoverableText text that will show the value
	 * @param hoverText text that will show
	 */
	public static void sendHoverableMessage(Player player, String text, String hoverableText, String hoverText) {
		IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\",\"extra\":" + "[{\"text\":\"" + hoverableText + "\",\"hoverEvent\":{\"action\":\"show_text\", " + "\"value\":\"" + hoverText + "\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(chat);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
	}

	/**
	 *
	 * @param player the target player
	 * @param text message to be sent
	 * @param clickableText text that you cna click on
	 * @param runCommand command that will be run on click
	 */
	public static void sendClickableMessage(Player player, String text, String clickableText, String runCommand) {
		IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\",\"extra\":" + "[{\"text\":\"" + clickableText + "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":" + "\"/" + runCommand + "\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(chat);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
	}
}