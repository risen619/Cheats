package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class BurnExecutor extends Executor
{
	public BurnExecutor() { super(2); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		int duration = 20 * 5;

		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		try { if(args[1] != null) duration = 20 * Integer.parseInt(args[1]); }
		catch(NumberFormatException e) { return false; }
		
		player().setFireTicks(duration);
		return true;
	}

}
