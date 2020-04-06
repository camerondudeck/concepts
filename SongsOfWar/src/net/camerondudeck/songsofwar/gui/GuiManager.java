package net.camerondudeck.songsofwar.gui;

import lombok.Getter;
import lombok.Setter;
import net.camerondudeck.songsofwar.gui.utils.HotBarC;
import net.camerondudeck.songsofwar.gui.utils.LoopItem;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @GuiManager main manager for GUI's handles events and stores data
 */
public class GuiManager implements Listener {

	@Getter
	private HashMap<Player, HashMap<Integer, Consumer<InventoryClickEvent>>> inventory = new HashMap<>();
	@Getter
	private HashMap<Player, List<HotBarC>> hotBar = new HashMap<>();
	@Setter
	@Getter
	private LoopItem loopItem;

	/***
	 * Handles all onClick in chests
	 *
	 * @param e event
	 */
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();

		if(e.getAction() == InventoryAction.HOTBAR_SWAP) {
			e.setCancelled(true);
			return;
		}
		if(e.getCurrentItem() == null) return;
		if(e.getCurrentItem().getType() == Material.AIR) return;

		if(inventory.containsKey(player)) {

			if(e.getClickedInventory().getType() != InventoryType.CHEST) {
				e.setCancelled(true);
				return;
			}

			this.inventory.get(player).get(e.getRawSlot()).accept(e);

			e.setCancelled(true);
		}

		if(hotBar.containsKey(player)) {

			if(player.getGameMode() == GameMode.CREATIVE) return;
			e.setCancelled(true);
		}
	}

	/***
	 * Handles all onClick in hot bars
	 *
	 * @param e event
	 */
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if(e.getHand() == null) return;

		if(e.getHand().equals(EquipmentSlot.OFF_HAND)) return;
		if(player.getInventory().getItemInMainHand() == null) return;

		if(hotBar.containsKey(player)) {

			List<HotBarC> list = this.hotBar.get(player);

			for(HotBarC c : list) {
				if(c.getSlot() == player.getInventory().getHeldItemSlot()) {
					if(c.getItemStack().getType() == player.getInventory().getItemInMainHand().getType()) {

						c.getPlayerInteractEventConsumer().accept(e);

						e.setCancelled(true);
						break;
					}
				}
			}
		}
	}

	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		Player player = (Player) e.getPlayer();

		if(loopItem != null) {
			ItemLoop loop = null;
			for(ItemLoop itemLoop : loopItem.getItemLoops()) {
				if(itemLoop.getInventory().equals(e.getInventory())) {
					loop = itemLoop;
				}
			}

			if(loop != null) {
				loopItem.getItemLoops().remove(loop);
			}
		}

		this.inventory.remove(player);
	}

	@EventHandler
	public void quit(PlayerQuitEvent e) {
		if(loopItem != null) {
			ItemLoop loop = null;
			for(ItemLoop itemLoop : loopItem.getItemLoops()) {
				if(itemLoop.getInventory().equals(this.getInventory().get(e.getPlayer()))) {
					loop = itemLoop;
				}
			}

			if(loop != null) {
				loopItem.getItemLoops().remove(loop);
			}
		}
		this.inventory.remove(e.getPlayer());
		this.hotBar.remove(e.getPlayer());
	}
}