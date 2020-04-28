package com.liuyujie.controller;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYin {

    /**
     * 得到中文全拼
     * @param src 需要转化的中文字符串
     * @return
     */
    public static String getPingYin(String src)
    {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try
        {
            for (int i = 0; i < t0; i++)
            {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
                {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else
                {
                    t4 += java.lang.Character.toString(t1[i]);
                }
            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1)
        {
            e1.printStackTrace();
        }
        return t4;
    }
    /**
     * 得到中文首字母
     * @param str 需要转化的中文字符串
     * @return
     */
    public static String getPinYinHeadChar(String str)
    {
        String convert = "";
        for (int j = 0; j < str.length(); j++)
        {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null)
            {
                convert += pinyinArray[0].charAt(0);
            } else
            {
                convert += word;
            }
        }
        return convert;
    }

    public static void main(String[] args) {
        String[] strings = {
                "郭旭",
                "潘晓",
                "巨鹏飞",
                "李时娇",
                "吕行",
                "乔美美",
                "马震",
                "孙天路",
                "李爽",
                "王永超",
                "白娜",
                "张蕾",
                "朱瑞",
                "万国勋",
                "孟婧琪",
                "张慕尧",
                "李射",
                "孙珍",
                "阮鹏超",
                "田琴",


        };
        for (int i = 0; i < strings.length; i++) {
            String pinYinHeadChar = getPinYinHeadChar(strings[i]);
            System.out.println("xzspj_"+pinYinHeadChar);
        }

    }

}
