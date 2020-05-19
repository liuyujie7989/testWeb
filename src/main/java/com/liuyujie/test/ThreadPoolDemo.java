package com.liuyujie.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.liuyujie.bo.UserEntity;
import com.liuyujie.utils.DXUtil;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuyishou
 * @date 2020/5/13
 * <p>
 * 手动创建线程池
 * 1、借助大名鼎鼎的谷歌开源工具库 Guava，首先引入如下依赖：
 * https://mvnrepository.com/artifact/com.google.guava/guava
 * <dependency>
 * <groupId>com.google.guava</groupId>
 * <artifactId>guava</artifactId>
 * <version>28.2-jre</version>
 * </dependency>
 * 2、然后我就可以使用其提供的ThreadFactoryBuilder类来创建线程工厂了
 */
public class ThreadPoolDemo {
    // 线程数
    public static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        String s = theadTest();
        System.out.println(s);
    }

    public static List<UserEntity> init() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        for (int i = 1; i<= 10001; i++) {
            UserEntity userEntity = new UserEntity("userId" + i,"userName" + i);
            list.add(userEntity);
        }
        return list;
    }
    public static String theadTest() {
        // 使用 ThreadFactoryBuilder 创建自定义线程名称的 ThreadFactory
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("hyn-demo-pool-%d").build();

        // 创建线程池，其中任务队列需要结合实际情况设置合理的容量
        ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL_SIZE,
                30,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        // 新建 1000 个任务，每个任务是打印当前线程名称

        List<UserEntity> listUserEntity = init();
        List<List<UserEntity>> lists = DXUtil.splitList(listUserEntity, 1000);
        for (int i = 0; i < lists.size(); i++) {
            List<UserEntity>list = lists.get(i);
            executor.execute(new UserThread(list));
        }

        System.out.println("=====================");
        // 优雅关闭线程池
        executor.shutdown();
        try {
            executor.awaitTermination(1000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "success";
        // 任务执行完毕后打印"Done"
        //System.out.println("Done");

    }
}
