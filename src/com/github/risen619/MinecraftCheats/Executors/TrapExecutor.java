package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class TrapExecutor extends Executor
{
	public TrapExecutor() { super(2); }
	
	private void trap(Player p, Material m, double x, double y, double z)
	{ p.getLocation().add(x, y, z).getBlock().setType(m); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{	
		Material m = Material.GLASS;
		
		if(c.getArgument("block").value() != null)
		{
			for(Material mi : Material.values())
				if(c.getArgument("block").value().equalsIgnoreCase(mi.name()))
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