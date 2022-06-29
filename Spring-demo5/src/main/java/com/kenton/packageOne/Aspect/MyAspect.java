package com.kenton.packageOne.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

/**
 * @author: Kenton
 * @description 切面类
 * @date: 2022/6/21 21:33
 */
// 表示当前类是切面类 用来给当前业务添加功能的类
@Aspect
public class MyAspect {
    /* 定义方法 方法是实现切面功能的
       方法的定义要求:
       1.公共方法
       2.方法没有返回值
       3.方法名称自定义
       4.方法可以有参数也可以没有参数 如果有参数 参数不是自定义的 有几个类型可以使用
    */

    /* @Before:前置通知注解
       属性:value 是切入点表达式 表示切面的功能执行的位置
       位置:在方法的上面
       特点:
            1.在目标方法之前执行
            2.不会改变目标方法的执行结果
            3.不会影响目标方法的执行
     */
   /* @Before(value =
            "execution(public void com.kenton.packageOne.service.impl.SomeServiceImpl.*(String,Integer))")
    public void myBefore(){
        // 切面执行的功能代码
        System.out.println("前置通知,切面功能:在目标方法之前输出时间:" + new Date());
    }
*/
    /**
     * 指定通知方法中的参数:JoinPoint
     * JoinPoint:业务方法 要加入切面功能的业务方法
     * 作用是:可以在通知方法中获取方法执行时的信息
     * 如果你的切面功能中需要用到方法的信息 就加入JoinPoint
     * 这个JoinPoint参数的值 由框架赋予的 必须是第一个位置的参数
     */

    /*@Before(value =
            "execution(public void com.kenton.packageOne.service.impl.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(JoinPoint jp){
        // 获取方法的完整定义
        System.out.println("方法的签名=" + jp.getSignature());
        System.out.println("方法的名称=" + jp.getSignature().getName());
        // 获取方法的实参
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数="+arg);
        }
        // 切面执行的功能代码
        System.out.println("前置通知,切面功能:在目标方法之前输出时间:" + new Date());
    }*/


    /**
     * 后置通知方法 方法是实现切面功能的
     * 方法的定义要求:
     * 1.公共方法public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法有参数 推荐是Object 参数名自定义
     */

    /**
     * @AfterReturing:后置通知
     *   属性:1.value 切入点表达式
     *       2.returinng 自定义的变量 表示目标方法的返回值
     *         自定义的变量名必须和通知方法的形参名一样
     *   位置:在方法定义的上面
     *   特点:
     *       1.在目标方法之后执行的
     *       2.能够获取目标方法的返回值 可以根据返回值做不同的处理功能
     *       3.可以修改返回值
     */

   /* @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",
                    returning = "res")
    public void myAfterReturing(Object res){
        // Object res:是目标方法执行后的返回值 根据返回值做你的切面的功能处理
        System.out.println("后置通知:在目标方法执行之后执行的,获取的返回值是:" + res);
        if (res.equals("abcd")) {

        }else {

        }

        // 修改目标方法的返回值 看一下是否会影响 最后的方法调用结果
        if (res != null) {
            res = "Hello Aspectj";
        }
    }*/

    /**
     * 环绕通知方法的定义格式
     * 1.public
     * 2.必须有一个返回值 推荐使用Object
     * 3.方法名称自定义
     * 4.方法有参数 固定的参数 ProceedingJoinPoint
     */

    /**
     * @Around:环绕通知
     *   属性:value 切入点表达式
     *   位置:在方法定义的上面
     *   特点: 1.它是功能最强的通知
     *        2.在目标方法的前后都能增强功能
     *        3.控制目标方法是否被调用执行
     *        4.修改原来的目标方法的执行结果 影响最后的调用结果
     *    环绕通知 等同于JDK动态代理 InvocationHandler接口
     *    参数:ProceedingJoinPoint 就等同于Method
     *        作用:执行目标方法的
     *        返回值:就是目标方法的执行结果 可以被修改
     * @param pjp
     * @return
     */

   /* @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        String name = "";
        // 获取第一个参数值
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 1) {
            Object arg = args[0];
            name = (String) arg;
        }
        // 实现环绕通知的功能
        Object result = null;
        System.out.println("环绕通知:在目标方法执行之前 输出时间:" + new Date());
        // 1.目标方法的调用
        if ("zhangsan".equals(name)) {
            // 符合条件 调用目标方法
            result = pjp.proceed();
        }
        result = pjp.proceed(); // method.invoke();
        System.out.println("环绕通知:在目标方法执行之后 提交事务");
        // 2.在目标方法的前或者后加入功能

        // 修改目标方法的执行结果 影响方法最后的调用结果
        if (result != null) {
            result = "Hello AspectJ Aop";
        }
        // 返回目标方法的执行结果
        return result;
    }*/

    /**
     * 异常通知方法的定义格式
     * 1.public
     * 2.没有返回值
     * 3.方法名称自定义
     * 4.方法可以有一个Exception 如果有是JoinPoint
     */

    /**
     * @AfterThrowing:异常通知
     * 属性:1.value 切入点表达式
     *     2.throwing 自定义的变量 表示目标方法抛出的异常对象
     *       变量名必须和方法的参数名一样
     * 特点:
     *     1.在目标方法抛出异常时执行的
     *     2.可以做异常的监控程序 目标方法执行时是不是有异常
     *       如果有异常 可以发送 邮件短信通知
     * @param ex
     */
   /* @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",
            throwing = "ex")
    public void myAfterThrowing(Exception ex){
        System.out.println("异常通知:方法发生异常时 执行:" + ex.getMessage());
    }*/

    /**
     * @After:最终通知
     * 属性:value 切入点表达式
     * 位置:在方法的上面
     * 特点:1.总是会执行
     *     2.在目标方法之后执行的
     */
    @After(value = "mypt()")
    public void myAfter(){
        System.out.println("执行最终通知 总是会被执行的代码");
        // 一般做资源清除工作

    }

    @Before(value = "mypt()")
    public void myBefore(){
        System.out.println("前置通知 在目标方法之前先执行");
        // 一般做资源清除工作

    }

    /**
     * @Pointcut:定义和管理切入点 如果项目中有多个切入点是重复的 可以复用的
     *           可以使用@Pointcut
     * 属性:value 切入点表达式
     * 位置:在自定义方法的上面
     * 特点:
     *     当使用@Pointcut定义在一个方法上面 此时这个方法的名称就是切入点表达式的别名
     *     其他的通知中  value属性可以使用这个方法名称 代替切入点表达式
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void mypt(){
        // 无需代码

    }
}
