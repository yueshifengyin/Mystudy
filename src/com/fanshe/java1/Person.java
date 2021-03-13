package com.fanshe.java1;


@MyAnnotation(value="abc")
public class Person extends Creature<String> implements Comparable<Integer>,MyInterface{
	
	private String name;
	int age;
	public int id;
	
	public Person(){
		
	}
	
	private Person(String name){
		this.name = name;
	}
	
	private Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat(String food){
		System.out.println("我喜欢吃：" + food);
	}
	@MyAnnotation
	private String showNation(String nation) throws RuntimeException{
		System.out.println("我的国籍是：" + nation);
		return nation;
	}
	
	void sleep(){
		System.out.println("人睡觉");
	}

	@Override
	public int compareTo(Integer o) {
		return 0;
	}

	@Override
	public void run() {
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
}
