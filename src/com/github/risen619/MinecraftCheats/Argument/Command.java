package com.github.risen619.MinecraftCheats.Argument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

import com.github.risen619.MinecraftCheats.Main;

public class Command
{
	private PluginCommand command;
	private List<Argument> arguments;

	public PluginCommand command() { return command; }
	public List<Argument> arguments() { return arguments; }
	
	public Command(String name, List<Argument> args, CommandExecutor executor)
	{
		command = Main.getPlugin(Main.class).getCommand(name);
		arguments = args == null ? new ArrayList<Argument>() : args;
		if(executor != null)
			command.setExecutor(executor);
		
		String usage = "/<command> ";
		for(Argument a : arguments)
			usage += a.normalized() + " ";
		command.setUsage(usage);
	}
	
	public Command(String name, CommandExecutor executor) { this(name, null, executor); }
	
	public List<String> validateArguments(String[] args)
	{
		return IntStream.range(0, arguments.size()).mapToObj(i -> arguments.get(i).validate(args[i]))
		.filter(v -> !v.isEmpty()).collect(Collectors.toList());
	}
	
	public boolean hasArgument(String s)
	{
		return getArgument(s) != null;
	}
	
	public Argument getArgument(String s)
	{
		return arguments.stream().filter(v -> v.name().equalsIgnoreCase(s)).findFirst().orElse(null);
	}
	
	public boolean setArgumentValue(String argument, String v)
	{
		Argument a = getArgument(argument);
		
		if(a != null) a.value(v);
		else return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		String s = command.getName() + ": ";
		for(Argument a : arguments)
			s += a.toString() + " ";
		return s;
	}
}