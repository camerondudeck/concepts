package net.camerondudeck.songsofwar.listeners;

import lombok.Getter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class FallDamageListener implements Listener {

	@Getter public static ArrayList<Player> players = new ArrayList<>();

	@EventHandler
	public void onPlayerFall(EntityDamageEvent e){
		if(e.getEntityType().equals(EntityType.PLAYER)){
			Player player = (Player) e.getEntity();
			if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
				if(players.contains(player)) e.setCancelled(true);
			}
		}
	}
}
