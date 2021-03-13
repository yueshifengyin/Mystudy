package com.dog;

import com.suanfa.MaoPao;
import org.junit.Test;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,9};
        for (int i = arr.length-1; i >= 0;i--){
            System.out.print(arr[i] + "\t ");
        }

    }

    @Test
    public void test1(){
        String str1 = "100";
        System.out.println(Integer.parseInt(str1));
        int i = 1;
        i = i++;
        System.out.println(i);
        int arr[] = {1,5,65,45,15,75,65,98,652,65,75,45,65,95,14,11,22};
        int arr1[] = MaoPao.maopao(arr);
        for (int j = 0; j < arr1.length; j++) {
            System.out.print(arr[j] + ", ");
        }

    }




    public class Circle{
        public double radius;
        //周长
        public double perimeter(){
            return 2 * 3.14 * radius;
        }
        //面积
        public double area(){
            return 3.14 * radius * radius;
        }

    }

}

