package com.liuyujie.service;

public interface DemoService01 {
    /**
     * java7   接口中只有常量和抽象方法
     * java8   接口中 还可以有默认方法和静态方法
     * java9  接口中还可以有 私有方法
     * <p>
     * <p>
     *  如果实现类没有覆盖重写接口中所有的抽象方法，那么这个实现类必须是抽象类
     *
     *  多个 父接口当中的抽象方法重复 没关系
     *  多个父接口中的默认方法重复，那么子接口中必须进行父接口中的默认方法覆盖重新，必须带有default关键字
     */

//抽象方法
    abstract void test01();

    abstract void test02();

    //默认方法 可以有方法体,默认方法可以解决接口升级（）
    //接口的默认方法，可以通过接口的实现类对象直接调用，可无需重写
    //接口的默认方法也可以被实现类覆盖重写

    public default void defaultMethod() {
        System.out.println("默认方法...");
    }

    /**
     * java 8开始接口容许定义静态方法
     * 使用方法 接口名称.静态方法（不能通过接口实现类的对象调用）
     */
    public static void staticMethod() {
        System.out.println("接口的静态方法执行了。。。");
    }

    /**
     *
     */
    public static  String a="aaaaaa";

    /**
     * java 9 可以定义私有方法
     *  private的方法只有接口自己调用，不能被实现类或别人使用
     */


}
