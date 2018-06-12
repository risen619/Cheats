package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class SpeedExecutor extends PotionEffectExecutor
{	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		args = parseArgs(args);
		

		player((Player)s);
		try { meOrOnlineOne(args[2]); }
		catch(NullPointerException e) { return true; }
		
		try
		{
			if(args[0] != null && !duration(20 * Integer.parseInt(args[0]))) return true;
			if(args[1] != null && !amplifier(Integer.parseInt(args[1]))) return true;
		}
		catch(NumberFormatException e) { return false; }
		
		switch(addEffect(player(), PotionEffectType.SPEED))
		{
			case REMOVED: restoreFlySpeed(); break;
			case ADDED_FOREVER: increaseFlySpeed(); break;
			case ADDED:
				increaseFlySpeed();
				
				new Thread(new Runnable()
				{	
					@Override
					public void run()
					{
						try { Thread.sleep(duration * 50); }
						catch (InterruptedException e) { }
						finally { restoreFlySpeed(); }
					}
				}).start();
			break;
		}
		
		return true;
	}

}
