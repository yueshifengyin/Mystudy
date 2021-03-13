package com.dog;

import java.util.Objects;
import java.util.SplittableRandom;

public class TestPerson {
    public static void main(String[] args) {
        Computer computer = new Computer();
//        Person person1 = new Person("小明",'男',computer);
//        Person person2 = new Person("小明",'男',computer);
//        System.out.println(person1.equals(person2));
    }
}

class Computer {
    private String brand;

    private double price;

    public Computer() {
    }

    public Computer(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return price == computer.price &&
                Objects.equals(brand, computer.brand);
    }

}

class Person {
    private String name;
    private char sex;
    private Computer computer;

    public Person() {
    }

    public Person(String name, char sex, Computer computer) {
        this.name = name;
        this.sex = sex;
        this.computer = computer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sex == person.sex &&
                name.equals(person.name) &&
                computer.equals(person.computer);
    }

}