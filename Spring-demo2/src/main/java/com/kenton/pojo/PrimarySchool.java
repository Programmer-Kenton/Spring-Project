package com.kenton.pojo;

/**
 * @author: Kenton
 * @description 学校子类
 * @date: 2022/6/17 18:20
 */
public class PrimarySchool extends School{
    private String name;
    private String address;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PrimarySchool{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
