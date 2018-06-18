package com.github.risen619.MinecraftCheats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.github.risen619.MinecraftCheats.Argument.Argument;
import com.github.risen619.MinecraftCheats.Argument.ArgumentFactory;
import com.github.risen619.MinecraftCheats.Argument.CheckHelpers;

public class CommandParser
{	
	private String normalizeArg(String s) { return s.replaceAll("[<>\\[\\]]", ""); }
	
	private Argument parseArgument(String s)
	{
		HashMap<String, Object> map = new HashMap<>();
		CommandParser cp = new CommandParser();
		String[] parts = s.split("/");
		for(int i = 0; i < parts.length; i++)
			parts[i] = cp.normalizeArg(parts[i]).toLowerCase();
		
		boolean isRequired = s.startsWith("<") && s.endsWith(">");
		String name = cp.normalizeArg(parts[0]);
		Class<?> type = String.class;
		if(parts.length > 1)
		{
			type = CheckHelpers.typeConverter.get(parts[1]);
			if(parts.length > 2)
				map.put("arg1", parts[2]);
		}
		
		map.put("name", name);
		map.put("type", type);
		map.put("isRequired", isRequired);
		
		return ArgumentFactory.getInstance().getArgument(map);
	}
	
	public static List<Argument> parseCommandUsage(String command)
	{
		String usage = Main.getPlugin(Main.class).getCommand(command).getUsage();
		CommandParser cp = new CommandParser();
		ArrayList<String> args = new ArrayList<String>();
		for(String s : usage.split(" ")) args.add(s);
		args.remove(0);
		
		return args.stream().map(v -> cp.parseArgument(v)).collect(Collectors.toList());
	}
}