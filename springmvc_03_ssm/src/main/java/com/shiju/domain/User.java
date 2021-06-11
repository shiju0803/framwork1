package com.shiju.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author shiju
 * @date 2021/06/10 11:19
 */

@Data //生成get/set toString equals hashCode方法
public class User {
    private Integer id; //编号，唯一

    @NotBlank(message = "用户名不能为空")
    @Length(max = 30, message = "用户名长度不能超过30个字符")
    private String username; //用户名

    @NotBlank(message = "密码不能为空")
    @Length(max = 20, message = "密码长度不能超过20个字符")
    private String password; //密码

    @NotBlank(message = "真实姓名不能为空")
    @Length(max = 30, message = "真实姓名长度不能超过30个字符")
    private String realname; //真实姓名

    @NotBlank(message = "性别不能为空")
    @Length(max = 10, message = "性别长度不能超过10个字符")
    private String gender; //性别

    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收请求参数时格式化模式
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")//响应数据转换成json时格式化模式
    @NotNull(message = "生日不能为空")
    private Date birthday; //生日

}
