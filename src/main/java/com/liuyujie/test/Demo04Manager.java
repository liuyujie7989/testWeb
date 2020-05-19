package com.liuyujie.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Demo04Manager {

    public static void main(String[] args) {
        ArrayList<Integer> list1 =new ArrayList<>();
        list1.add(12);
        list1.add(2);
        list1.add(3);
        list1.add(12);
        list1.remove(0);

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i)==12){
                list1.remove(i);
            }
        }
        System.out.println(list1);


    }




}
