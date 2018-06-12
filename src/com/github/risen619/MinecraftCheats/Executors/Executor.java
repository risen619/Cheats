package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.CheatsManager;

abstract class Executor implements CommandExecutor
{
	protected final String playerNotFound = "This player is not online!";
	
	protected CheatsManager cm;
	protected int argsNumber;
	protected Player player;
	
	protected Player player() { return player; }
	protected void player(Player p) { this.player = p; }
	
	protected Executor() { cm = CheatsManager.getInstance(); }
	protected Executor(int argsNumber) { this(); this.argsNumber = argsNumber; }
	
	protected void meOrOnlineOne(String playerToFind) throws NullPointerException
	{
		if(playerToFind == null) return;
		
		Player p = cm.getOnlinePlayer(playerToFind);
		if(p == null)
		{
			cm.sendError(player(), playerNotFound);
			throw new NullPointerException(playerNotFound);
		}
		else player(p);
	}
	
	protected String[] parseArgs(String[] args)
	{
		String[] result = new String[argsNumber];
		for(int i=0; i<args.length; i++)
			result[i] = args[i];
		return result;
	}
	
	@Override
	public abstract boolean onCommand(CommandSender s, Command c, String l, String[] args);

}
