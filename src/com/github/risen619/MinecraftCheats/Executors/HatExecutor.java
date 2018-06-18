package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.Executor;

public class HatExecutor extends Executor
{
	public HatExecutor() { super(1); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		PlayerInventory inv = player().getInventory();
		
		ItemStack inHand = inv.getItemInMainHand();
		inv.setItemInMainHand(inv.getHelmet());
		inv.setHelmet(inHand);
		
		return true;
	}

}
