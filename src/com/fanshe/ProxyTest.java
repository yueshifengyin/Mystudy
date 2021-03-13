package com.fanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 反射的应用四：动态代理
 * 
 * 问题1：如何根据提供的被代理类，动态的创建代理类及其代理类的对象
 * 
 * 问题2：当通过代理类的对象调用方法a时，如何实现动态的调用被代理类对象的方法a
 * 
 */

class HumanUtil{
	
	public void method1(){
		System.out.println("=========通用方法一==========");
	}
	
	public void method2(){
		System.out.println("=========通用方法二==========");
	}
}


interface Human{
	
	String getBelief();
	void eat(String food);
	
}

//被代理类
class SuperMan implements Human{

	@Override
	public String getBelief() {
		return "I believe I can fly!";
	}

	@Override
	public void eat(String food) {
		System.out.println("我喜欢吃：" + food);
	}
	
}

//问题1：如何根据提供的被代理类，动态的创建代理类及其代理类的对象
class MyProxy{
	
	//用于返回一个代理类的对象
	public static  Object getProxyInstance(Object obj){//obj:被代理类的对象
		//参数1：获取被代理类的类的加载器
		//参数2：获取被代理类所实现的接口
		//参数3：InvocationHandler接口的实现类的对象
		MyInvocationHandler handler = new MyInvocationHandler(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), handler);
	}
}
//问题2：当通过代理类的对象调用方法a时，如何实现动态的调用被代理类对象的方法a
class MyInvocationHandler implements InvocationHandler{
	private Object obj;//被代理类的对象
	public MyInvocationHandler(Object obj2) {
		this.obj = obj2;
	}
	/*
	 * 1.当通过代理类的对象调用接口中的方法a时，就会转换为调用如下的invoke()
	 * 2.需要将被代理类对象的方法a的调用声明在invoke()
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		HumanUtil humanUtil = new HumanUtil();
		humanUtil.method1();
		
		//执行被代理类对象的方法
		Object returnValue = method.invoke(obj, args);
		
		humanUtil.method2();
		
		return returnValue;
	}
	
}

public class ProxyTest {
	public static void main(String[] args) {
		
		//
		SuperMan man = new SuperMan();
		Object proxyInstance = MyProxy.getProxyInstance(man);
		Human human = (Human) proxyInstance;
		
		String belief = human.getBelief();//通过代理类对象调用getBelief()转换为调用SuperMan中的getBelief()
		System.out.println(belief);
		
		human.eat("四川麻辣烫");
		
		//***********************
		NikeClothFactory nike = new NikeClothFactory();
		ClothFactory proxy = (ClothFactory) MyProxy.getProxyInstance(nike);
		proxy.produceCloth();
	}
}
