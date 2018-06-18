package com.github.risen619.MinecraftCheats.Argument;

import java.util.regex.Pattern;

public class StringArgument extends Argument
{
	private Pattern pattern;
	
	public StringArgument(String name, Class<?> type, Boolean isRequired, String pattern)
	{
		super(name, type, isRequired);
		if(pattern == null)
			this.pattern = null;
		else this.pattern = Pattern.compile(pattern);
	}

	@Override
	public String validate(String value)
	{
		String sr = super.validate(value);
		if(sr != null) return sr;
		
		if(pattern != null && !pattern.matcher(value).matches())
			return String.format("Argument %s incorrect!", name);

		return "";
	}

}
