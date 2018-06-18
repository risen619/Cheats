package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class HealExecutor extends Executor
{
	public HealExecutor() { super(1); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		player().setHealth(player().getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
		player().setRemainingAir(player().getMaximumAir());
		
		return true;
	}

}
