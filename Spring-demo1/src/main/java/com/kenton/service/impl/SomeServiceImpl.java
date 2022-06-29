package com.kenton.service.impl;

import com.kenton.service.SomeService;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/16 19:55
 */
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome() {
        System.out.println("执行了SomeServiceImpl的doSome()方法");
    }
}
