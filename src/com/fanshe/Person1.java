package com.fanshe;


public class Person1{

    private String name;
    public int age;
    public int id;

    public Person1(){

    }

    private Person1(String name){
        this.name = name;
    }

    private Person1(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void eat(String food){
        System.out.println("我喜欢吃：" + food);
    }

    public void eat(){
        System.out.println("我喜欢吃：shupian");
    }

    private String showNation(String nation) throws RuntimeException{
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    void sleep(){
        System.out.println("人睡觉");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
    }


}