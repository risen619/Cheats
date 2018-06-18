package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class SpeedExecutor extends PotionEffectExecutor
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
			if(args[1] != null && !duration(20 * Integer.parseInt(args[1]))) return true;
			if(args[2] != null && !amplifier(Integer.parseInt(args[2]))) return true;
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
