package com.liuyujie.test;

import com.liuyujie.bo.UserEntity;
import com.liuyujie.utils.DXUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyishou
 * @date 2020/5/15
 */
public class DXThrend {
    public static void main(String[] args) {

        // 1.初始化用户数据，添加用户数据，这里为模拟数据，实际情况是在数据库拿的
        List<UserEntity> listUserEntity = init();
        // 2.计算创建创建多少个线程并且每一个线程需要执行“分批发送短信用户”
        // 每一个线程分批跑多少
        int userThreadPage = 1000;
        // 计算所有线程数，listUserEntity.size / userThreadPage  =  需要开启的线程数
        // 把数据分到n个小集合中，一个集合等于一个线程的数据
        List<List<UserEntity>> splitUserList = DXUtil.splitList(listUserEntity, userThreadPage);
        int threadSaze = splitUserList.size();
        //循环创建线程
        for (int i = 0; i<threadSaze; i++) {
            List<UserEntity>list = splitUserList.get(i);
            // 3.创建线程并执行任务发送短信
            new Thread(new UserThread(list)).start();
        }

    }

    /**
     * 初始化数据，这里为模拟数据，实际情况是在数据库拿的
     * @return
     */
    public static List<UserEntity> init() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        for (int i = 1; i<= 10001; i++) {
            UserEntity userEntity = new UserEntity("userId" + i,"userName" + i);
            list.add(userEntity);
        }
        return list;
    }

}
