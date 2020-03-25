package com.liuyujie.utils;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        String s = String.valueOf(now.get(Calendar.YEAR));
        String s1 = now.get(Calendar.MONTH) + 1 + "";
        System.out.println(s);
        System.out.println(s1);
    }
}
