package com.liuyujie.test;

import java.util.Random;

public class Demo03Random {
    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            int i = new Random().nextInt(5);
            System.out.println(i);
        }
    }
}
