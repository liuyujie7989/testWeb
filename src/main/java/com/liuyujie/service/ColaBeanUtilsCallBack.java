package com.liuyujie.service;

@FunctionalInterface
public interface ColaBeanUtilsCallBack<S, T> {

    void callBack(S t, T s);
}
