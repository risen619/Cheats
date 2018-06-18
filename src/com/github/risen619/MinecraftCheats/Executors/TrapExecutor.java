package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class TrapExecutor extends Executor
{
	public TrapExecutor() { super(2); }
	
	private void trap(Player p, Material m, double x, double y, double z)
	{
		p.getLocation().add(x, y, z).getBlock().setType(m);
	}
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		Material m = Material.GLASS;
		
		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		if(args[1] != null)
		{
			for(Material mi : Material.values())
				if(args[1].equalsIgnoreCase(mi.name()))
				{
					m = mi;
					break;
				}
		}
		
		trap(player(), m, 0, 2, 0);
		trap(player(), m, 0, -1, 0);
		
		trap(player(), m, 1, 0, 0);
		trap(player(), m, 1, 1, 0);
		trap(player(), m, -1, 0, 0);
		trap(player(), m, -1, 1, 0);
		
		trap(player(), m, 0, 0, 1);
		trap(player(), m, 0, 1, 1);
		trap(player(), m, 0, 0, -1);
		trap(player(), m, 0, 1, -1);
		
		return true;
	}
	
}