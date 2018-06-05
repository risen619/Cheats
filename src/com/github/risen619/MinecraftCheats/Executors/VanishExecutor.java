package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VanishExecutor extends Executor
{
	public VanishExecutor() { super(3); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		
		Player p = (Player)s;
		int duration = Integer.MAX_VALUE;
		args = parseArgs(args);

		p = meOrOnlineOne(p, args[0]);
		if(p == null) return true;
		
		try
		{
			if(args[1] != null)
				duration = 20 * Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e) { return false; }
		
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
