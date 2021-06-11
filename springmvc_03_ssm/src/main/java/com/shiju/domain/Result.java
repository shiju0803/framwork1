package com.shiju.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shiju
 * @date 2021/06/10 18:32
 * <p>
 * 封装响应结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;   //结果码
    private String message; //提示消息
    private Object data;    //响应的结果

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
