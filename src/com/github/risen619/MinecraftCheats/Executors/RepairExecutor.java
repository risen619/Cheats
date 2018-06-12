package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RepairExecutor extends Executor
{
	public RepairExecutor() { super(0); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		
		player((Player)s);
		ItemStack inHand = player().getInventory().getItemInMainHand();
		inHand.setDurability((short)0);
		
		return true;
	}

}
