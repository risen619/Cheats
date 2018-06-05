package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedExecutor extends Executor
{	
	public FeedExecutor() { super(1); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		
		Player p = (Player)s;
		args = parseArgs(args);
		p = meOrOnlineOne(p, args[0]);
		if(p != null)
			p.setFoodLevel(20);
		return true;
	}

}
