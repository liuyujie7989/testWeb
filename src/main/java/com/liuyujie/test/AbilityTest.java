package com.liuyujie.test;

import com.alibaba.fastjson.JSONObject;
import com.liuyujie.utils.AbilityPostUtil;

import java.io.IOException;

public class AbilityTest {
    public static void main(String[] args) throws IOException {
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("url","http://scjgwsdj.xa.gov.cn/aLi.do");
        String select_org_details_req = AbilityPostUtil.postUrl(jsonObject, "http://117.39.29.95:9000/OSN/api/businessCenter/url/urlConnection/v1 ", "URL_CONNECTION_REQ");
       System.out.println(select_org_details_req);

    }
}
