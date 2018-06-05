package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.CheatsManager;

abstract class Executor implements CommandExecutor
{
	protected final String playerNotFound = "This player is not online!";
	
	protected int argsNumber;
	
	protected Executor() { }
	protected Executor(int argsNumber) { this.argsNumber = argsNumber; }
	
	protected Player meOrOnlineOne(Player me, String playerToFind)
	{
		CheatsManager cm = CheatsManager.getInstance();
		if(playerToFind == null) return me;
		
		Player p = cm.getOnlinePlayer(playerToFind);
		if(p == null)
			cm.sendError(me, playerNotFound);
		return p;
	}
	
	protected String[] parseArgs(String[] args)
	{
		String[] result = new String[argsNumber];
		for(int i=0; i<args.length; i++)
			result[i] = args[i];
		return result;
	}
	
	@Override
	public abstract boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3);

}
