package com.suanfa;

public class MaoPao {

    public static int[] maopao(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1 ;  i++) {
            int temp = 0;
            for (int j = 0; j < arr.length - 1 - i ;  j++) {
                //把两个相邻的数进行比较，如果发现，前面的数大于后面的数，则交换
                if (arr[j] > arr[j+1]) {
                    flag = true; //交换过一次
                    temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if (flag == false) { // 一次都没有交换
                break;
            }else {
                flag = false; //重置，进行下次判断
            }
        }
        return arr;
    }
}