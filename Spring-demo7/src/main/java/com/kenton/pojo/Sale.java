package com.kenton.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description 实体类
 * @date: 2022/6/23 12:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private Integer id;
    private Integer gid;
    private Integer nums;
}
