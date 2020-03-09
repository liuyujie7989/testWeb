package com.liuyujie.controller;

import com.liuyujie.bo.Person;
import com.liuyujie.bo.QueryFileReqBo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    /*public static void main(String[] args) {
        Person person=new Person();
        person.setAge("");
        person.setLength("");
        person.setName("");
      *//*  person.setAge("11");selectHandleWorkdayCountWebService
        System.out.println(person.toString());*//*
        System.out.println("2".equals("2"));
        if (StringUtils.isBlank(person.getName()) && StringUtils.isBlank(person.getName()) && StringUtils.isBlank(person.getLength())) {
            System.out.println("342343");
        }


    }*/

    @RequestMapping("/test")
    public Object test(QueryFileReqBo queryFileReqBo) {
        Map<String,String> reqMap =new HashMap<>();
        if (StringUtils.isBlank(queryFileReqBo.getOrgId()) && StringUtils.isBlank(queryFileReqBo.getOrgName()) && StringUtils.isBlank(queryFileReqBo.getUserId())) {
           reqMap.put("respDesc","orgid orgname userid不能同时为空");
            reqMap.put("respCode","1");
            return reqMap;
        }
        return reqMap;
    }

}
