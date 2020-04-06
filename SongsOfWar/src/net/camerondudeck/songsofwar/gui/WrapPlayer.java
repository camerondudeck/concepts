package net.camerondudeck.songsofwar.gui;

import net.camerondudeck.songsofwar.SOW;
import net.camerondudeck.songsofwar.gui.utils.HotBarC;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @WarpPlayer Logs the player items with the hotbar
 */
public class WrapPlayer {

	private Player player;

	public WrapPlayer(Player player) {
		this.player = player;
	}

	/***
	 * Add item to hot bar with clickable action
	 *
	 * @param itemStack itemstack
	 * @param slot slot number
	 * @param event PlayerInteractEvent
	 * @return @this
	 */
	public WrapPlayer addItem(ItemStack itemStack, int slot, Consumer<PlayerInteractEvent> event) {
		GuiItem item = new GuiItem(itemStack, this.player, slot);

		player.getInventory().setItem(item.getSlot(), item.getItemStack());

		List<HotBarC> map = SOW.getInstance().getGuiManager().getHotBar().get(player);

		if(map == null) {
			map = new ArrayList<>();
		}

		map.add(new HotBarC(slot, itemStack, event));

		SOW.getInstance().getGuiManager().getHotBar().put(player, map);

		return this;
	}

	/**
	 * Remove item from hot bar
	 *
	 * @param slot
	 * @return
	 */
	public WrapPlayer removeItem(int slot) {
		SOW.getInstance().getGuiManager().getHotBar().get(player).remove(slot -1);

		player.getInventory().setItem(slot, null);

		return this;
	}
}