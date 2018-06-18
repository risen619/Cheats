package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class LightningExecutor extends Executor
{
	public LightningExecutor() { super(1); }

	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		player().getWorld().strikeLightning(player().getLocation());
		return true;
	}

}
