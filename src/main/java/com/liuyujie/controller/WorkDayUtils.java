package com.liuyujie.controller;

import com.ohaotian.plugin.common.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author wuxin
 * @version 0.1
 * @Description: 工作日相关计算
 * @date 2018/10/10
 * @Modify by
 */
public abstract class WorkDayUtils {
    /**
     * 求任意两个日期之间的天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long workdayCount(String startDate, String endDate){
        Date startdate = DateUtils.strToDate(startDate);
        Date enddate = DateUtils.strToDate(endDate);
        long l = (enddate.getTime() - startdate.getTime()) / (24 * 60 * 60 * 1000)+1;
        return l;
    }

    /**
     * 求任意两个日期间的休息日
     * @param d1 第一个日期
     * @param d2 第二个日期
     * @return
     */
    public static int getWeekends(Date d1, Date d2){
        if(d1 == null || d2 == null){
            return 0;
        }
        int count = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        // 保证第二个时间一定大于第一个时间
        if (c1.after(c2)) {
            c2.setTime(d1);
            c1.setTime(d2);
        }
        // 当日期c2在日期c1之后退出循环
        while(c2.after(c1) || c1.equals(c2)){
            //实际0开始，1即对应0、7即对应6——0 周日   6周六
            if(c1.get(Calendar.DAY_OF_WEEK) == 1 || c1.get(Calendar.DAY_OF_WEEK) == 7){
                System.out.println(c1.getTime());
                count++ ;
            }
            // 天数加1
            c1.set(Calendar.DAY_OF_YEAR, (c1.get(Calendar.DAY_OF_YEAR) + 1));
        }
        return count;
    }



    /**
     *@param  date 是为则默认今天日期,可自行设置“yyyy-mm-dd”格式的日期
     *@return  返回1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六
     */

    public static int getDayofweek(String date){
        Calendar cal = Calendar.getInstance();
       //cal.setTime(new Date(System.currentTimeMillis()));
        if (date.equals("")) {
            cal.setTime(new Date(System.currentTimeMillis()));
        }else {
            cal.setTime(new Date(getDateByStr2(date).getTime()));
        }
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static Date getDateByStr2(String dd)
    {

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sd.parse(dd);
        } catch (Exception e) {
            date = null;
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取两个日期字符串之间的日期集合
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy-MM-dd
     */
    public static List<String> getBetweenDate(String startTime, String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取两个日期字符串之间的周末日期集合
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy-MM-dd
     */
    public static List<String> getBetweenWeekendsDate(String startTime, String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                calendar.setTime(startDate);
                if (calendar.get(Calendar.DAY_OF_WEEK)==1 || calendar.get(Calendar.DAY_OF_WEEK) == 7){
                    // 把日期添加到周末集合中
                    list.add(sdf.format(startDate));
                }
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }


}
