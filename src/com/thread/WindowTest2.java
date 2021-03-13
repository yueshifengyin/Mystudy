package com.thread;
/*
 * 模拟车站三个窗口售票，总票数为100张。
 * 
 * 使用同步代码块解决继承Thread方式的线程安全问题
 * 
 * 注意:同步监视器慎重this.
 */

class Window2 extends Thread{
	
	static int ticket = 100;
	static Object obj = new Object();
	
	@Override
	public void run() {
		
		while(true){
			
			//错误的：
//			synchronized (this) {//this:代表了w1,w2,w3
			//正确的：
//			synchronized(obj){//使用static修饰以后obj，是唯一的。
			synchronized(Window2.class){//Class cla = Window2.class;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (ticket > 0) {
					System.out.println(getName() + "售票，票号为：" + ticket);
					ticket--;
				} else {
					break;
				}
			}
			
		}
		
	}
	
}



public class WindowTest2 {
	public static void main(String[] args) {
		
		Window2 w1 = new Window2();
		Window2 w2 = new Window2();
		Window2 w3 = new Window2();
		
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		
		w1.start();
		w2.start();
		w3.start();
		
	}
}
