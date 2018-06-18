package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class BurnExecutor extends Executor
{
	public BurnExecutor() { super(2); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		int duration = 20 * 5;
		try
		{
			if(c.getArgument("duration").value() != null)
				duration = 20 * Integer.parseInt( c.getArgument("duration").value() );
		}
		catch(NumberFormatException e) { return false; }
		
		player().setFireTicks(duration);
		return true;
	}

}
