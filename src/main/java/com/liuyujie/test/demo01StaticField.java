package com.liuyujie.test;

import com.liuyujie.bo.GsonFormatTest;

/**
 * 局部变量和成员变量区别
 * 1、位置不一样  类种方法外  方法内
 * 2、作用范围不一样 局部变量出了方法就不能使用 成员变量 整个类都可以 使用
 * 3、默认值不一样  局部变量没有默认值，成员变量有默认值
 * 4、内存位置不一样    局部变量一般在栈内存中 成员变量在堆内存中
 * 5、生命周期不一样  一般局部变量生命周期比成员变量要短， 局部变量随着方法结束而销毁，成员变量随着对象的消失而销毁
 * <p>
 * 静态不能访问非静态 原因： 内存中先加载的静态 之后有的非静态
 * <p>
 * 静态方法中不能使用this关键字
 * 原因：调用静态方法 不用对象.方法 ，直接使用类名称.方法，而this代表当前对象 相互矛盾 ，静态方法中使用直接编译报错
 * 静态代码块： 当第一次使用到本类是，静态代码块执行唯一的一次。
 * 静态内容总是优于非静态，所以静态代码块比构造方法先执行
 * 如果一个成员被声明为static，它就能够在它的类的任何对象创建之前被访问，而不必引用任何对象
 * 只要这个类被加载，Java虚拟机就能根据类名在运行时内存的方法区中的静态区内定找到他们。
 */

/**
 * 一旦使用了static修饰成员方法，那么久创建了静态方法，静态方法属于类 不属于对象
 * 静态代码块的典型用法： 一次性对静态成员变量赋值
 *
 *
 *
 *              访问权限   类   包  子类  其他包
 *
 *   　　　　  public     ∨   ∨    ∨     ∨      （对任何人都是可用的）
 *
 *    　　　　 protect    ∨   ∨   ∨     ×　　　 （继承的类可以访问以及和private一样的权限）
 *
 *    　　　　 default    ∨   ∨   ×     ×　　　 （包访问权限，即在整个包内均可被访问）
 *
 *    　　　　 private    ∨   ×   ×     ×　　　 （除类型创建者和类型的内部方法之外的任何人都不能访问的元素）
 */
public class demo01StaticField {


    private static String pwd;
    private static   int num;

    public static void main(String[] args) {


        GsonFormatTest gsonFormatTest = new GsonFormatTest();
        GsonFormatTest.room = "4334";
        System.out.println(GsonFormatTest.room);
        gsonFormatTest.method();
        GsonFormatTest gsonFormatTest2 = new GsonFormatTest();
        gsonFormatTest2.method();
        method();
    }

    public static void method() {
            System.out.println(num);
        User user= null;

    }



    }



