package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class PotatoExecutor extends Executor
{
	public PotatoExecutor() { super(2); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		boolean isHard = false;
		
		if(c.getArgument("hard").value() != null)
		{
			if(!c.getArgument("hard").value().equalsIgnoreCase("hard"))
				return false;
			isHard = true;
		}
		
		cm.fillPlayerInventory(player(), Material.POISONOUS_POTATO, isHard);
		return true;
	}

}