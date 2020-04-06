package net.camerondudeck.songsofwar.gui.utils;

import lombok.Getter;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

/**
 * @HotBarC custom hotbar class used to store clickable items
 */
public class HotBarC {

	@Getter
	private int slot;
	@Getter
	private ItemStack itemStack;

	@Getter
	private Consumer<PlayerInteractEvent> playerInteractEventConsumer;

	public HotBarC(int slot, ItemStack itemStack, Consumer<PlayerInteractEvent> playerInteractEventConsumer) {
		this.slot = slot;
		this.itemStack = itemStack;
		this.playerInteractEventConsumer = playerInteractEventConsumer;
	}
}