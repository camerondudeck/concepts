package net.camerondudeck.songsofwar;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

/**
 * @apiNote base class for commands to be extended from
 */
public abstract class CommandBase extends Command {

	public CommandBase(String cmd, String permission, String... aliases) {
		super(cmd);
		this.setPermission(permission);
		this.setPermissionMessage(Lang.NO_PERMISSION);
		this.setAliases(Arrays.asList(aliases));
		//TODO: check .* works
		//TODO: set default to false for perms
	}

	@Override
	public final boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (!testPermission(sender))
			return false;

		execute(sender, args);
		return true;
	}

	public abstract void execute(CommandSender sender, String[] args);

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		return super.tabComplete(sender, alias, args);
	}
}
