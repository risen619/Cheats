package com.github.risen619.MinecraftCheats.Executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HatExecutor extends Executor
{
	public HatExecutor() { super(1); }
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args)
	{
		if(args.length > argsNumber) return false;
		args = parseArgs(args);

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
