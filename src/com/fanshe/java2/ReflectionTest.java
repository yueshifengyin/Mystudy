package com.fanshe.java2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

import com.fanshe.java1.Person;

public class ReflectionTest {
	
	//获取运行时类的构造器
	@Test
	public void test1(){
		
		Class clazz = Person.class;
		//getConstructors():获取运行时类本身声明为public权限的构造器
//		Constructor[] cons = clazz.getConstructors();
//		for(Constructor c : cons){
//			System.out.println(c);
//		}
		//getDeclaredConstructors():获取运行时类中声明的所有的构造器
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor c : cons){
			System.out.println(c);
		}
	}
	
	//获取运行时类实现的接口
	@Test
	public void test2(){
		Class clazz = Person.class;
		
		Class[] interfaces = clazz.getInterfaces();
		for(Class c : interfaces){
			System.out.println(c.getName());
		}
	}
	
	//获取运行时类的父类
	@Test
	public void test3(){
		Class clazz = Person.class;
		
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass.getName());
	}
	
	//获取带泛型的父类
	@Test
	public void test4(){
		Class clazz = Person.class;
		
		Type superclass = clazz.getGenericSuperclass();
		System.out.println(superclass);
	}
	
	/*
	 * 获取父类的泛型
	 * 
	 * 代码：  逻辑性代码    vs  功能性代码
	 */
	@Test
	public void test5(){
		Class clazz = Person.class;
		//获取带泛型的父类
		Type superclass = clazz.getGenericSuperclass();
		//如果父类带泛型了，可以强转为带参数的类型
		ParameterizedType pramType = (ParameterizedType) superclass;
		//获取到了父类的泛型参数
		Type[] typeArguments = pramType.getActualTypeArguments();
		//获取唯一的一个泛型参数
		System.out.println(((Class)typeArguments[0]).getName());
	}
	
	//获取父类的注解
	@Test
	public void test6(){
		Class clazz = Person.class;
		Annotation[] annos = clazz.getAnnotations();
		for(Annotation a :annos){
			System.out.println(a);
		}
	}
	//获取父类所在的包
	@Test
	public void test7(){
		Class clazz = Person.class;
		
		Package pack = clazz.getPackage();
		System.out.println(pack);
	}
}
