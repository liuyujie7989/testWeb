package com.liuyujie.test;

import com.alibaba.fastjson.JSON;
import com.liuyujie.bo.UserList;
import com.liuyujie.utils.DXUtil;

import java.util.ArrayList;
import java.util.List;

public class test002 {
    public static void main(String[] args) {
        UserList userList = new UserList();

        com.liuyujie.bo.User user = new com.liuyujie.bo.User();
       /* com.liuyujie.bo.User user = new com.liuyujie.bo.User();
        List<com.liuyujie.bo.User> list = new ArrayList<>();
        list.add(user);
        userList.setUsers(list);
        System.out.println(userList);
        System.out.println(userList.getUsers()==null);
        System.out.println(user==null);*/

       int a =5;
       int b=6;
        if (a == 5) {
            System.out.println("1");
        } else if (b==6) {
            System.out.println("2");
        }
        com.liuyujie.bo.User user1 = new com.liuyujie.bo.User();

        user1.setName("323232");

        System.out.println(JSON.toJSONString(user1));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");

        List<List<String>> lists = DXUtil.splitList(strings, 4);
        System.out.println(lists.size());
        System.out.println(lists);


    }
}
