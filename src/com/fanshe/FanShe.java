package com.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FanShe {

    public static void main(String[] args) throws Exception {
        Class<Person1> clazz = Person1.class;
        Person1 p1 = clazz.newInstance();
        Field age = clazz.getField("age");
        age.set(p1,12);
        System.out.println(p1.age);

        Method eat = clazz.getMethod("eat");
        eat.invoke(p1);

        Constructor<Person1> constructor = clazz.getDeclaredConstructor( String.class);
        constructor.setAccessible(true);
        Person1 p2 = constructor.newInstance("Tom");
        System.out.println(p2);



    }

}
