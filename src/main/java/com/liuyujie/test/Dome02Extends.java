package com.liuyujie.test;


import com.liuyujie.bo.Zi;

/**
 *子类构造方法中有一个默认的 super() 调用，所以 new 子类对象时候一定是先调用的父类的构造方法，
 * 后执行的子类构造方法
 * super()  就是调用的父类构造
 * 还可以使用 super() 调用父类的重载构造
 * 在父子继承关系中，创建子类对象，访问成员方法，创建的对象是谁 则优先用谁，没有则向上找
 */
public class Dome02Extends {
    public static void main(String[] args) {
        Zi fuzi = new Zi();

    }

}
