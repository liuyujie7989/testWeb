package com.liuyujie.controller;

import com.liuyujie.utils.DateUtil;
import com.ohaotian.plugin.common.util.DateUtils;

import java.text.SimpleDateFormat;

public class Date {
    public static void main(String[] args) {
        /*java.util.Date startdate = DateUtils.strToDate("2020-01-19 14:23:16");
        java.util.Date enddate = DateUtils.strToDate("2020-02-05 20:55:13");
        Long days = WorkDayUtils.workdayCount("2020-01-19 14:23:16", "2020-02-05 20:55:13");
        System.out.println(days);
        int weekends = WorkDayUtils.getWeekends(startdate, enddate);
        System.out.println(weekends);
        System.out.println(2==2);*/
        int currentMonh = DateUtil.getCurrentMonh();
        String   firstDayOfMonth = DateUtil.getFirstDayOfMonth(currentMonh);
        System.out.println(firstDayOfMonth);


        String temp_str = "";
        java.util.Date dt = new java.util.Date();
        java.util.Date yesterdayDate = new java.util.Date(dt.getTime() - 86400000L);
        java.util.Date tomorrowDate = new java.util.Date(dt.getTime() + 86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str = sdf.format(tomorrowDate);
        System.out.println(temp_str);

    }
}
