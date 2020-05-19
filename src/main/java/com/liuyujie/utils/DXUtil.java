package com.liuyujie.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyishou
 * @date 2020/5/15
 */
public class DXUtil {
    /**
     * 类似与分页的数据处理工具类
     * @param list
     * @param pageSize
     * @param <T>
     * @return
     */

    static public <T> List<List<T>> splitList(List<T>list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>>listArray = new ArrayList<List<T>>();
        for (int i = 0; i<page; i++) {
            List<T>subList = new ArrayList<T>();
            for (int j = 0; j<listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
