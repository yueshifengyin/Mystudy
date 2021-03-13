package com.yinyon;

public class  Integer2StringTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 包装类型————>String类型
		Integer i = 10;
		// 方式1：
		String s1 = i.toString();
		// 方式2：
		String s2 = String.valueOf(i);
		// 方式3：
		String s3 = i + "";
		System.out.println(s3 + " s1=" + s1 + "s2=" + s2);
		
		
		
		// String————>包装类
		// 方式1：
		Integer j = new Integer("123");
		// 方式2：
		Integer j2 = Integer.valueOf("3456");

	}

}
