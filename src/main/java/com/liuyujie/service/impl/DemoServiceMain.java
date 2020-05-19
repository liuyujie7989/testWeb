package com.liuyujie.service.impl;

import com.liuyujie.bo.UserList;
import com.liuyujie.service.DemoService01;

public class DemoServiceMain {
    public static void main(String[] args) {
        System.out.println(DemoService01.a);
        DemoService01.staticMethod();

        UserList list = new UserList();
        System.out.println(list.getUsers());


        for (int i = 0; i < 100000; i++) {
            System.out.println("1");
        }

    }


    public void test() {

    }
}