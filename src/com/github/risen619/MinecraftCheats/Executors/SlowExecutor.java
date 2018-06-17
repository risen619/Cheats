package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class SlowExecutor extends PotionEffectExecutor
{
	public SlowExecutor() { super(Integer.MAX_VALUE, 5); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		args = parseArgs(args);
		reset();

		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		try
		{
			if(args[1] != null && !duration(20 * Integer.parseInt(args[1]))) return true;
			if(args[2] != null && !amplifier(Integer.min(Integer.parseInt(args[2]), 5))) return true;
			
		}
		catch(NumberFormatException e) { return false; }
		
		switch(addEffect(player(), PotionEffectType.SLOW))
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
