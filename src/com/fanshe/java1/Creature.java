package com.fanshe.java1;

import java.io.Serializable;

public class Creature<T> implements Serializable{
	
	private double weight;
	public double height;
	
	public void breath(){
		System.out.println("呼吸");
	}
	
	private void doSport(){
		System.out.println("运动");
	}

}
