package com.dog;

public class Goods {
    private String name;
    private double age;

    public Goods() {
    }

    public Goods(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public String getGoodsName() {
        return this.name;
    }
}
