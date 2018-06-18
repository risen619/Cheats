package com.github.risen619.MinecraftCheats.Argument;

import java.util.HashMap;

public class NumberArgumentAdapter
{
	public static NumberArgument get(HashMap<String, Object> map)
	{
		String name = (String)map.get("name");
		Class<?> type = (Class<?>)map.get("type");
		Boolean isRequired = (Boolean)map.get("isRequired");
		Boolean shouldBePositive = map.get("arg1") == null ? false : true;
		
		return new NumberArgument(name, type, isRequired, shouldBePositive);
	}
}