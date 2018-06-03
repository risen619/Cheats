package com.github.risen619.MinecraftCheats;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.risen619.MinecraftCheats.Executors.FeedExecutor;
import com.github.risen619.MinecraftCheats.Executors.HealExecutor;
import com.github.risen619.MinecraftCheats.Executors.SpeedExecutor;
import com.github.risen619.MinecraftCheats.Executors.VanishExecutor;

public class Main extends JavaPlugin
{	
	@Override
	public void onEnable()
	{
		getCommand("heal").setExecutor(new HealExecutor());
		getCommand("feed").setExecutor(new FeedExecutor());
		getCommand("speed").setExecutor(new SpeedExecutor());
		getCommand("vanish").setExecutor(new VanishExecutor());
		
		CheatsManager.getInstance().setServer(getServer());
		
		System.out.println("Cheats enabled!");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("Cheats disabled!");
	}
}