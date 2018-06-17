package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LaunchExecutor extends Executor
{
	public LaunchExecutor() { super(2); }

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		args = parseArgs(args);
		int force = 100;
		
		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		try { if(args[1] != null) force = Integer.parseInt(args[1]); }
		catch(NumberFormatException e) { return false; }
		force = Integer.min(100, force);
		
		player().setVelocity(new Vector(0, force, 0));
		
		return true;
	}

}
