package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class ExplosionExecutor extends Executor
{
	public ExplosionExecutor() { super(1); }

	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		player().getWorld().createExplosion(player().getLocation(), 0.5f);
		return true;
	}

}
