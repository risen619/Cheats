package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedExecutor extends Executor
{
	public SpeedExecutor() { super(3); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		
		Player p = (Player)s;
		int duration = Integer.MAX_VALUE;
		int amplifier = 10;
		args = parseArgs(args);
		
		p = meOrOnlineOne(p, args[2]);
		if(p == null) return true;
		
		try
		{
			if(args[0] != null) duration = 20 * Integer.parseInt(args[0]);
			if(args[1] != null) amplifier = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e) { return false; }
		
		if(p.getPotionEffect(PotionEffectType.SPEED) != null)
		{
			p.removePotionEffect(PotionEffectType.SPEED);
			p.setFlySpeed(0.15f);
			if(args[1] == null) return true;
		}
		
		PotionEffect pe = new PotionEffect(PotionEffectType.SPEED, duration, amplifier);
		p.addPotionEffect(pe);
		p.setFlySpeed(0.7f);
		
		return true;
	}

}
