package com.liuyujie.service;

/**
 * @author liuyishou
 * @date 2020/5/12
 * 接口中定义成员变量 但是必须 使用 public static final 修饰（类似常量）
 * 1、接口当中的常量可以省略 public static final
 * 2、接口中的常量必须赋值
 * 3、接口中常量的名称 完全大写，用下划线进行分隔
 * 访问接口中的常量  接口名.常量
 */
public interface InterfaceConst {
    //一旦赋值不可修改
    public static final int NUM=10;
}
