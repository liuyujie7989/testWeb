package com.liuyujie.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.BucketInfo;
import com.aliyun.oss.model.GetObjectRequest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

/**
 * @Description: 从OSS下载文件
 * @Author: Ni Fujia
 * @CreateDate: 2018/6/14 16:02
 **/
public class DownloadFileOSS {
    static Logger logger = Logger.getLogger(DownloadFileOSS.class);
    private static String endpoint = "10.16.11.105";
    private static String accessKeyId = "z760kkGR0MTXsJ76";
    private static String accessKeySecret = "YyVNR6wp0YGOd36RwUabeqtUoOOKK2";
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static String bucketName = "paoyici-city-test-data";
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private static String objectName = "winner-first-key";

    public static void main(String[] args) {

        logger.info("开始...");

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 判断Bucket是否存在。
            if (ossClient.doesBucketExist(bucketName)) {
                logger.info("您已经创建Bucket：" + bucketName + "。");
            } else {
                logger.info("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                // 创建Bucket。
                ossClient.createBucket(bucketName);
            }

            // 查看Bucket信息。
            BucketInfo info = ossClient.getBucketInfo(bucketName);
            logger.info("Bucket " + bucketName + "的信息如下：");
            logger.info("数据中心：" + info.getBucket().getLocation());
            logger.info("创建时间：" + info.getBucket().getCreationDate());
            logger.info("用户标志：" + info.getBucket().getOwner());

            // 下载文件
            ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("C:\\Users\\qqq\\Desktop\\1.txt"));
            logger.info("下载成功....");
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (ClientException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }

        logger.info("已完成...");
    }
}
