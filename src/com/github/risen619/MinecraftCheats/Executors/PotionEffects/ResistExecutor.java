package com.github.risen619.MinecraftCheats.Executors.PotionEffects;

import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.Argument.Command;
import com.github.risen619.MinecraftCheats.Executors.Classes.PotionEffectExecutor;

public class ResistExecutor extends PotionEffectExecutor {

	@Override
	public boolean onPotionEffectCommand(CommandSender s, Command c, String l, String[] args)
	{
		addEffect(PotionEffectType.DAMAGE_RESISTANCE);
		return true;
	}

}
