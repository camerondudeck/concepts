package net.camerondudeck.songsofwar.gui;

import net.camerondudeck.songsofwar.SOW;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @GuiItem custom item with clickable actions
 */
public class GuiItem {

	private ItemStack itemStack;
	private Player player;
	private int slot;

	public GuiItem(ItemStack itemStack, Player player, int slot) {
		this.itemStack = itemStack;
		this.player = player;
		this.slot = slot;
	}

	/***
	 * Get itemstack out of GuiItem
	 *
	 * @return itemstack
	 */
	public ItemStack getItemStack() {
		return itemStack;
	}

	/***
	 * Get slot number out of GuiItem
	 *
	 * @return slot number
	 */
	public int getSlot() {
		return slot;
	}

	/***
	 * Consumer onClick for chest inventorys
	 *
	 * @param event InventoryClickEvent
	 * @return @this
	 */
	public GuiItem onClick(Consumer<InventoryClickEvent> event) {
		HashMap<Integer, Consumer<InventoryClickEvent>> map = SOW.getInstance().getGuiManager().getInventory().get(player);

		if(map == null) {
			map = new HashMap<>();
		}

		map.put(slot, event);

		SOW.getInstance().getGuiManager().getInventory().put(player, map);
		return this;
	}

	public GuiItem end() {
		HashMap<Integer, Consumer<InventoryClickEvent>> map = SOW.getInstance().getGuiManager().getInventory().get(player);

		if(map == null) {
			map = new HashMap<>();
		}

		map.put(slot, inventoryClickEvent -> {});

		SOW.getInstance().getGuiManager().getInventory().put(player, map);
		return this;
	}
}