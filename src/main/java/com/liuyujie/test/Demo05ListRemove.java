package com.liuyujie.test;

import java.util.ArrayList;

public class Demo05ListRemove {

    static {



    }

    private  String a="";

    public static void main(String[] args) {
        User user = new  User();
        user.setName("3232");
        ArrayList<String> list = new  ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        String remove = list.remove(1);
        System.out.println(remove);

        System.out.println(user.toString());

    }


}
