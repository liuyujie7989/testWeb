package com.liuyujie.controller;

import com.liuyujie.bo.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        List<Person> list = new ArrayList<Person>();
       //Person person = new Person();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setAge(i);
            person.setName("hehe");
            list.add(person);
            person.setAge(5);
            person.setName("haha");
            System.out.println(list.toString());
        }

        System.out.println(list.toString());
     /*   for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if ("3".equals(list.get(i))) {
                list.remove(i);
            }

    }    }
        int age1=0;
        int age2=0;
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
        Person person1 = iterator.next();
        if ("d".equals(person.getName())) {
        age1= person.getAge();
        iterator.remove();
        }
        if ("b".equals(person.getName())) {
        age2= person.getAge();
        iterator.remove();
        }
        }
        for (int i = 0; i < list.size(); i++) {
        if ("a".equals(list.get(i).getName())) {
        list.get(i).setAge(age1+list.get(i).getAge());
        }
        if ("c".equals(list.get(i).getName())) {
        list.get(i).setAge(age2+list.get(i).getAge());
        }
        }
       /* System.out.println(list.toString());
        System.out.println(age1);*/
    }
}
