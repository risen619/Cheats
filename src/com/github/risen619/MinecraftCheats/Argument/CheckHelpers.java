package com.github.risen619.MinecraftCheats.Argument;

import java.util.HashMap;

public class CheckHelpers
{
	public static HashMap<String, Class<?>> typeConverter;

	static {
		typeConverter = new HashMap<>();
		typeConverter.put("integer", Integer.class);
		typeConverter.put("int", Integer.class);
		typeConverter.put("%d", Integer.class);
	
		typeConverter.put("string", String.class);
		typeConverter.put("%s", String.class);
	}
	
	public static boolean isInteger(String s, boolean shouldBePositive)
	{
		if (s == null) return false;
		
	    int length = s.length();
	    if (length == 0) return false;
	    
	    int i = 0;
	    if (s.charAt(0) == '-')
	    {
	    	if(shouldBePositive) return false;
	        if (length == 1) return false;
	        i = 1;
	    }
	    
	    for (; i < length; i++)
	    {
	        char c = s.charAt(i);
	        if (c < '0' || c > '9') return false;
	    }
	    
	    return true;
	}
	
	public static boolean isInteger(String s) { return isInteger(s, false); }
	
	public static boolean isDouble(String s, boolean shouldBePositive)
	{
		if (s == null) return false;
		
	    int length = s.length();
	    if (length == 0) return false;
	    
	    int i = 0;
	    boolean point = false;
	    if (s.charAt(0) == '-')
	    {
	    	if(shouldBePositive) return false;
	        if (length == 1) return false;
	        i = 1;
	    }
	    
	    for(; i < length; i++)
	    {
	    	char c = s.charAt(i);
	    	if(c == '.')
	    	{
	    		if(point) return false;
	    		else point = true;
	    	}
	    	else if(c < '0' || c > '9') return false;
	    }
	    
	    return true;
	}
	public static boolean isDouble(String s) { return isDouble(s, false); }
}


