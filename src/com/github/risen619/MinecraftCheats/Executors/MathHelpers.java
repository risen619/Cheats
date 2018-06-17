package com.github.risen619.MinecraftCheats.Executors;

class MathHelpers
{
	public static int clamp(int min, int max, int obj)
	{
		if(obj > max) return max;
		if(obj < min) return min;
		return obj;
	}
	
	public static float clamp(float min, float max, float obj)
	{
		if(obj > max) return max;
		if(obj < min) return min;
		return obj;
	}
	
}