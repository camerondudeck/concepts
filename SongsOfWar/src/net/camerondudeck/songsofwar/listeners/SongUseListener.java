package net.camerondudeck.songsofwar.listeners;

import net.camerondudeck.songsofwar.SOW;
import net.camerondudeck.songsofwar.gui.utils.ItemBuilder;
import net.camerondudeck.songsofwar.tasks.BioticChargeTask;
import net.camerondudeck.songsofwar.tasks.RocksMoverTask;
import net.camerondudeck.songsofwar.tasks.SphereShieldTask;
import net.camerondudeck.songsofwar.utils.SoundUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class SongUseListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			Player player = e.getPlayer();

			if(player.getInventory().getItemInMainHand().equals(new ItemBuilder().type(Material.GOLD_BLOCK).name(ChatColor.YELLOW + "Mobilium").build())) {
				SoundUtils.playSound(player.getLocation(), "minecraft:songs.biotic_charge", SoundCategory.MASTER, 100, 1, 20);

				new BioticChargeTask(player).runTaskTimer(SOW.getInstance(), 0, 4);
			}

			if(player.getInventory().getItemInMainHand().equals(new ItemBuilder().type(Material.EMERALD_BLOCK).name(ChatColor.GREEN + "Supporium").build())) {
				Location loc = player.getEyeLocation();

				for (int i = 1; i <= 15; i++) {
					Vector dir = loc.getDirection();
					dir.normalize();
					dir.multiply(i);

					loc.add(dir);
					if (!loc.getBlock().getType().equals(Material.AIR)) break;

					if (i == 15) {
						player.sendMessage(ChatColor.RED + ChatColor.ITALIC.toString() + "Not in range");
						return;
					}

					loc.subtract(dir);
				}

				new RocksMoverTask(player, loc).runTaskTimer(SOW.getInstance(), 0, 1);
				SoundUtils.playSound(player.getLocation(), "minecraft:songs.rocks_mover", SoundCategory.MASTER, 100, 1, 20);
			}

			if(player.getInventory().getItemInMainHand().equals(new ItemBuilder().type(Material.TUBE_CORAL_BLOCK).name(ChatColor.BLUE + "Protisium").build())) {
				SoundUtils.playSound(player.getLocation(), "minecraft:songs.arm_shield", SoundCategory.MASTER, 100, 1, 20);

				//new SphereShieldTask(player);
			}
		}
	}
}
