package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class VanishExecutor extends PotionEffectExecutor
{	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		reset();

		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		try
		{
			if(args[1] != null && !duration(20 * Integer.parseInt(args[1])))
				return true;
		}
		catch(NumberFormatException e) { return false; }
		
		addEffect(player(), PotionEffectType.INVISIBILITY);
		
		return true;
	}

}
