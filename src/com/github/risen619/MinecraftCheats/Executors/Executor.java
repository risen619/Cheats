package com.github.risen619.MinecraftCheats.Executors;

import java.util.List;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.CheatsManager;
import com.github.risen619.MinecraftCheats.Main;
import com.github.risen619.MinecraftCheats.Argument.Command;

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
	public boolean onCommand(CommandSender s, org.bukkit.command.Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		args = parseArgs(args);
		Command command = Main.getPlugin(Main.class).getCustomCommand(c.getName());
		List<String> errors = command.validateArguments(args);
		if(errors.size() > 0)
		{
			CheatsManager.getInstance().sendError(s, errors.toArray(new String[errors.size()]));
			return true;
		}
		
		return afterCommand(s, command, l, args);
	}
	
	public abstract boolean afterCommand(CommandSender s, Command c, String l, String[] args);
}
