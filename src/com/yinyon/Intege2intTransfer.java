package com.yinyon;

public class Intege2intTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//演示int --> Integer 自动装箱
		
		int m = 10;
		Integer i1 = m; //底层是 Integer.valueOf(m);
		
		//演示Integer --> int 自动拆箱
		
		Integer integer = new Integer(100);
		int n = integer; //底层 integer.intValue();
		
		System.out.println("i1=" + i1 + "n=" + n);
		
		//说明
		//1. integer.intValue() + 10;
		System.out.println(integer + 10); 
	}

}
