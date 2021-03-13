package com.yinyon;

public class WrapperExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//说明
		//1. 三目运算是一个整体，因此整个结果会提升精度Double 1.0
		//2. 所有的包装类，重写了toString方法，因此会输出值
		Object obj1 = true? new Integer(1) : new Double(2.0);
		System.out.println(obj1);// 1.0 

	}

}
