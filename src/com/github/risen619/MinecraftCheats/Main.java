package com.github.risen619.MinecraftCheats;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.risen619.MinecraftCheats.Executors.*;

public class Main extends JavaPlugin
{	
	@Override
	public void onEnable()
	{
		getCommand("heal").setExecutor(new HealExecutor());
		getCommand("feed").setExecutor(new FeedExecutor());
		getCommand("speed").setExecutor(new SpeedExecutor());
		getCommand("slow").setExecutor(new SlowExecutor());
		getCommand("vanish").setExecutor(new VanishExecutor());
		getCommand("burn").setExecutor(new BurnExecutor());
		getCommand("hat").setExecutor(new HatExecutor());
		getCommand("potato").setExecutor(new PotatoExecutor());
		getCommand("trap").setExecutor(new TrapExecutor());
		getCommand("repair").setExecutor(new RepairExecutor());
		getCommand("lightning").setExecutor(new LightningExecutor());
		getCommand("explosion").setExecutor(new ExplosionExecutor());
		getCommand("launch").setExecutor(new LaunchExecutor());
		getCommand("fly").setExecutor(new FlyExecutor());
		
		CheatsManager.getInstance().setServer(getServer());
		
		System.out.println("Cheats enabled!");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("Cheats disabled!");
	}
}