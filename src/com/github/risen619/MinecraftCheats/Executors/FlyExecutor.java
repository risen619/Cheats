package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class FlyExecutor extends Executor
{
	public FlyExecutor() { super(1); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		if(player().getAllowFlight()) player().setAllowFlight(false);
		else player().setAllowFlight(true);
		
		return true;
	}

}
