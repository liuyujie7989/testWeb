package com.liuyujie.controller;

import com.liuyujie.bo.Person;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        Integer a=9;
        double b=  6.705;
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format((double)b / a);

        //System.out.println(format);

        BigDecimal bigDecimal1 = BigDecimal.valueOf((double) b / a).setScale(2, BigDecimal.ROUND_HALF_UP);

        //System.out.println(bigDecimal1);



    }
}
