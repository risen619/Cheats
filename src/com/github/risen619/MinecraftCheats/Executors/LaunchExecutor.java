package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.util.Vector;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class LaunchExecutor extends Executor
{
	public LaunchExecutor() { super(2); }

	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		int force = 100;
		
		try { if(c.getArgument("force").value() != null) force = Integer.parseInt(c.getArgument("force").value()); }
		catch(NumberFormatException e) { return false; }
		force = Integer.min(100, force);
		
		player().setVelocity(new Vector(0, force, 0));
		
		return true;
	}

}
