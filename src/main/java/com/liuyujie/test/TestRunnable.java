package com.liuyujie.test;

/**
 * @author liuyishou
 * @date 2020/5/13
 */
public class TestRunnable implements Runnable {
    private int count=10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("新线程执行了。。。。"+count--);
        }
    }
}
