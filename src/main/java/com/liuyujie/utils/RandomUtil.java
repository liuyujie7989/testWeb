package com.liuyujie.utils;


import com.ohaotian.plugin.db.Sequence;

public class RandomUtil {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Sequence sequence = Sequence.getInstance();
            long l = sequence.nextId();
            System.out.println(l);

        }

    }
}
