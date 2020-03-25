package com.liuyujie.bo;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private String length;


    public Person() {
    }

    public Person(String name, int age, String length) {
        this.name = name;
        this.age = age;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", length='" + length + '\'' +
                '}';
    }
}
