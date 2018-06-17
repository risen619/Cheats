package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyExecutor extends Executor
{
	public FlyExecutor() { super(1); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		args = parseArgs(args);

		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		if(player().getAllowFlight())
			player().setAllowFlight(false);
		else player().setAllowFlight(true);
		
		return true;
	}

}
