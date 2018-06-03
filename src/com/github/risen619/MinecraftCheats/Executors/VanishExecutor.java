package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.CheatsManager;

public class VanishExecutor implements CommandExecutor
{
	private static int argsNumber = 2;
	
	private String[] parseArgs(String[] args)
	{
		String[] result = new String[argsNumber];
		for(int i=0; i<args.length; i++)
			result[i] = args[i];
		return result;
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		Player p = (Player)s;
		CheatsManager cm = CheatsManager.getInstance();
		int duration = Integer.MAX_VALUE;
		args = parseArgs(args);

		if(args[0] != null) p = cm.getOnlinePlayer(args[0]);
		if(p == null)
		{
			cm.sendError((Player)s, "This player is not online!");
			return true;
		}
		
		try
		{
			if(args[1] != null)
				duration = 20 * Integer.parseInt(args[1]);
		} catch(NumberFormatException e) { return false; }
		
		if(p.getPotionEffect(PotionEffectType.INVISIBILITY) != null)
		{
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			if(args[1] == null) return true;
		}
		
		PotionEffect pe = new PotionEffect(PotionEffectType.INVISIBILITY, duration, 1);
		p.addPotionEffect(pe);
		
		return true;
	}

}
