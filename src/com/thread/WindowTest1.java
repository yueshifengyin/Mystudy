package com.thread;


import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.objects.XObject;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

public class WindowTest1 {
    public static void main(String[] args) {
//        Window w = new Window();
//
//        Thread t1 = new Thread(w);
//        Thread t2 = new Thread(w);
//        Thread t3 = new Thread(w);
//
//        t1.setName("窗口1");
//        t2.setName("窗口2");
//        t3.setName("窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();

        ArrayList<Object> lst = new ArrayList<>();
        lst.add("Q123");
        lst.add("W123");
        lst.add("E123");
        lst.add("R123");
        lst.add("A123");

        lst.forEach(System.out::println);

    }
}



class Window implements Runnable{

    static int ticket = 100;

    @Override
    public void run() {

        while(true){
            synchronized (this){
                if(ticket > 0){
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }



        }

    }

}
