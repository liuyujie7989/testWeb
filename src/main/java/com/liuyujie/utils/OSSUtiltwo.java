package com.liuyujie.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class OSSUtiltwo {
    //EndPoint
    private static String endpoint ;
    //AccessKey ID
    private static String accessKeyId ;
    //Access Key Secret
    private static String accessKeySecret ;
    //Bucket's name
    private static String bucketName ;
    //OSS Folder Name
    private static String folder ;
    //Bucket's domain name
    private static String key  ;

    @Value("${oss.endpoint}")
    public  void setEndpoint(String endpoint) {
        OSSUtiltwo.endpoint = endpoint;
    }
    @Value("${oss.accessKeyId}")
    public  void setAccessKeyId(String accessKeyId) {
        OSSUtiltwo.accessKeyId = accessKeyId;
    }
    @Value("${oss.accessKeySecret}")
    public  void setAccessKeySecret(String accessKeySecret) {
        OSSUtiltwo.accessKeySecret = accessKeySecret;
    }
    @Value("${oss.bucketName}")
    public  void setBucketName(String bucketName) {
        OSSUtiltwo.bucketName = bucketName;
    }
    @Value("${oss.folder}")
    public  void setFolder(String folder) {
        OSSUtiltwo.folder = folder;
    }
    @Value("${oss.key}")
    public  void setKey(String key) {
        OSSUtiltwo.key = key;
    }

    /**
     * 流文件上传
     * @param fileName
     * @param inputStream
     * @return 图片的url
     */
    public static String uploadImageToOSS(String fileName, InputStream inputStream, ObjectMetadata metadata) {
        //创建OSS客户端
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            Date date = new Date();
            SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmm-");
            String imageTime = yyyyMMddHHmmss.format(date);
            String[] names = fileName.split("[.]");
            //图片名称：时间+UUID
            String name = imageTime+uuid + "." + names[names.length - 1];
            //putObject 上传对象
            ossClient.putObject(new PutObjectRequest(bucketName, folder + name, inputStream,metadata));
            return key + folder + name;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 多图上传
     * @param fileNames
     * @param inputStreams
     * @return
     */
    public static String[] uploadImageToOSS(String[] fileNames, InputStream[] inputStreams) {
        //创建OSS客户端
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(
                    Arrays.asList(fileNames));
            ConcurrentLinkedQueue<InputStream> streamConcurrentLinkedQueue = new ConcurrentLinkedQueue<>(
                    Arrays.asList(inputStreams));
            Iterator<InputStream> inputStreamss = streamConcurrentLinkedQueue.iterator();
            ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
            for (Iterator<String> iterator = concurrentLinkedQueue.iterator();
                 iterator.hasNext() && inputStreamss.hasNext(); ) {
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                String[] names = iterator.next().split("[.]");
                String name = uuid + "." + names[names.length - 1];
                ossClient.putObject(new PutObjectRequest(bucketName, folder + name, inputStreamss.next()));
                c.add(key + folder + name);
            }
            return (String[]) c.toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 删除图片
     * @param url
     */
    public void deleteImg(String url) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        if (url == null || "".equals(url)) {
            return;
        }
        String[] paths = url.split("[.]");
        /**
         * 文件夹是否存在
         */
        if (!ossClient.doesObjectExist(bucketName, folder)) {
            ossClient.putObject(bucketName, folder, new ByteArrayInputStream(new byte[0]));
        }
        String[] name = paths[paths.length - 2].split("[/]");
        /**
         * 对象是否存在
         */
        if (ossClient
                .doesObjectExist(bucketName,
                        folder + name[name.length - 1] + "." + paths[paths.length - 1])) {
            /**
             * 删除存在对象
             */
            ossClient
                    .deleteObject(bucketName, folder + name[name.length - 1] + "." + paths[paths.length - 1]);
        }
        ossClient.shutdown();
    }
}
