package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.CheatsManager;

public class PotatoExecutor extends Executor
{
	public PotatoExecutor() { super(2); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		
		Player p = (Player)s;
		CheatsManager cm = CheatsManager.getInstance();
		boolean isHard = false;
		args = parseArgs(args);
		
		p = meOrOnlineOne(p, args[0]);
		if(p == null) return true;
		
		if(args[1] != null)
		{
			if(!args[1].equalsIgnoreCase("hard"))
				return false;
			isHard = true;
		}
		
		cm.fillPlayerInventory(p, Material.POISONOUS_POTATO, isHard);
		return true;
	}

}