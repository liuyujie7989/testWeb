package com.liuyujie.controller;

import com.alibaba.fastjson.JSONObject;
import com.liuyujie.bo.ItemAreaSiteNumBO;
import com.liuyujie.bo.ItemAreaSiteNumPO;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BeanCopyTest {
    public static void main(String[] args) {
        ItemAreaSiteNumBO itemAreaSiteNumBO = new ItemAreaSiteNumBO();
        ItemAreaSiteNumPO itemAreaSiteNumPO = new ItemAreaSiteNumPO();
        itemAreaSiteNumBO.setAreaCode("1223432");
        itemAreaSiteNumBO.setAreaName("反對法d");
        itemAreaSiteNumBO.setDate(new Date());
        BeanUtils.copyProperties(itemAreaSiteNumBO,itemAreaSiteNumPO);
        System.out.println(JSONObject.toJSONString(itemAreaSiteNumPO));
    }
}
