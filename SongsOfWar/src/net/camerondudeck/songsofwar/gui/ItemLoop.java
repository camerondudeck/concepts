package net.camerondudeck.songsofwar.gui;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * @ItemLoop store the values of the item to be looped
 */
public class ItemLoop {

	@Getter
	private int slot;
	@Getter
	private List<ItemStack> items;
	@Getter
	private Inventory inventory;
	private int count = -1;

	private int delay;
	private int pDelay = 0;

	public ItemLoop(int slot, List<ItemStack> items, Inventory inventory, int delay) {
		this.slot = slot;
		this.items = items;
		this.inventory = inventory;
		this.delay = delay;
	}

	public ItemStack getItem() {
		count++;

		if(count > items.size() -1) {
			count = 0;
		}

		return items.get(count);
	}

	public boolean getDelay() {
		pDelay++;

		if(pDelay == delay) {
			pDelay = 0;
			return true;
		}

		return false;
	}
}