package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class RepairExecutor extends Executor
{
	public RepairExecutor() { super(0); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		player((Player)s);
		ItemStack inHand = player().getInventory().getItemInMainHand();
		inHand.setDurability((short)0);
		
		return true;
	}

}
