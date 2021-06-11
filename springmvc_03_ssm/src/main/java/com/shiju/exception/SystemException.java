package com.shiju.exception;

/**
 * @author shiju
 * @date 2021/06/10 19:51
 * <p>
 * 系统业务异常，一般是连接超时导致的，比如数据库连接超时等....
 * 这一类异常需要给管理员看
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

    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
