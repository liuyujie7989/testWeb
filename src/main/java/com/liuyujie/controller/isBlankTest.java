package com.liuyujie.controller;

import com.liuyujie.bo.Person;
import com.liuyujie.bo.QueryFileReqBo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class isBlankTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Person person=new Person();
        person.setAge(9);
        person.setLength("");
        person.setName("");
        person.setAge(11);
        System.out.println(person.getName().getBytes("iso-8859-1"));

        System.out.println(new java.lang.String(person.getName().getBytes("iso-8859-1"), "utf-8"));
        System.out.println(person.toString());
        System.out.println("2".equals("2"));
        if (StringUtils.isBlank(person.getName()) && StringUtils.isBlank(person.getName()) && StringUtils.isBlank(person.getLength())) {
            System.out.println("342343");
        }
        String str1="";
        String str2="   ";
        String str3=null;
        Person person2=new Person();
        System.out.println("-----");
        System.out.println( StringUtils.isEmpty(str1));
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println( StringUtils.isEmpty(str3));
        System.out.println("-----");
        System.out.println(StringUtils.isBlank(str1));
        System.out.println(StringUtils.isBlank(str2));
        System.out.println(StringUtils.isBlank(str3));
    }

    /*@RequestMapping("/test")
    public Object test(QueryFileReqBo queryFileReqBo) {
        Map<String,String> reqMap =new HashMap<>();
        if (StringUtils.isBlank(queryFileReqBo.getOrgId()) && StringUtils.isBlank(queryFileReqBo.getOrgName()) && StringUtils.isBlank(queryFileReqBo.getUserId())) {
           reqMap.put("respDesc","orgid orgname userid不能同时为空");
            reqMap.put("respCode","1");
            return reqMap;
        }
        return reqMap;
    }*/

}
