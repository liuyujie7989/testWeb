package com.liuyujie.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * 采用MD5加密解密
 *
 * @author
 * @datetime
 */
public abstract class MD5Util {

    private final static Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

    /**
     * MD5 字节数组加密
     *
     * @param: [pdfBytes]  pdf字节码数组
     */
    public final static String MD5(byte[] pdfBytes) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(pdfBytes);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            LOGGER.error("pdf字节码数组MD5加密失败", e);
            return null;
        }
    }

    /**
     * 生成 加密后的tokenValue
     *
     * @param: [app_id, timestamp, trans_id, app_secret]  拼接token的 参数
     */
    public static String tokenValue(String app_id, String timestamp, String trans_id, String app_secret) {
        String tokenValue = "";
        StringBuffer bf = new StringBuffer();
        bf.append("APP_ID" + app_id);
        bf.append("TIMESTAMP" + timestamp);
        bf.append("TRANS_ID" + trans_id);
        bf.append(app_secret);
        String s = bf.toString();
        tokenValue = string32MD5(s);
        return tokenValue;
    }

    /**
     * token md5加密
     *
     * @param: [inStr] 拼接后的token值
     */
    public static String string32MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
//    public static String convertMD5(String inStr){
//
//        char[] a = inStr.toCharArray();
//        for (int i = 0; i < a.length; i++){
//            a[i] = (char) (a[i] ^ 't');
//        }
//        String s = new String(a);
//        return s;
//
//    }

    // 测试主函数
    public static void main(String args[]) {
        String a = MD5Util.tokenValue("KFpTpXKcUd", "2018-10-16 11:03:27", "20180917150606100336456", "fJiAxcQFfb4fRtNKFSBC4hrAAh8e1ZcT");
        System.out.println(a);
    }

    private MD5Util() throws IllegalAccessException {
        throw new IllegalAccessException("工具类不能被实例化");
    }
}
