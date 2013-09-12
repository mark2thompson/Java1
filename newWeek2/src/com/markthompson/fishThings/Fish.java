/*
 * project		Week2
 * 
 * package		com.markthompson.fishThings
 * 
 * @author		Mark Thompson
 * 
 * date			Aug 15, 2013
 */
package com.markthompson.fishThings;

public class Fish implements FishType {

	String name;
	double length;
	
	public Fish(String name, double Length){
		setName(name);
		setLength(Length);
	}
	@Override
	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	@Override
	public boolean setLength(double length) {
		this.length = length;
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return this.length;
	}

}
