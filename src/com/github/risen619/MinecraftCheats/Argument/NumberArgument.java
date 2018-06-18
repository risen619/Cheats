package com.github.risen619.MinecraftCheats.Argument;

public class NumberArgument extends Argument
{
	private boolean shouldBePositive = false;
	
	public void shouldBePositive(boolean state) { this.shouldBePositive = state; }
	public boolean shouldBePositive() { return shouldBePositive; }
	
	public NumberArgument(String name, Class<?> type, Boolean isRequired, Boolean shouldBePositive)
	{
		super(name, type, isRequired);
		shouldBePositive(shouldBePositive == null ? false : shouldBePositive);
	}
	
	public String validate(String value)
	{
		String sr = super.validate(value);
		if(sr != null) return sr;
		
		if(type.equals(Integer.class) && !CheckHelpers.isInteger(value, shouldBePositive))
			return name + " should be a " + (shouldBePositive ? "positive " : "") + "number!";
		
		if( (type.equals(Float.class) || type.equals(Double.class)) && !CheckHelpers.isDouble(value, shouldBePositive))
			return name + " should be a " + (shouldBePositive ? "positive " : "") + "decimal number!";
		
		return "";
	}
}