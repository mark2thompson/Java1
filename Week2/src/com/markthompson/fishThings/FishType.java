package com.markthompson.fishThings;

public interface FishType {
	
	//set the name of the fish
	public boolean setName(String name);
	//set the max size of the fish
	public boolean setLength(double Length);
	//get the name of the fish
	public String getName();
	//get the size of the fish
	public double getLength();
		
}
