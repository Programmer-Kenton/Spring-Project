package com.kenton.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Kenton
 * @description 实体类 学校
 * @date: 2022/6/16 21:18
 */
@Component("mySchool")
public class School {

    @Value("牛马大学")
    private String name;
   @Value("牛马大街")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
