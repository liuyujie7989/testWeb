package com.liuyujie.bo;

import java.io.Serializable;
import java.util.Date;

public class ItemAreaSiteNumPO implements Serializable {
    private static final long serialVersionUID = 6166895612758056881L;
    //区划编码
    private String areaCode;
    //区划名称
    private String areaName;
    //各区划指定跑动次数的事项数目
    private Integer areaCount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaCount() {
        return areaCount;
    }

    public void setAreaCount(Integer areaCount) {
        this.areaCount = areaCount;
    }
}
