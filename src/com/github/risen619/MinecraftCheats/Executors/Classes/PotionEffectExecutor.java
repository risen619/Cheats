package com.github.risen619.MinecraftCheats.Executors.Classes;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.risen619.MinecraftCheats.Argument.Command;

public abstract class PotionEffectExecutor extends Executor
{
	protected enum AddEffectResult
	{
		REMOVED,
		ADDED_FOREVER,
		ADDED
	}
	
	protected int defaultAmplifier = 10;
	protected int defaultDuration = Integer.MAX_VALUE;
	
	protected int amplifier = 0;
	protected int duration = 0;
	
	protected int amplifier() { return this.amplifier; }
	protected boolean amplifier(int a)
	{
		this.amplifier = a;
		return amplifierValid();
	}

	protected int duration() { return this.duration; }
	protected boolean duration(int d)
	{
		this.duration = d;
		return durationValid();
	}
	
	public PotionEffectExecutor() { this(Integer.MAX_VALUE, 10); }
	
	public PotionEffectExecutor(int duration, int amplifier)
	{
		super(3);
		this.defaultAmplifier = amplifier;
		this.defaultDuration = duration;
	}
	
	protected void reset()
	{
		duration = defaultDuration;
		amplifier = defaultAmplifier;
	}
	
	protected void restoreFlySpeed() { player().setFlySpeed(0.15f); }
	
	protected void increaseFlySpeed()
	{
		float s = MathHelpers.clamp(0.15f, 1.0f, 0.15f * (amplifier / 2.0f));
		player().setFlySpeed(Float.min(0.75f, s));
	}

	protected void decreaseFlySpeed()
	{
		float s = MathHelpers.clamp(0.01f, 0.15f, (0.15f / (amplifier <= 0.0f ? 15.0f : amplifier)));
		player().setFlySpeed(Float.max(0.01f, s));
	}
	
	protected AddEffectResult addEffect(Player p, PotionEffectType pet)
	{
		if(player().getPotionEffect(pet) != null)
		{
			player().removePotionEffect(pet);
			if(duration == Integer.MAX_VALUE)
				return AddEffectResult.REMOVED;
		}
		
		PotionEffect pe = new PotionEffect(pet, duration, amplifier);
		player().addPotionEffect(pe);
		return duration == Integer.MAX_VALUE ? AddEffectResult.ADDED_FOREVER : AddEffectResult.ADDED;
	}
	
	protected AddEffectResult addEffect(PotionEffectType pet) { return addEffect(player(), pet); }
	
	protected boolean durationValid()
	{
		if(duration < 0)
		{
			cm.sendError(player, "Duration cannot be negative!");
			return false;
		}
		return true;
	}
	
	protected boolean amplifierValid()
	{
		if(amplifier <= 0)
		{
			cm.sendError(player, "Amplifier must be greater than 0!");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean afterCommand(CommandSender s, Command c, String l, String[] args)
	{
		reset();
		
		player((Player)s);
		try { meOrOnlineOne(c.getArgument("player").value()); }
		catch(NullPointerException e) { return true; }
		
		try
		{
			if(c.hasArgument("amplifier") && c.getArgument("amplifier").value() != null &&
				!amplifier(Integer.parseInt( c.getArgument("amplifier").value() ))
			)
				return true;
			
			if(c.hasArgument("duration") && c.getArgument("duration").value() != null &&
				!duration(20 * Integer.parseInt( c.getArgument("duration").value() ))
			)
				return true;
		}
		catch(NumberFormatException e) { return false; }
		
		return onPotionEffectCommand(s, c, l, args);
	}
	
	public abstract boolean onPotionEffectCommand(CommandSender s, Command c, String l, String[] args);
}