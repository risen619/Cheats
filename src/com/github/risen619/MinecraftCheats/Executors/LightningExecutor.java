package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class LightningExecutor extends Executor
{
	public LightningExecutor() { super(1); }

	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		player().getWorld().strikeLightning(player().getLocation());
		
		return true;
	}

}
