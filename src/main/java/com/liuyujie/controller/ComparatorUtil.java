package com.liuyujie.controller;

import com.liuyujie.bo.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUtil {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("A", 5, "a"),
                new Person("B", 9, "b"),
                new Person("C", 51, "c"),
                new Person("D", 9, "d")
        );


        Collections.sort(list, (Person o1, Person o2)-> {
            System.out.println(o1.toString());
            System.out.println(o2.toString());
                int num=0;
                int a = o1.getAge()-o2.getAge();
                if (a !=0) {
                    num = (a > 0) ? 3 : -1;
                }
            System.out.println(num);
                return num;
            });

        for (Person person : list) {
            System.out.println(person);
        }
    }
}
