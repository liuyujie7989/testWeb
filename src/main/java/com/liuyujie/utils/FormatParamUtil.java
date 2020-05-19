package com.liuyujie.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

/**
 * @author liuyishou
 * @date 2020/5/15
 */
public class FormatParamUtil {

    public static void main(String[] args) {
        String s = formatGx("{\"date\":\"hahaaaa\"}", "您于{date}在西安市政务服务平台进行的咨询已经收到回复，您可在用户中心>我的咨询中进行查看！");
        System.out.println(s);
    }

    public static String formatGx(String templateParam, String templateFormat) {
        Map jsonMap = (Map) JSONObject.parse(templateParam);
        Set set = jsonMap.keySet();
        for (Object key : set
        ) {
            templateFormat = templateFormat.replace(("{" + key.toString() + "}"), jsonMap.get(key.toString()).toString());
        }
        return templateFormat;
    }
}
