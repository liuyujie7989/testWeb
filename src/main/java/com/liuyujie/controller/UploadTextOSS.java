package com.liuyujie.controller;

import com.aliyun.oss.model.ObjectMetadata;
import com.liuyujie.utils.OSSUtil;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: OSS存储空间内上传文本对象
 * @Author: Ni Fujia
 * @CreateDate: 2018/6/14 14:56
 **/
public class UploadTextOSS {
    static Logger logger = Logger.getLogger(UploadTextOSS.class);

    public static void main(String[] args) throws IOException {

        ObjectMetadata objectMetadata = new ObjectMetadata();
       //objectMetadata.setContentLength(stream.size());
        objectMetadata.setContentEncoding("utf-8");
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        //inline 将文件内容直接显示在页面  attachment 弹出对话框让用户下载   filename=cccc 就是下载下来的文件名
        objectMetadata.setContentDisposition("inline;filename=" + "西安市数字大屏历史数据.xlsx");
            InputStream is = new FileInputStream("C:\\Users\\qqq\\Desktop\\user.xls");

        String str = OSSUtil.uploadImageToOSS("user.xls", is,objectMetadata);

        System.out.println(str);

           is.close();
            logger.info( "存入OSS成功。");

        logger.info("已完成...");

    }
}
