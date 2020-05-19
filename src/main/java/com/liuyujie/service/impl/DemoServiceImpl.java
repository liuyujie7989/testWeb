package com.liuyujie.service.impl;

import com.liuyujie.service.DemoService01;

/**
 * 1、如果实现类没有覆盖重写接口中所有的抽象方法，那么这个实现类必须是抽象类
 * 2、如果实现类所实现的多个接口中有重复的默认方法时，实现类实现接口必须要对冲突的默认方法覆盖重写
 * 3、如果实现类所实现的多个接口中重复的抽象方法时，实现类只需要重写一次就可以
 * 4、接口是没有静态代码块和构造方法的
 * 5、一个类继承父类并且实现一个接口，父类中的方法和接口中的默认方法重复时，优先使用父类方法
 */
public  class DemoServiceImpl implements DemoService01 {


    @Override
    public void test01() {

    }

    @Override
    public void test02() {

    }
}
