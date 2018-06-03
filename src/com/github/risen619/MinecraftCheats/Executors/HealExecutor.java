package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.CheatsManager;

public class HealExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		Player p = (Player)s;
		if(args.length < 1) p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
		else
		{
			CheatsManager cm = CheatsManager.getInstance();
			String name = args[0];
			Player op = cm.getOnlinePlayer(name);
			if(op == null)
			{
				cm.sendError(p, "This player is not online!");
				return true;
			}
			op.setHealth(op.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
		}
		
		return true;
	}

}
