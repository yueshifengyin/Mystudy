package com.singleton;

public class SingleTonTest {
    public static void main(String[] args) {
        SingleTon instance1 = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance1 == instance2);

        SingleTon1 instance3 = SingleTon1.getInstance();
        SingleTon1 instance4 = SingleTon1.getInstance();
        System.out.println(instance3 == instance4);
        System.out.println(E03.num);

    }
}

//饿汉模式
class SingleTon{
    private SingleTon() {
    }
    private static SingleTon instance = new SingleTon();

    public static SingleTon getInstance(){
        return instance;
    }
}

//懒汉模式
class SingleTon1{
    private SingleTon1() {
    }
    private static SingleTon1 instance = null;

    public static SingleTon1 getInstance(){
        if (instance == null){
            instance = new SingleTon1();
        }
        return instance;
    }
}

class E03 {
    public final static int num = 200;
    static {
        System.out.println("E03 静态代码块被执行");
    }
}