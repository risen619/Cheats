package com.github.risen619.MinecraftCheats.Executors.PotionEffects;

import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.PotionEffectExecutor;

public class SlowExecutor extends PotionEffectExecutor
{
	public SlowExecutor() { super(Integer.MAX_VALUE, 5); }
	
	@Override
	public boolean onPotionEffectCommand(CommandSender s, Command c, String l, String[] args)
	{
		switch(addEffect(PotionEffectType.SLOW))
		{
			case REMOVED: restoreFlySpeed(); break;
			case ADDED_FOREVER: decreaseFlySpeed(); break;
			case ADDED:
				decreaseFlySpeed();
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
