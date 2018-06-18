package com.github.risen619.MinecraftCheats;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CheatsManager
{
	private static CheatsManager instance = null;
	private Server server = null;
	
	private CheatsManager() { }
	
	public static CheatsManager getInstance()
	{
		if(instance == null)
			instance = new CheatsManager();
		return instance;
	}
	
	public void setServer(Server server) { this.server = server; }
	public Server getServer() { return this.server; }
	
	private void sendMessage(CommandSender p, String message) { p.sendMessage(message); }
	private void sendMessage(CommandSender p, String[] message) { p.sendMessage(message); }
	
	public void sendError(CommandSender p, String message) { sendMessage(p, ChatColor.RED + message); }
	public void sendError(CommandSender p, String[] message)
	{
		for(int i = 0; i < message.length; i++)
			message[i] = ChatColor.RED + message[i];
		sendMessage(p, message);
	}
	
	public void sendSuccess(CommandSender p, String message) { sendMessage(p, ChatColor.GREEN + message); }
	public void sendSuccess(CommandSender p, String[] message)
	{
		for(int i = 0; i < message.length; i++)
			message[i] = ChatColor.GREEN + message[i];
		sendMessage(p, message);
	}
	
	public Player getOnlinePlayer(String name)
	{
		for(Player p : server.getOnlinePlayers())
			if(p.getName().equalsIgnoreCase(name))
				return p;
		return null;
	}
	
	public void fillPlayerInventory(Player p, Material m, boolean isHard)
	{
		PlayerInventory inv = p.getInventory();
		ItemStack item = new ItemStack(m);
		item.setAmount(1);
		
		if(isHard) inv.clear();
		for(int i=0; i<inv.getSize(); i++)
		{
			if(inv.getItem(i) == null)
				inv.setItem(i, item);
		}
	}
	
}