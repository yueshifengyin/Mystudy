package com.fanshe;

/*
 * 静态代理
 * 
 * 举例一：如下
 * 举例二：实现Runnable接口的方式就是静态代理
 * 
 * 代理类：Thread
 * 被代理类：提供实现了Runnable接口的类
 * 
 * main(){
 * 		1.创建被代理类的对象obj
 * 		2.Thead t1 = new Thread(obj)
 * 		3.t.start(); --->t.run() ----> obj.run();
 * }
 * 
 * 
 */

interface ClothFactory{
	
	void produceCloth();
	
}

//被代理类
class NikeClothFactory implements ClothFactory{

	@Override
	public void produceCloth() {
		System.out.println("Nike生产了一批运动鞋");
	}
	
}

//代理类
class ProxyClothFactory implements ClothFactory{

	ClothFactory factory;//使用被代理类的对象进行实例化
	
	public ProxyClothFactory(ClothFactory factory){
		this.factory = factory;
	}
	
	@Override
	public void produceCloth() {
		
		System.out.println("代理工厂做前期的准备工作");
		
		factory.produceCloth();
		
		
		System.out.println("代理工厂进行后期的收尾工作");
		
	}
	
}

public class StaticProxyTest {
	public static void main(String[] args) {
		
		//创建被代理类的对象
		NikeClothFactory nike = new NikeClothFactory();
		//创建代理类的对象
		ProxyClothFactory proxy = new ProxyClothFactory(nike);
		//调用代理类的方法
		proxy.produceCloth();
		
	}
}
