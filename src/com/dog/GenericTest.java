package com.dog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 * 泛型在集合中的使用
 * 
 * 1.泛型，是jdk5.0新增的
 * 
 * 2.泛型的核心思想：就是将集中添加的数据限定为具体的类型。
 */
public class GenericTest {
	
	//在集合中使用泛型之前
	@Test
	public void test1(){
		ArrayList list = new ArrayList();
		list.add(67);
		list.add(87);
		list.add(99);
		list.add(78);
		//1.添加数据时：类型不安全
		list.add("AA");
		
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			//2.可能出现类型转换异常
			int score = (int) obj;
			
			System.out.println(score);
		}
		
	}
	/*
	 * 集合中使用泛型的例子1
	 * 
	 * 在集合中使用泛型
	 * 1.之所以能在集合接口或类中使用泛型，就是因为集合接口或类在声明时，使用了泛型。
	 * 	比如：public class ArrayList<E>{}，public interface List<E>
	 *  
	 * 2.实例化集合类时，就可以指明类的泛型。一旦指明以后，通过集合类的对象调用内部的结构时，凡是使用了
	 * 类的泛型的地方，都变化为指定的类的泛型的类型。
	 *  比如：List<Integer> list = new ArrayList<Integer>();导致add(Integer e)、
	 *  Integer<E> iterator();
	 *  
	 * 3.实例化集合类时，如果没有指明类的泛型，则认为此泛型的类型是Object类型。
	 * 
	 * 4.泛型参数在具体指明时，只能使用引用数据类型，不能使用基本数据类型
	 */
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(67);
		list.add(87);
		list.add(88);
//		list.add("BB");
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			int score = iterator.next();
			
			System.out.println(score);
		}
	}
	
	//集合中使用泛型的例子2
	@Test
	public void test3(){
		
		Map<String,Integer> map = new HashMap<String,Integer>();
//		Map<String,Integer> map = new HashMap<>();//jdk7.新增类型推断。 比如：int[] arr = {1,2,3};
		
		map.put("MM", 78);
		map.put("JJ", 89);
		map.put("GG", 66);
		map.put("DD", 54);
//		map.put(12, "AA");
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<String, Integer> entry = iterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "--->" + value);
		}
	}
	
	//使用上泛型以后的自然排序
	@Test
	public void test4(){
		
		TreeSet<Goods> set = new TreeSet<>();
		
		Goods g1 = new Goods("eggs", 10.5);
		Goods g2 = new Goods("banana", 7.5);
		Goods g3 = new Goods("apple", 2.5);
		Goods g4 = new Goods("orange", 4.3);
		
		
		set.add(g1);
		set.add(g2);
		set.add(g3);
		set.add(g4);
		
		for(Goods g : set){
			System.out.println(g);
		}
		
		
	}
	
	//使用上泛型以后的定制排序
	@Test
	public void test5(){
		
		Comparator<Goods> com = new Comparator<Goods>(){

			@Override
			public int compare(Goods o1, Goods o2) {
				
				return o1.getGoodsName().compareTo(o2.getGoodsName());
				
			}
			
		};
		
		
		TreeSet<Goods> set = new TreeSet<>(com);
		
		Goods g1 = new Goods("eggs", 10.5);
		Goods g2 = new Goods("banana", 7.5);
		Goods g3 = new Goods("apple", 2.5);
		Goods g4 = new Goods("orange", 4.3);
		
		
		set.add(g1);
		set.add(g2);
		set.add(g3);
		set.add(g4);
		
		for(Goods g : set){
			System.out.println(g);
		}
		
		
	}
}
