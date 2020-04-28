package com.liuyujie.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbilityPostUtil {

    /**
     * 请求能力平台 调用签章服务
     */
    public static String postUrl(JSONObject jsonStrReq, String url, String strREQ) throws IOException {
        //格式化系统时间   得到请求能力平台时间参数
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        //得到 传输id  指定格式时间加上6位随机数
        Date date1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr1 = sdf1.format(date1);
        int i = (int) ((Math.random() * 9 + 1) * 100000);
        String transId = dateStr1 + i;
        //得到token
        String token = MD5Util.tokenValue("KFpTpXKcUd", dateStr, transId, "fJiAxcQFfb4fRtNKFSBC4hrAAh8e1ZcT");

        //测试请求获取签章地址地址

        //存放请求头和请求入参
        JSONObject bodyJson = new JSONObject();
        //存放请求入参
        JSONObject reqJson = new JSONObject();
        //存放请求头
        JSONObject headJson = new JSONObject();

        /**
         *请求头参数
         */
        headJson.put("APP_ID", "KFpTpXKcUd");
        headJson.put("TIMESTAMP", dateStr);
        headJson.put("TRANS_ID", transId);
        headJson.put("TOKEN", token);
        //请求jsonString的签章入参

        reqJson.put(strREQ, jsonStrReq);
        bodyJson.put("UNI_BSS_HEAD", headJson);
        bodyJson.put("UNI_BSS_BODY", reqJson);

        okhttp3.MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, bodyJson.toJSONString());

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Accept-Encoding", "")
                .url(url)
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
