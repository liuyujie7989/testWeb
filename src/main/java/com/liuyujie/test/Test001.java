package com.liuyujie.test;

import com.alibaba.fastjson.JSONObject;
import com.liuyujie.bo.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test001 {
    private static Logger logger = LoggerFactory.getLogger(Test001.class);
    public static void main(String[] args) throws ParseException {

     /*   int[] array= new int[15];

        int[] array1={1,3,4,5};
        int length = array1.length;


        List<String> users  = new ArrayList<>();
        List<String> users2  = new ArrayList<>();
        User user = null;
        try {
            System.out.println(user.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.add("2");
        users.add("3");
        users.add("4");
        users.add("5");
        users2.add("users2");


        String title = users.stream().collect(Collectors.joining("-"));
        System.out.println(title);


        Map<String,List<String>> map = new HashMap<>();
        map.put("area",users);
        map.put("area",users2);
        System.out.println(map.toString());*/


        User user1 = null;

         user1 = new User();

        user1.setAge(1);


        Integer age = user1.getAge();
        user1 = new User();
        user1.setAge(23232);
        Integer age1 = user1.getAge();

        System.out.println(age);
        System.out.println(age1);


    }
}
