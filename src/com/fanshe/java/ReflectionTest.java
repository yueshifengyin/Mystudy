package com.fanshe.java;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/*
 * 反射的主要内容：
 * 1.反射的概述（反射：动态性，反射能做什么？相关api）
 * 2.Class的理解和如何获取Class的实例（重点）
 * 3.类的加载过程与类的加载器
 * 
 * 4.反射的应用一：创建运行时类的对象（重点）
 * 5.反射的应用二：获取运行时类的完整的类的结构：属性、方法、构造器、父类、包、接口、注解、异常。。。。
 * 6.反射的应用三：调用运行时类中指定的结构：属性、方法、构造器（重点）
 * 7.反射的应用四：动态代理 
 * 
 */
public class ReflectionTest {
	/*
	 * 疑问1：开发中，应该如何实例化？（new + 构造器 ； 通过反射的方式）
	 * 总结：创建某个类的对象的方式：
	 * 方式一：new + 构造器 ：出现的频率最高。
	 * 方式二：Xxx类的静态方法，返回Xxx的实例（比如：InetAddress类的getByName()/getLocalHost()
	 * 									Calendar类的getInstance()）
	 *      Xxxs类的静态方法，返回Xxx的实例（Paths的get()返回Path实例）
	 *      XxxFactory、XxxBuilder类的中静态方法，返回Xxx的实例
	 * 
	 * 方式三：通过反射的方式，创建Xxx的实例。当我们在编译期间，无法确定要创建的对象所属的类时，就需要使用反射。<--- 利用反射的动态性
	 * 
	 */
	/*
	 * 疑问2：反射机制的出现，打破了类的封装性？反射与封装性不矛盾！
	 * 反射，描述的是加载到内存中的运行时类，是否可以调用内部结构的操作。可以调用运行时类加载到内存中的结构：包括私有的结构。
	 * 封装性，给类的相关结构设置了访问权限。通过访问权限，我们能看到编译器是否建议我们进行调用。
	 * 
	 * 
	 * 
	 * 
	 */
		//使用反射：
		@Test
		public void test1() throws Exception{
			
			Class<Person> clazz = Person.class;
			//1.
			Person p1 = clazz.newInstance();
			System.out.println(p1);
			//2.
			Field age = clazz.getField("age");
			age.set(p1, 12);
			
			System.out.println(p1);
			//3.
			Method eat = clazz.getMethod("eat");
			eat.invoke(p1);
			
			//**********************
			//通过反射，可以调用运行时类的私有的结构：构造器、属性、方法
			//调用私有的构造器
			Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
			constructor.setAccessible(true);
			Person p2 = constructor.newInstance("Tom");
			System.out.println(p2);
			
			//调用私有的属性
			Field name = clazz.getDeclaredField("name");
			name.setAccessible(true);
			name.set(p2, "Jerry");
			System.out.println(p2);
			
			//调用私有的方法
			Method sleep = clazz.getDeclaredMethod("sleep");
			sleep.setAccessible(true);
			sleep.invoke(p2);
		}
		/*
		 * 1.Class类，看做是反射的源头
		 * 2.如何理解Class？
		 *  编译过程：使用javac.exe命令，对java源文件进行编译，编译后，或生成一个或多个字节码文件。
		 *  运行过程：使用java.exe 命令，将指定的某个字节码文件对应的类加载到内存中（使用类的加载器），
		 *  	        并将此类缓存起来。此时，加载到内中的类，就称为运行时类。此运行时类本身就作为Class的实例。
		 * 
		 * 	比如：Class clazz = Person.class;
		 * 
		 * 3. Class的实例就对应着一个运行时类。
		 * 
		 * 4. 如何获取Class的实例（掌握前三种获取方法）
		 */
		@Test
		public void test2() throws ClassNotFoundException{
			//方式一.调用运行时类的属性：.class
			Class clazz1 = Person.class;
			System.out.println(clazz1);
			
			Class clazz0 = String.class;
			System.out.println(clazz0);
			
			//方式二：调用运行时类的对象的getClass()
			Person p = new Person();
			Class clazz2 = p.getClass();
			
			System.out.println(clazz1 == clazz2);
			
			//方式三：调用Class类的静态方法：forName(String className)
			//能更好的体现反射的动态性，在后续的框架底层中常用
			String className = "com.atguigu.java.Person";
			Class clazz3 = Class.forName(className);
			
			System.out.println(clazz1 == clazz3);
			
			//方式四：通过类的加载器(了解)
			Class clazz4 = ReflectionTest.class.getClassLoader().loadClass("com.atguigu.java.Person");
			System.out.println(clazz1 == clazz4);
		}
		
		//Class的实例除了对应一个运行时类之外，还可以指向哪些结构？
		@Test
		public void test3(){
			Class c1 = Object.class;
			Class c2 = Comparable.class;
			Class c3 = String[].class;
			Class c4 = int[][].class;
			Class c5 = ElementType.class;
			Class c6 = Override.class;
			Class c7 = int.class;
			Class c8 = void.class;
			Class c9 = Class.class;

			
			int[] a = new int[10];
			int[] b = new int[100];
			Class c10 = a.getClass();
			Class c11 = b.getClass();
			// 只要元素类型与维度一样，就是同一个Class
			System.out.println(c10 == c11);

		}
	
}
