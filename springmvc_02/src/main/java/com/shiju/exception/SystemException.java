package com.shiju.exception;

/**
 * @author shiju
 * @date 2021/06/08 20:38
 * <p>
 * 系统异常：连接某些服务器超时导致的异常就是系统异常，例如：数据库连接超时、redis连接超时。。。
 */
public class SystemException extends RuntimeException {

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    protected SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
