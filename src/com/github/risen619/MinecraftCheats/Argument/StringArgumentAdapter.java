package com.github.risen619.MinecraftCheats.Argument;

import java.util.HashMap;

public class StringArgumentAdapter
{
	public static StringArgument get(HashMap<String, Object> map)
	{
		String name = (String)map.get("name");
		Class<?> type = (Class<?>)map.get("type");
		Boolean isRequired = (Boolean)map.get("isRequired");
		
		String pattern = map.get("arg1") == null ? null : (String)map.get("arg1");
		
		return new StringArgument(name, type, isRequired, pattern);
	}
}