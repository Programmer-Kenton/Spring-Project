package com.kenton.service.impl;

import com.kenton.service.SomeService;
import com.kenton.utils.ServiceTools;

import java.util.Date;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/21 19:29
 */
public class SomeServiceNewImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");}

    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }
}
