package com.fanshe.java;

import java.util.Random;

import org.junit.Test;

/*
 * 
 * 反射的应用一：创建运行时类的对象（重点）
 * 
 */
public class InstanceTest {
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException{
		
		Class<Person> clazz = Person.class;
		/*
		 * 调用Class类中的newInstance():创建运行时类的对象
		 * 
		 * 要求运行时类满足:
		 * 1.运行时类需要提供空参的构造器
		 * 2.要求空参的构造器的访问权限要够。
		 */
		Person p = clazz.newInstance();
		System.out.println(p);
		
	}
	
	
	//体会反射的动态性
	@Test
	public void test2() throws Exception{
		
		int randomInt = new Random().nextInt(3);//0,1,2
		String className = "";
		switch(randomInt){
		case 0:
			className = "java.lang.Object";
			break;
		case 1:
			className = "java.util.Date";
			break;
		case 2:
			className = "com.atguigu.java.Person";
			break;
		}
		
		
		Object obj = getInstance(className);
		System.out.println(obj);
		
	}
	
	public Object getInstance(String className) throws Exception{
		Class clazz = Class.forName(className);
		return clazz.newInstance();
	}
	
	
	
}
