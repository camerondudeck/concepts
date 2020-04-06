package net.camerondudeck.songsofwar.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

/**
 * @SoundUtils allows you to play sounds to players
 */
public class SoundUtils {

	/**
	 * Play sound to all players within a radius
	 *
	 * @param location the location to play the sound
	 * @param sound specifies the sound to play
	 * @param pitch the pitch of the sound
	 * @param radius the radius to play the sound in
	 */
	public static void playSoundForAll(Location location, Sound sound, float pitch, int radius) {
		for(Player pp : Bukkit.getOnlinePlayers()) {
			if(pp.getLocation().distance(location) <= radius) {
				pp.playSound(pp.getLocation(), sound, Integer.MAX_VALUE, pitch);
			}
		}
	}

	/**
	 * Player custom sound to all players within a radius
	 *
	 * @param location the location to play the sound
	 * @param sound specifies the sound to play
	 * @param soundCategory the category of the sound
	 * @param volume volume of the sound
	 * @param pitch the pitch of the sound
	 * @param radius the radius to play the sound in
	 */
	public static void playSoundForAll(Location location, String sound, SoundCategory soundCategory, float volume, float pitch, int radius) {
		for(Player pp : Bukkit.getOnlinePlayers()) {
			if(pp.getLocation().distance(location) <= radius) {
				pp.playSound(pp.getLocation(), sound, soundCategory, volume, pitch);
			}
		}
	}

	/**
	 * Play sound to one player
	 *
	 * @param player the target player
	 * @param sound specifies the sound to play
	 * @param pitch the pitch of the sound
	 */
	public static void playSound(Player player, Sound sound, float pitch) {
		player.playSound(player.getLocation(), sound, Integer.MAX_VALUE, pitch);
	}

	/**
	 * play custom sound to one player
	 *
	 * @param player the target player
	 * @param sound specifies the sound to play
	 * @param soundCategory the category of the sound
	 * @param volume volume of the sound
	 * @param pitch the pitch of the sound
	 */
	public static void playSound(Player player, String sound, SoundCategory soundCategory, float volume, float pitch) {
		player.playSound(player.getLocation(), sound, soundCategory, volume, pitch);
	}

	/**
	 * play custom sound
	 *
	 * @param location the target location
	 * @param sound specifies the sound to play
	 * @param soundCategory the category of the sound
	 * @param volume volume of the sound
	 * @param pitch the pitch of the sound
	 */
	public static void playSound(Location location, String sound, SoundCategory soundCategory, float volume, float pitch, int radius) {
		for(Player pp : Bukkit.getOnlinePlayers()) {
			if(pp.getLocation().distance(location) <= radius) {
				pp.playSound(location, sound, soundCategory, volume, pitch);
			}
		}
	}
}