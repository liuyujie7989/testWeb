package com.liuyujie.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateFormat {
    public static void main(String[] args) {
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        System.out.println(dateStr);
        System.out.println(Long.toString(date.getTime()));

    }
}
