package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.github.risen619.MinecraftCheats.Argument.Command;

public class HatExecutor extends Executor
{
	public HatExecutor() { super(1); }
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		player((Player)s);
		try { meOrOnlineOne(args[0]); }
		catch(NullPointerException e) { return true; }
		
		PlayerInventory inv = player().getInventory();
		
		ItemStack inHand = inv.getItemInMainHand();
		inv.setItemInMainHand(inv.getHelmet());
		inv.setHelmet(inHand);
		
		return true;
	}

}
