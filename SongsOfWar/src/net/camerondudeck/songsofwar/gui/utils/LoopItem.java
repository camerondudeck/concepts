package net.camerondudeck.songsofwar.gui.utils;

import lombok.Getter;
import net.camerondudeck.songsofwar.gui.ItemLoop;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * @LoopItem loop task for loopable items
 */
public class LoopItem extends BukkitRunnable {

	@Getter
	private List<ItemLoop> itemLoops = new ArrayList<>();

	@Override
	public void run() {

		for(ItemLoop itemLoop : itemLoops) {

			if(itemLoop.getDelay()) {
				itemLoop.getInventory().setItem(itemLoop.getSlot(), itemLoop.getItem());
			}
		}
	}
}