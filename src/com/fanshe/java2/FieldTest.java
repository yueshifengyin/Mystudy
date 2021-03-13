package com.fanshe.java2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.fanshe.java1.Person;

/*
 * 反射的应用二：获取运行时类中属性的相关情况
 * 
 */
public class FieldTest {

	@Test
	public void test1() {

		Class clazz = Person.class;

		// getFields():获取运行时类及其所有的父类中声明为public权限的属性
		// Field[] fields = clazz.getFields();
		// for(Field f : fields){
		// System.out.println(f);
		// }
		// getDeclaredFields():获取当前运行时类中声明的所有的属性
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f);
		}
	}

	// 权限修饰符 变量类型 变量名；
	@Test
	public void test2() {
		Class clazz = Person.class;
		
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field f : declaredFields) {
			// 1.权限修饰符
			int modifier = f.getModifiers();
			System.out.print(Modifier.toString(modifier) + "\t");

			// //2.数据类型
			Class type = f.getType();
			System.out.print(type.getName() + "\t");
			//
			// //3.变量名
			String fName = f.getName();
			System.out.print(fName);
			//
			System.out.println();
		}
	}

}
