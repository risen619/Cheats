package com.github.risen619.MinecraftCheats;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.*;

public class Main extends JavaPlugin
{	
	private HashMap<String, Command> comms = new HashMap<String, Command>();
	@Override
	public void onEnable()
	{
		comms.put("heal", new Command("heal", CommandParser.parseCommandUsage("heal"), new HealExecutor()));
		comms.put("feed", new Command("feed", CommandParser.parseCommandUsage("feed"), new FeedExecutor()));
		comms.put("speed", new Command("speed", CommandParser.parseCommandUsage("speed"), new SpeedExecutor()));
		comms.put("slow", new Command("slow", CommandParser.parseCommandUsage("slow"), new SlowExecutor()));
		comms.put("vanish", new Command("vanish", CommandParser.parseCommandUsage("vanish"), new VanishExecutor()));
		comms.put("burn", new Command("burn", CommandParser.parseCommandUsage("burn"), new BurnExecutor()));
		comms.put("hat", new Command("hat", CommandParser.parseCommandUsage("hat"), new HatExecutor()));
		comms.put("potato", new Command("potato", CommandParser.parseCommandUsage("potato"), new PotatoExecutor()));
		comms.put("trap", new Command("trap", CommandParser.parseCommandUsage("trap"), new TrapExecutor()));
		comms.put("repair", new Command("repair", CommandParser.parseCommandUsage("repair"), new RepairExecutor()));
		comms.put("lightning", new Command("lightning", CommandParser.parseCommandUsage("lightning"), new LightningExecutor()));
		comms.put("explosion", new Command("explosion", CommandParser.parseCommandUsage("explosion"), new ExplosionExecutor()));
		comms.put("launch", new Command("launch", CommandParser.parseCommandUsage("launch"), new LaunchExecutor()));
		comms.put("fly", new Command("fly", CommandParser.parseCommandUsage("fly"), new FlyExecutor()));
		
		CheatsManager.getInstance().setServer(getServer());
		
		System.out.println("Cheats enabled!");
	}
	
	public Command getCustomCommand(String name) { return comms.get(name); }
	
	@Override
	public void onDisable()
	{
		System.out.println("Cheats disabled!");
	}
}