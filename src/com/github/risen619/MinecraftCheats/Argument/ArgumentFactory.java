package com.github.risen619.MinecraftCheats.Argument;

import java.util.HashMap;

public class ArgumentFactory
{
	private static ArgumentFactory instance = null;
	
	private ArgumentFactory() {}
	
	public static ArgumentFactory getInstance()
	{
		if(instance == null)
			instance = new ArgumentFactory();
		return instance;
	}
	
	public Argument getArgument(HashMap<String, Object> map)
	{
		Class<?> type = (Class<?>)map.get("type");
		
		if(type.getSuperclass().equals(Number.class))
			return NumberArgumentAdapter.get(map);
		
		if(type.equals(String.class))
			return StringArgumentAdapter.get(map);
		
		return new Argument("", type, false);
	}
	
	public Argument getArgument(String name, Class<?> type, boolean isRequired)
	{
		if(type.equals(Integer.class) || type.equals(Double.class) || type.equals(Float.class))
			return new NumberArgument(name, type, isRequired, false);
		if(type.equals(String.class))
			return new StringArgument(name, type, isRequired, null);
		
		return new Argument(name, type, isRequired);
	}
	
}