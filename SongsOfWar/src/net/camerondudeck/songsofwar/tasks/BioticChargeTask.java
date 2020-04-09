package net.camerondudeck.songsofwar.tasks;

import net.camerondudeck.songsofwar.SOW;
import net.camerondudeck.songsofwar.listeners.FallDamageListener;
import net.camerondudeck.songsofwar.particles.RotationUtil;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class BioticChargeTask extends BukkitRunnable {
	private final Player player;

	public BioticChargeTask(Player player){
		this.player = player;
	}

	int i = 0;

	@Override
	public void run() {
		if(i == 40) {
			teleportPlayer(player);
			FallDamageListener.getPlayers().add(player);
		} else if(i>40) {
			if(i == 80){
				FallDamageListener.getPlayers().remove(player);
				this.cancel();
			}
		}
		else {
			spawnParticle(player,10);
			spawnParticle(player,130);
		}

		i+=4;
	}

	public void teleportPlayer(Player player){
		Location loc = player.getLocation();
		Vector dir = loc.getDirection();
		dir.normalize();
		dir.multiply(12);
		loc.add(dir);

		int i;
		for(i = 0; i < 10; i++) {
			if (loc.getBlock().getType() != Material.AIR) {
				loc.add(0, 1, 0);
				continue;
			}
			break;
		}
		player.teleport(loc);
	}

	public void spawnParticle(Player player, int startangle){
		new BukkitRunnable(){
			double t = 0;
			double r = 1.15;
			int i = startangle;
			public void run(){
				Location loc = player.getLocation();

				t = t + Math.PI / 8;

				double x = r * Math.cos(t);
				double z = r * Math.sin(t);

				Vector v = new Vector(x, 0, z);
				v = RotationUtil.rotateAroundAxisX(v, i);

				loc.add(v.getX(), v.getY() + 1, v.getZ());
				loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 0,0,0,0,1, new Particle.DustOptions(Color.YELLOW, 1));
				loc.subtract(v.getX(), v.getY(), v.getZ());

				i+=4;
				if (t > Math.PI * 4) {
					this.cancel();
				}
			}
		}.runTaskTimer(SOW.getInstance(), 0, 1);
	}
}
