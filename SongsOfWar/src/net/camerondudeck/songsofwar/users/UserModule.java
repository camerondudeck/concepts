package net.camerondudeck.songsofwar.users;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class UserModule implements Listener {

	@Getter
	private static UserModule instance;

	public UserModule() {
		instance = this;
	}

	private HashMap<Player, User> users = new HashMap<>();

	public User getUser(Player player) {
		return this.users.get(player);
	}

	public void addUser(Player player) {
		this.users.put(player, new User(player));
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		this.users.put(player, new User(player));
	}

	@EventHandler
	public void quit(PlayerQuitEvent e) {
		Player player = e.getPlayer();

		this.users.remove(player);
	}
}