package com.liuyujie.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liuyujie.bo.User;

public class test002 {
    public static void main(String[] args) {
        User u =new User();
        u.setStuNo("呵呵");
        u.setName("haa");
        u.setAge(12);
        u.setSchool("nn");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(u);
        System.out.println(jsonObject.toJSONString());
        jsonObject.put("ggg",3232);
        System.out.println(jsonObject.toJSONString());
        System.out.println("================================");
        JSONObject jsonObject1 =new JSONObject();
        jsonObject1.put("data","{\\\"code\\\":\\\"200\\\",\\\"data\\\":\\\"[{\\\\\\\"deptName\\\\\\\":\\\\\\\"96\\\\\\\",\\\\\\\"infoitemCount\\\\\\\":\\\\\\\"68200\\\\\\\",\\\\\\\"informatCount\\\\\\\":\\\\\\\"4611\\\\\\\",\\\\\\\"deptId\\\\\\\":110,\\\\\\\"id\\\\\\\":\\\\\\\"839223\\\\\\\",\\\\\\\"allCount\\\\\\\":\\\\\\\"314\\\\\\\"}]\\\"}");
        JSONArray data = jsonObject1.getJSONArray(jsonObject1.getString("data"));

    }
}
