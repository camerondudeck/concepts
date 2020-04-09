package net.camerondudeck.songsofwar.commands;

import net.camerondudeck.songsofwar.CommandBase;
import net.camerondudeck.songsofwar.gui.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetSong extends CommandBase {

	public GetSong() { super("song", null);}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;

			if(args[0].equals("mobilium")) {
				player.getInventory().addItem(new ItemBuilder().type(Material.GOLD_BLOCK).name(ChatColor.YELLOW + "Mobilium").build());
			}
			if(args[0].equals("supporium")){
				player.getInventory().addItem(new ItemBuilder().type(Material.EMERALD_BLOCK).name(ChatColor.GREEN + "Supporium").build());
			}
			if(args[0].equals("protisium")){
				player.getInventory().addItem(new ItemBuilder().type(Material.TUBE_CORAL_BLOCK).name(ChatColor.BLUE + "Protisium").build());
			}
			player.sendMessage(ChatColor.GREEN + "Song given");
		}
	}
}
