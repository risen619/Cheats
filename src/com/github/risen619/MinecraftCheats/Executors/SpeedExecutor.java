package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.CheatsManager;

public class SpeedExecutor implements CommandExecutor
{

	private static int argsNumber = 3;
	
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
		int duration = 200;
		int amplifier = 10;
		CheatsManager cm = CheatsManager.getInstance();
		args = parseArgs(args);
		try
		{
			if(args[0] != null) duration = 20 * Integer.parseInt(args[0]);
			if(args[1] != null) amplifier = Integer.parseInt(args[1]);
		} catch(NumberFormatException e) { return false; }
		if(args[2] != null) p = cm.getOnlinePlayer(args[2]);
		if(p == null)
		{
			cm.sendError((Player)s, "This player is not online!");
			return true;
		}
		
		PotionEffect pe = new PotionEffect(PotionEffectType.SPEED, duration, amplifier);
		p.addPotionEffect(pe);
		return true;
	}

}
