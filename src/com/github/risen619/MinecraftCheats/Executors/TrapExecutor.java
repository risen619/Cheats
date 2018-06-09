package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrapExecutor extends Executor
{
	public TrapExecutor() { super(2); }
	
	private void trap(Player p, Material m, double x, double y, double z)
	{
		p.getLocation().add(x, y, z).getBlock().setType(m);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;		
		Player p = (Player)s;
		Material m = Material.GLASS;
		args = parseArgs(args);
		
		p = meOrOnlineOne(p, args[0]);
		if(p == null) return true;
		if(args[1] != null)
		{
			for(Material mi : Material.values())
				if(args[1].equalsIgnoreCase(mi.name()))
				{
					m = mi;
					break;
				}
		}
		
		trap(p, m, 0, 2, 0);
		trap(p, m, 0, -1, 0);
		
		trap(p, m, 1, 0, 0);
		trap(p, m, 1, 1, 0);
		trap(p, m, -1, 0, 0);
		trap(p, m, -1, 1, 0);
		
		trap(p, m, 0, 0, 1);
		trap(p, m, 0, 1, 1);
		trap(p, m, 0, 0, -1);
		trap(p, m, 0, 1, -1);
		
		return true;
	}
	
}