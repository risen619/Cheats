package com.github.risen619.MinecraftCheats;

import java.util.HashMap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.*;
import com.github.risen619.MinecraftCheats.Executors.PotionEffects.*;

public class Main extends JavaPlugin
{	
	private static HashMap<String, CommandExecutor> executors = new HashMap<>();
	private HashMap<String, Command> comms = new HashMap<String, Command>();
	
	static {
		executors.put("heal", new HealExecutor());
		executors.put("feed", new FeedExecutor());
		executors.put("speed", new SpeedExecutor());
		executors.put("slow", new SlowExecutor());
		executors.put("vanish", new VanishExecutor());
		executors.put("burn", new BurnExecutor());
		executors.put("hat", new HatExecutor());
		executors.put("potato", new PotatoExecutor());
		executors.put("trap", new TrapExecutor());
		executors.put("repair", new RepairExecutor());
		executors.put("lightning", new LightningExecutor());
		executors.put("explosion", new ExplosionExecutor());
		executors.put("launch", new LaunchExecutor());
		executors.put("fly", new FlyExecutor());
		executors.put("dazzle", new DazzleExecutor());
		executors.put("poison", new PoisonExecutor());
		executors.put("strength", new StrengthExecutor());
		executors.put("luck", new LuckExecutor());
		executors.put("unluck", new UnluckExecutor());
		executors.put("resist", new ResistExecutor());
		executors.put("weaken", new WeakenExecutor());
		executors.put("jump", new JumpExecutor());
	}
	
	@Override
	public void onEnable()
	{
		for(String k : executors.keySet())
			comms.put(k, new Command(k, CommandParser.parseCommandUsage(k), executors.get(k)));
		
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