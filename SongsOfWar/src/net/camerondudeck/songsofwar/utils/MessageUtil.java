package net.camerondudeck.songsofwar.utils;

import net.minecraft.server.v1_15_R1.ChatMessageType;
import net.minecraft.server.v1_15_R1.IChatBaseComponent;
import net.minecraft.server.v1_15_R1.PacketPlayOutChat;
import net.minecraft.server.v1_15_R1.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * @MessageUtil allows you to send titles or action bar messages
 */
public class MessageUtil {

	/***
	 * Send a message to the action bar.
	 * Supports color codes.
	 *
	 * @param message Message to send to the action bar
	 */
	public static void sendActionBar(Player player, String message) {
		IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
		PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(iChatBaseComponent, ChatMessageType.GAME_INFO);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
	}

	/***
	 * Send a title message to the player.
	 *
	 * @param mainTitle Message to display in the middle of the screen
	 * @param subTitle Message to display under mainTitle
	 * @param duration Duration of the display message
	 * @param fadeInTime Time it takes for the message to fade in
	 * @param fadeOutTime Time it takes for the message to fade out
	 */
	public static void sendTitle(Player player, String mainTitle, String subTitle, int duration, int fadeInTime, int fadeOutTime) {
		PacketPlayOutTitle times = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeInTime, duration, fadeOutTime);
		PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', mainTitle) + "\"}"), fadeInTime, duration, fadeOutTime);
		PacketPlayOutTitle sub = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', subTitle) + "\" }"), fadeInTime, duration, fadeOutTime);

		((CraftPlayer) player).getHandle().playerConnection.sendPacket(times);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(sub);
	}
}