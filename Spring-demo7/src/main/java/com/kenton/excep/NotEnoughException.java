package com.kenton.excep;

/**
 * @author: Kenton
 * @description 异常类
 * @date: 2022/6/23 13:12
 */
// 自定义的运行时异常
public class NotEnoughException extends RuntimeException{
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
