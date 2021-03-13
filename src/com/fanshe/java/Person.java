package com.fanshe.java;
/*
 * javaBean:
 * 1.类是公共的
 * 2.类中提供公共权限的空参构造器
 * 3.提供属性，及属性的getter、setter方法
 * 
 * 
 */
public class Person {
	
	private String name;
	public int age;
	
	public Person() {
		super();
		System.out.println("Person().....");
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("Person(String,int).....");
	}
	private Person(String name) {
		super();
		this.name = name;
		System.out.println("Person(String).....");
	}
	
	public void eat(){
		System.out.println("人吃饭");
	}
	
	private void sleep(){
		System.out.println("人睡觉");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
