package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class PotatoExecutor extends Executor
{
	public PotatoExecutor() { super(2); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		boolean isHard = false;

		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		if(args[1] != null)
		{
			if(!args[1].equalsIgnoreCase("hard"))
				return false;
			isHard = true;
		}
		
		cm.fillPlayerInventory(player(), Material.POISONOUS_POTATO, isHard);
		return true;
	}

}