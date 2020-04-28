package com.liuyujie.bo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 3618156981808393978L;
    private  String name;

    private  Integer age;

    private  String School ;

    private String StuNo;

    public User(String name, Integer age, String school, String stuNo) {
        this.name = name;
        this.age = age;
        School = school;
        StuNo = stuNo;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", School='" + School + '\'' +
                ", StuNo='" + StuNo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getStuNo() {
        return StuNo;
    }

    public void setStuNo(String stuNo) {
        StuNo = stuNo;
    }
}
