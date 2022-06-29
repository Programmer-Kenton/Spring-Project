package com.kenton.service.impl;

import com.kenton.service.SomeService;
import com.kenton.utils.ServiceTools;

import java.util.Date;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/21 19:29
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        ServiceTools.doLog();
        System.out.println("执行业务方法doSome");
        ServiceTools.doTrans();
    }

    @Override
    public void doOther() {
        ServiceTools.doLog();
        System.out.println("方法的执行时间:" + new Date());
        System.out.println("执行业务方法doOther");
        ServiceTools.doTrans();
    }
}
