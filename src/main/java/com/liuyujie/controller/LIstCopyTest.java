package com.liuyujie.controller;

import com.alibaba.fastjson.JSONObject;
import com.liuyujie.bo.ItemAreaSiteNumBO;
import com.liuyujie.bo.ItemAreaSiteNumPO;
import com.liuyujie.utils.ColaBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class LIstCopyTest {
    public static void main(String[] args) {
        List<ItemAreaSiteNumPO> itemAreaSiteNumPOList=new ArrayList<>();
        List<ItemAreaSiteNumBO> itemAreaSiteNumBOS=new ArrayList<>();
        ItemAreaSiteNumPO itemAreaSiteNumPO = new ItemAreaSiteNumPO();
        itemAreaSiteNumPO.setAreaCode("121243");
        itemAreaSiteNumPO.setAreaCount(999);
        itemAreaSiteNumPO.setAreaName("呵呵");
        itemAreaSiteNumPOList.add(itemAreaSiteNumPO);
        List<ItemAreaSiteNumBO> itemAreaSiteNumBOS1 = ColaBeanUtils.copyListProperties(itemAreaSiteNumPOList, ItemAreaSiteNumBO::new);
        System.out.println(JSONObject.toJSONString(itemAreaSiteNumBOS1));
    }
}
