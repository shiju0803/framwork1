package com.shiju.domain;

/**
 * @author shiju
 * @date 2021/06/10 19:12
 */

/**
 * 状态码类
 */
public final class Code {

    private Code() {
    }

    //定义操作结果的常量
    public static final int QUERY_OK = 2001;
    public static final int QUERY_FAIL = 2002;

    public static final int SAVE_OK = 2003;
    public static final int SAVE_FAIL = 2004;

    public static final int UPDATE_OK = 2005;
    public static final int UPDATE_FAIL = 2006;

    public static final int DELETE_OK = 2007;
    public static final int DELETE_FAIL = 2008;

    public static final int LOGIN_OK = 2009;
    public static final int LOGIN_FAIL = 2010;
    public static final int LOGIN_OUT = 2011;

    //业务异常类型的常量：例如：1 没有登录就访问的状态码 2 分页查询的当前页以及每页条数不合法状态码
    public static final int BUSINESS_EXCEPTION = 5001;

    //系统异常类型的异常:例如连接超时的状态码
    public static final int SYSTEM_EXCEPTION = 5002;

    //其他异常类型的异常:例如空指针异常等
    public static final int OTHER_EXCEPTION = 5003;
}
