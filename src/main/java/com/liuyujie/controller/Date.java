package com.liuyujie.controller;

import com.ohaotian.plugin.common.util.DateUtils;

public class Date {
    public static void main(String[] args) {
        java.util.Date startdate = DateUtils.strToDate("2020-01-19 14:23:16");
        java.util.Date enddate = DateUtils.strToDate("2020-02-05 20:55:13");
        Long days = WorkDayUtils.workdayCount("2020-01-19 14:23:16", "2020-02-05 20:55:13");
        System.out.println(days);
        int weekends = WorkDayUtils.getWeekends(startdate, enddate);
        System.out.println(weekends);
        System.out.println(2==2);

    }
}
