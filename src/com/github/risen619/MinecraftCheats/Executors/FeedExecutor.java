package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class FeedExecutor extends Executor
{	
	public FeedExecutor() { super(1); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		player().setFoodLevel(20);
		return true;
	}

}
