package com.kenton.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description 学生实体类
 * @date: 2022/6/22 13:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    // 属性名和列名一样
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
