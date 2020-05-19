package com.liuyujie.test;

import com.liuyujie.bo.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyishou
 * @date 2020/5/15
 */
public class UserThread implements Runnable {

    /**
     * 接收数据
     */
    List<UserEntity> list = new ArrayList<>();

    public UserThread(List<UserEntity> list) {
        this.list = list;
    }
    @Override
    public void run() {
        //这里写执行任务发送短信的逻辑。我这里打印出来看线程效果
        System.out.println(Thread.currentThread().getName());

        //System.out.println(currentThread().getName()+"---"+currentThread().getId()+"---"+list);
    }
}
