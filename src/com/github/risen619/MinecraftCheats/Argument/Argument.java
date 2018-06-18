package com.github.risen619.MinecraftCheats.Argument;

public class Argument
{
	protected String name;
	protected Class<?> type;
	protected Boolean isRequired;
	
	protected transient String value;
	
	public String name() { return name; }
	public Class<?> type() { return type; }
	public Boolean isRequired() { return isRequired; }
	public String value() { return value; }
	
	public void value(String v) { value = v; }
	
	public Argument(String name, Class<?> type, Boolean isRequired)
	{
		this.name = name;
		this.type = type;
		this.isRequired = isRequired;
	}
	
	public String validate(String value)
	{
		if(value == null)
		{
			if(isRequired) return name + " is required!";
			else return "";
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{ return String.format("[%s: %s%s]=[%s]", type.getSimpleName(), name, isRequired ? "(required)" : "", value); }
	
	public String normalized() { return String.format(isRequired ? "<%s>" : "[%s]", name); }
	
}