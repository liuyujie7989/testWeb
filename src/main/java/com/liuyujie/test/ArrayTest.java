package com.liuyujie.test;

import com.alibaba.fastjson.JSON;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5,6};
        int[] array2={};

        for (int i = 0; i < array1.length/2; i++) {
            int temp=array1[i];
            array1[i]=array1[array1.length-i-1];
            array1[array1.length-i-1]=temp;
        }

        System.out.println(JSON.toJSONString(array1));
    }
}
