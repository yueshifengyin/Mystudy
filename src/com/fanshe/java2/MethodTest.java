package com.fanshe.java2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.fanshe.java1.Person;

/*
 * 反射的应用二：获取运行时类中方法的相关情况
 * 
 */
public class MethodTest {
	
	@Test
	public void test1(){
		
		Class clazz = Person.class;
		//getMethods():获取运行时类及其所有的父类中声明为public权限的方法
//		Method[] methods = clazz.getMethods();
//		for(Method m : methods){
//			System.out.println(m);
//		}
		//getDeclaredMethods():获取运行时类声明的所有的方法
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods){
			System.out.println(m);
		}
		
	}
	//注解
	//权限修饰符  返回值类型  方法名(形参类型1 形参名1,形参类型2 形参名2,...) throws 异常类型1,异常类型2,... {}
	@Test
	public void test2(){
		Class clazz = Person.class;
		
		Method[] declaredMethods = clazz.getDeclaredMethods();
		
		for (Method m : declaredMethods) {
			// 1.获取方法声明的注解
			Annotation[] annos = m.getAnnotations();
			for (Annotation a : annos) {
				System.out.println(a);
			}

//			// 2.权限修饰符
			System.out.print(Modifier.toString(m.getModifiers()) + "\t");
//
//			// 3.返回值类型
			System.out.print(m.getReturnType().getName() + "\t");
//
//			// 4.方法名
			System.out.print(m.getName());
			System.out.print("(");
//			// 5.形参列表
			Class[] parameterTypes = m.getParameterTypes();
			if (!(parameterTypes == null && parameterTypes.length == 0)) {
				for (int i = 0; i < parameterTypes.length; i++) {

					if (i == parameterTypes.length - 1) {
						System.out.print(parameterTypes[i].getName() + " args_" + i);
						break;
					}

					System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
				}
			}
//
			System.out.print(")");
//
//			// 6.抛出的异常
			Class[] exceptionTypes = m.getExceptionTypes();
			if (exceptionTypes.length > 0) {
				System.out.print("throws ");
				for (int i = 0; i < exceptionTypes.length; i++) {
					if (i == exceptionTypes.length - 1) {
						System.out.print(exceptionTypes[i].getName());
						break;
					}

					System.out.print(exceptionTypes[i].getName() + ",");
				}
			}

			System.out.println();
		}
	}
}
