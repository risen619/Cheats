package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BurnExecutor extends Executor
{
	public BurnExecutor() { super(2); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		
		Player p = (Player)s;
		int duration = 20 * 5;
		args = parseArgs(args);

		p = meOrOnlineOne(p, args[0]);
		if(p == null) return true;
		try { if(args[1] != null) duration = 20 * Integer.parseInt(args[1]); }
		catch(NumberFormatException e) { return false; }
		
		p.setFireTicks(duration);
		return true;
	}

}
