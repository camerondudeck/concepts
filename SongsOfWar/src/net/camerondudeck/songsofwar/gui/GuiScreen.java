package net.camerondudeck.songsofwar.gui;

import net.camerondudeck.songsofwar.SOW;
import net.camerondudeck.songsofwar.gui.utils.ItemBuilder;
import net.camerondudeck.songsofwar.gui.utils.RowNumber;
import net.camerondudeck.songsofwar.utils.SoundUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GuiScreen {

	private Inventory inventory;
	public Player player;

	public GuiScreen(Player player, RowNumber slots, String inventoryName) {
		int size = 9;
		switch(slots) {
			case row2:
				size = 18;
				break;
			case row3:
				size = 27;
				break;
			case row4:
				size = 36;
				break;
			case row5:
				size = 45;
				break;
			case row6:
				size = 54;
				break;
		}

		this.inventory = Bukkit.createInventory(player, size, inventoryName);
		this.player = player;
	}

	/**
	 * Opens this @inventory for the @player
	 */
	public void openInventory() {
		this.player.openInventory(this.inventory);
	}

	/***
	 * Set item in inventory
	 *
	 * @param itemStack itemstack
	 */
	public void setItem(GuiItem itemStack) {
		this.inventory.setItem(itemStack.getSlot(), itemStack.getItemStack());
	}

	/***
	 * Create clickable item
	 *
	 * @param itemStack itemstack
	 * @param slot slotnumber
	 * @return GuiItem
	 */
	public GuiItem createItem(ItemStack itemStack, int slot) {
		return new GuiItem(itemStack, this.player, slot);
	}

	/***
	 * Update the item in the inventory without having to recreate the inventory
	 *
	 * @param event InventoryClickEvent
	 * @param itemStack itmestack
	 */
	public void updateItem(InventoryClickEvent event, ItemStack itemStack) {
		this.inventory.setItem(event.getRawSlot(), itemStack);
	}

	/***
	 * Update the item in the inventory without having to recreate the inventory
	 *
	 * @param itemStack itemstack
	 * @param slot slot number
	 */
	public void updateItemSlot(ItemStack itemStack, int slot) {
		this.inventory.setItem(slot, itemStack);
	}

	/***
	 * Add a slot into a loop
	 *
	 * @param slot slot number
	 * @param items items to loop
	 * @param delay wait time in ticks
	 */
	public void addLoop(int slot, List<ItemStack> items, int delay) {

		ItemLoop loop = new ItemLoop(slot, items, this.inventory, delay);

		if(!SOW.getInstance().getGuiManager().getLoopItem().getItemLoops().contains(loop)) {
			SOW.getInstance().getGuiManager().getLoopItem().getItemLoops().add(loop);
		}
	}

	/**
	 * Remove item from loop
	 *
	 * @param slot slot number
	 */
	public void removeLoop(int slot) {

		ItemLoop loop = null;
		for(ItemLoop itemLoop : SOW.getInstance().getGuiManager().getLoopItem().getItemLoops()) {

			if(itemLoop.getInventory().equals(this.inventory)) {

				if(itemLoop.getSlot() == slot) {

					loop = itemLoop;
				}
			}
		}

		if(loop != null) {
			SOW.getInstance().getGuiManager().getLoopItem().getItemLoops().remove(loop);
		}
	}

	/***
	 * ClearCommand space from 2 points by setting items to null
	 *
	 * @param firstSlot starting slot number
	 * @param length numbers of slots to set to null
	 */
	public void clearSpace(int firstSlot, int length) {

		for(int i = 0; i <= length; i++) {

			this.inventory.setItem(firstSlot + i, null);
		}
	}

	/***
	 * Set space from 2 points by setting items to @itemStack
	 *
	 * @param firstSlot starting slot number
	 * @param length numbers of slots to set
	 * @param itemStack Item type
	 */
	public void setSpace(int firstSlot, int length, ItemStack itemStack) {

		for(int i = 0; i <= length; i++) {

			setItem(createItem(itemStack, firstSlot + i).onClick(inventoryClickEvent -> {}));
		}
	}

	/***
	 * Create basic items
	 *
	 * @return itemstack
	 */

	public ItemStack createQuitItem() {
		return new ItemBuilder().type(Material.DIAMOND_SHOVEL).damage(1).name(ChatColor.RED + ChatColor.BOLD.toString() + "Exit Menu").lore(ChatColor.GRAY + ChatColor.ITALIC.toString() + "Click here to exit this menu.").build();
	}

	public ItemStack createBackButton(){
		return new ItemBuilder().type(Material.DIAMOND_SHOVEL).damage(2).name(ChatColor.YELLOW + "Back").lore(ChatColor.GRAY + ChatColor.ITALIC.toString() + "Click here to go back to", ChatColor.GRAY + ChatColor.ITALIC.toString() + "the previous menu.").build();
	}


	/***
	 * Basic Item Functions
	 */

	public static void inventoryOpen(Player player){
		SoundUtils.playSound(player, Sound.UI_TOAST_IN, 2);
	}

	public static void closeMenuButton(Player player){
		player.closeInventory();
		SoundUtils.playSound(player, Sound.BLOCK_DISPENSER_DISPENSE, 1);
	}

	public static void basicButton(Player player){
		SoundUtils.playSound(player, Sound.BLOCK_DISPENSER_DISPENSE, 1);
	}
}