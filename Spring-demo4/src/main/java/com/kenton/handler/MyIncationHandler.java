package com.kenton.handler;

import com.kenton.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/21 19:47
 */
public class MyIncationHandler implements InvocationHandler {

    private Object target;

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行MyIncationHandler中的invoke()");
        System.out.println("method名称:"+method.getName());
        String methodName = method.getName();
        // 通过代理对象执行方法时 会调用执行这个Invoke()
        Object res = null;
        if ("doSome".equals(methodName)) {
            ServiceTools.doLog();
            // 执行目标类的结果 通过Method类实现
            res = method.invoke(target, args);
            ServiceTools.doTrans();
        }else {
            res = method.invoke(target,args);
        }

        // 目标方法执行结果
        return res;
    }
}
