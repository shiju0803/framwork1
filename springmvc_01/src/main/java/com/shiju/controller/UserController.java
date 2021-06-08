package com.shiju.controller;

import com.shiju.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    //方法传递普通类型参数，数量任意，类型必须匹配
    //http://localhost/requestParam1?name=itheima
    //http://localhost/requestParam1?name=itheima&age=14
    @RequestMapping("/requestParam1")
    public String requestParam1(@RequestParam(value = "name", required = true, defaultValue = "Tiga") String name) {
        System.out.println("name = " + name);
        System.out.println("requestParam1方法访问到了");
        return "/pages.jsp";
    }

    //方法传递普通类型参数，使用@RequestParam参数匹配URL传参中的参数名称与方法形参名称
    //http://localhost/requestParam2?userName=Jock
    @RequestMapping("/requestParam2")
    public String requestParam2() {
        return "";
    }

    //方法传递POJO类型参数，URL地址中的参数作为POJO的属性直接传入对象
    //http://localhost/requestParam3?name=Jock&age=39
    @RequestMapping("/requestParam3")
    public String requestParam3() {
        return "";
    }

    //当方法参数中具有POJO类型参数与普通类型参数嘶，URL地址传入的参数不仅给POJO对象属性赋值，也给方法的普通类型参数赋值
    //http://localhost/requestParam4?name=Jock&age=39
    @RequestMapping("/requestParam4")
    public String requestParam4() {
        return "";
    }

    //使用对象属性名.属性名的对象层次结构可以为POJO中的POJO类型参数属性赋值
    //http://localhost/requestParam5?address.city=beijing
    @RequestMapping("/requestParam5")
    public String requestParam5() {
        return "";
    }

    //通过URL地址中同名参数，可以为POJO中的集合属性进行赋值，集合属性要求保存简单数据
    //http://localhost/requestParam6?nick=Jock1&nick=Jockme&nick=zahc
    @RequestMapping("/requestParam6")
    public String requestParam6(User user) {
        System.out.println(user);
        return "/pages.jsp";
    }

    //POJO中List对象保存POJO的对象属性赋值，使用[数字]的格式指定为集合中第几个对象的属性赋值
    //http://localhost/requestParam7?addresses[0].city=beijing&addresses[1].province=hebei
    @RequestMapping("/requestParam7")
    public String requestParam7() {
        return "";
    }

    //POJO中Map对象保存POJO的对象属性赋值，使用[key]的格式指定为Map中的对象属性赋值
    //http://localhost/requestParam8?addressMap['job'].city=beijing&addressMap['home'].province=henan
    @RequestMapping("/requestParam8")
    public String requestParam8() {
        return "";
    }

    //方法传递普通类型的数组参数，URL地址中使用同名变量为数组赋值
    //http://localhost/requestParam9?nick=Jockme&nick=zahc
    @RequestMapping("/requestParam9")
    public String requestParam9() {
        return "";
    }

    //方法传递保存普通类型的List集合时，无法直接为其赋值，需要使用@RequestParam参数对参数名称进行转换
    //http://localhost/requestParam10?nick=Jockme&nick=zahc
    @RequestMapping("/requestParam10")
    public String requestParam10() {
        return "";
    }

    //数据类型转换，使用自定义格式化器或@DateTimeFormat注解设定日期格式
    //两种方式都依赖springmvc的注解启动才能运行
    //http://localhost/requestParam11?date=1999-09-09
    @RequestMapping("/requestParam11")
    public String requestParam11() {
        return "";
    }

    //数据类型转换，使用自定义类型转换器，需要配置后方可使用
    //http://localhost/requestParam12?date=1999-09-09
    @RequestMapping("/requestParam12")
    public String requestParam12(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday) {
        System.out.println(birthday);
        return "pages";
    }

    //无类映射地址访问格式
    //http://localhost/requestURL1
    @RequestMapping("/requestURL1")
    public String requestURL1() {
        return "";
    }

    //带有类映射地址访问格式，需要将类映射地址作为前缀添加在实际映射地址的前面
    //最终返回的页面如果未设定绝对访问路径，将从类映射地址所在目录中查找
    //http://localhost/user/requestURL2     （注意：要配合类上定义的路径使用）
    @RequestMapping("/requestURL2")
    public String requestURL2() {
        return "";
    }

    //@RequestMapping参数，一个路径参数，6个访问限定性参数（了解）
    @RequestMapping(value = "/requestURL3", params = "name")
    public String requestURL3() {
        return "";
    }
}
