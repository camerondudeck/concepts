package net.camerondudeck.songsofwar.tasks;

import net.camerondudeck.songsofwar.SOW;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RocksMoverTask extends BukkitRunnable {
	private final Player player;
	private final Location loc;

	public RocksMoverTask(Player player, Location loc){
		this.player = player;
		this.loc = loc;
	}

	int i = 0;

	@Override
	public void run() {
		if(i == 15){
			moveRocks(loc);
			this.cancel();
		}
		else {
			i++;
			spawnParticle(player);
		}
	}

	public void moveRocks(Location loc){

		int type = ThreadLocalRandom.current().nextInt(0,3);

		Material toplayer = loc.getBlock().getType();
		Material layer2 = loc.clone().subtract(0,1,0).getBlock().getType();
		Material layer3 = loc.clone().subtract(0,2,0).getBlock().getType();

		Material toplayerb = loc.clone().add(0,3,0).getBlock().getType();
		Material layer2b = loc.clone().add(0,2,0).getBlock().getType();
		Material layer3b = loc.clone().add(0,1,0).getBlock().getType();

		Material outer1 = loc.clone().add(1,1,0).getBlock().getType();
		Material outer2 = loc.clone().add(1,2,0).getBlock().getType();
		Material outer3 = loc.clone().add(1,1,1).getBlock().getType();
		Material outer4 = loc.clone().add(0,1,1).getBlock().getType();

		loc.clone().subtract(0,1,0).getBlock().setType(layer3);
		loc.getBlock().setType(layer3);
		loc.clone().add(0,1,0).getBlock().setType(layer3);
		loc.clone().add(0,2,0).getBlock().setType(layer2);
		loc.clone().add(0,3,0).getBlock().setType(toplayer);
		loc.clone().add(1,1,0).getBlock().setType(layer2);
		loc.clone().add(1,2,0).getBlock().setType(toplayer);
		loc.clone().add(1,1,1).getBlock().setType(toplayer);
		loc.clone().add(0,1,1).getBlock().setType(toplayer);
		loc.getWorld().spawnParticle(Particle.BLOCK_CRACK, loc, 100, 1,1,1,1, loc.getBlock().getBlockData());

		new BukkitRunnable(){
			int i = 1;
			@Override
			public void run() {
				if(i==10*20){
					loc.clone().subtract(0,1,0).getBlock().setType(layer2);
					loc.getBlock().setType(toplayer);
					loc.clone().add(0,1,0).getBlock().setType(layer3b);
					loc.clone().add(0,2,0).getBlock().setType(layer2b);
					loc.clone().add(0,3,0).getBlock().setType(toplayerb);
					loc.clone().add(1,1,0).getBlock().setType(outer1);
					loc.clone().add(1,2,0).getBlock().setType(outer2);
					loc.clone().add(1,1,1).getBlock().setType(outer3);
					loc.clone().add(0,1,1).getBlock().setType(outer4);
					this.cancel();
				} else i++;
			}
		}.runTaskTimer(SOW.getInstance(), 0, 1);
	}

	public void spawnParticle(Player player){
		loc.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().clone().add(0,1,0), 3,0.5,0.5,0.5,0, new Particle.DustOptions(Color.LIME, 1));
		loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(0,1,0), 5,1,1,1,0, new Particle.DustOptions(Color.LIME, 1));
	}
}
