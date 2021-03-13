package com.fanshe.java2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.fanshe.java1.Person;

/*
 * 反射的应用三：调用运行时类中指定的结构：属性、方法、构造器（重点）
 */
public class ReflectionTest1 {
	
	
	//调用运行时类中指定的构造器
	@Test
	public void test1() throws Exception{
		Class clazz = Person.class;
		//public Person(String name){}
		//1.getDeclaredConstructor(Class ... clazzs):获取运行时类中指定的构造器
		Constructor con = clazz.getDeclaredConstructor(String.class);
		//2.保证此构造器是可访问的
		con.setAccessible(true);
		//3.newInstance(Object ... objs):调用此方法，创建运行时类的对象。
		Object obj = con.newInstance("Tom");
		Person p = (Person) obj;
		
		System.out.println(p);
		
		//***************************************
		Constructor con1 = clazz.getDeclaredConstructor(String.class,int.class);
		con1.setAccessible(true);
		Person p1 = (Person) con1.newInstance("Jerry",12);
		System.out.println(p1);
	}
	
	//调用指定的属性
	@Test
	public void test2() throws Exception{
		Class clazz = Person.class;
		//创建运行时类的对象
		Person p1 = (Person) clazz.newInstance();
		
		//private String name;
		//1.getDeclaredField(String fieldName):获取指定fieldName的属性
		Field name = clazz.getDeclaredField("name");
		//2.保证此属性是可访问的
		name.setAccessible(true);
		//3.
		//3.1 设置指定对象的此属性的值
		name.set(p1, "Tom");
		
		//3.2 获取指定对象的此属性的值
		System.out.println(name.get(p1));
		
		
	}
	//调用指定的方法
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//创建运行时类的对象
		Person p1 = (Person) clazz.newInstance();
		
		//private String showNation(String nation)
		//1.getDeclaredMethod(String methodName,Class ... params):获取指定参数的方法
		Method showNation = clazz.getDeclaredMethod("showNation",String.class);
		
		//2.保证此方法是可访问的
		showNation.setAccessible(true);
		
		//3.调用此方法:invoke(Object obj,Object ... paramValues)
		//invoke()的返回值即为要调用运行时类中的指定的方法的返回值
		Object returnValue =  showNation.invoke(p1, "CHN");
		System.out.println(returnValue);
		
	}
}
