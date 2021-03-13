package com.fanshe.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

public class ClassLoaderTest {
	
	/*
	 * 1. .class字节码文件是通过java类的加载器加载到内存中的。
	 * 2.类的加载器分级：引导类加载器、扩展类加载器、系统类加载器
	 * 
	 */
	@Test
	public void test1(){
		//获取系统类加载器
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		//获取扩展类加载器
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);
		
		//无法获取到引导类加载器
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);
		
		//对于自定义类来讲，使用系统类加载器加载的
		ClassLoader loader4 = ClassLoaderTest.class.getClassLoader();
		System.out.println(loader4);
		
		//对于java核心类库来讲，使用引导类加载器加载的
		ClassLoader loader5 = String.class.getClassLoader();
		System.out.println(loader5);
	}
	
	/*
	 * 读取指定配置文件中的信息，使用Properties实现
	 * 1.Properties继承了Hashtable，键和值都是String类型
	 * 2.常使用Properties来处理配置文件
	 * 3.如下有两种方式读取配置信息
	 */
	//方式一：
	@Test
	public void test2() throws Exception{
		
		Properties pros = new Properties();
		//此时的jdbc.properties配置文件默认识别在当前工程下
//		FileInputStream is = new FileInputStream("jdbc.properties");
		FileInputStream is = new FileInputStream("src/jdbc.properties1");
		
		pros.load(is);
		
		String userName = pros.getProperty("username");
		String password = pros.getProperty("password");
		System.out.println(userName + ":" + password);
		
	}
	//方式二：
	@Test
	public void test3() throws Exception{
		Properties pros = new Properties();
		//此时的jdbc.properties1配置文件默认识别在当前工程的src下
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties1");
		
		pros.load(is);
		
		String userName = pros.getProperty("username");
		String password = pros.getProperty("password");
		System.out.println(userName + ":" + password);
	}
}
