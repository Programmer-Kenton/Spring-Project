package com.kenton.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Kenton
 * @description 学生实体类
 * @date: 2022/6/17 20:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component(value = "myStudent")
public class Student {

    @Value("DJ")
    private String name;
    @Value("99")
    private Integer age;
    @Value("如果我是DJ 你会爱我吗?")
    private String Word;

    @Resource
    private School school;
}
