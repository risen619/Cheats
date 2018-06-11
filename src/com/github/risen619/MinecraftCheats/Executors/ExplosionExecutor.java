package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplosionExecutor extends Executor
{
	public ExplosionExecutor() { super(1); }

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length != argsNumber) return false;
		args = parseArgs(args);
		
		Player p = (Player)s;
		if(args[0] != null) p = meOrOnlineOne(p, args[0]);
		if(p == null) return true;
		
		p.getWorld().createExplosion(p.getLocation(), 0.5f);
		
		return true;
	}

}
