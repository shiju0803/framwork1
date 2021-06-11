package com.shiju.exception;


/**
 * @author shiju
 * @date 2021/06/10 19:51
 * <p>
 * 封装业务异常，一般是用户不合法的输入导致的，比如页数是负数，用户没有登录就添加数据...
 * 这一类异常需要给用户看
 */
public class BusinessException extends RuntimeException {
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
