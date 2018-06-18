package com.github.risen619.MinecraftCheats.Executors.PotionEffects;

import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.PotionEffectExecutor;

public class SpeedExecutor extends PotionEffectExecutor
{	
	@Override
	public boolean onPotionEffectCommand(CommandSender s, Command c, String l, String[] args)
	{	
		switch(addEffect(PotionEffectType.SPEED))
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
