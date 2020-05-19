package com.liuyujie.test;

/**
 * @author liuyishou
 * @date 2020/5/13
 */
public class TestRunnableMain {
    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();
        Thread t1 = new Thread(testRunnable);
        t1.start();

    }
}
