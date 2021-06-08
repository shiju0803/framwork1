1 springmvc环境搭建以及常用配置

    【第一步】添加spring-webmvc依赖。
    【第二步】编写处理请求和响应的Controller类，定义要访问的方法，在类或者方法上使用@RequestMapping注解定义方法路径。
    @Controller
    @RequestMapping("user")
    public class UserController{
    
            @RequestMapping("save")  //定义方法的访问路径
            public String save(){
                //处理请求和响应.
                return "返回要跳转的页面"
            }
        }
    【第三步】编写springmvc配置文件：spring-mvc.xml
    <!--开启springmvc包扫描-->
    <context:component-scan base-package="com.itheima.controller" />
    
        <!--忽略静态资源访问拦截-->
        <mvc:default-servlet-handler/>
    
        <!--开启springmvc的注解驱动：会重新加载springmvc的三大组件（处理器映射器、处理器适配器、视图解析器）-->
        <mvc:annotation-driven/>
    
    【第四步】在web.xml中配置前端控制器加载springmvc配置文件，配置CharacterEncodingFilter过滤器，解决post请求中文乱码问题。
    1、配置DispatcherServlet前端控制器，加载springmvc配置文件、
    2、配置CharacterEncodingFilter过滤器，解决post请求中文乱码问题。

2 springmvc请求

2.1 获取普通类型参数

    //要求：请求参数的名称必须是name和age，否则封装不上。
    @RequestMapping("requestParam1")
    public String requestParam1(String name,Integer age){}
    
        //如果请求参数和变量名不一样，需要在参数前面使用@RequestParam("参数名称")
        @RequestMapping("requestParam2")
        public String requestParam2(@RequestParam("userName") String name){}
        @RequestParam("参数名称")作用：将指定名称的参数赋值给对应的变量。

2.2 获取POJO类型参数

	http://localhost:8080/springmvc_01/user/requestParam6?name=张伟&age=20&nick=张益达&nick=snake&nick=张大炮
	@RequestMapping("/requestParam6")
    public String requestParam6(User user){
        System.out.println(user);
        return "/success.jsp";
    }
    
	2.3 获取Date日期类型参数
	@RequestMapping("/requestParam11")
	public String requestParam11(@DateTimeFormat(pattern = "yyyy-MM-dd"Date birthday){
		System.out.println(birthday);
		return "/success.jsp";
	}
	说明：前端表单提交过来的日期格式是yyyy-MM-dd格式，springmvc默认只支持转yyyy/MM/dd格式的日期，所以需要使用@DateTimeFormat(pattern = "yyyy-MM-dd")指定转换格式。要求：需要开启springmvc注解驱动。

3 springmvc响应

    @RequestMapping("/requestURL1")
    @ResponseBody  //不进行页面跳转，将返回值通过响应体响应给客户端
    public User requestURL1(){
    User user=new User();  //将来调用service层方法从数据库中获取
    return user;
    }

	@RequestMapping("/requestURL1")
	@ResponseBody  //不进行页面跳转，将返回值通过响应体响应给客户端
	public List<User> requestURL1(){
		User user=new User();  
		
		//将来调用service层方法从数据库中获取
		List<User> list=Stream.of(user,user).collect(Collectors.toList());
		
		return list;
	}
	要求：1 需要添加jackson-databind依赖。2 需要开启springmvc注解驱动。

今天常用注解：

    @RequestMapping("")
    用法：写在类或者方法上
    作用：定义访问路径，写在类上表示一级路径，写在方法上表示二级路径。
    @RequestParam("")
    用法：写在参数列表上
    作用：解决请求参数和变量名不一致问题，将指定名称的参数赋值给变量。
    @DateTimeFormat("")
    用法：写在参数列表上
    作用：定义日期的格式化模式
    @ResponseBody
    用法：写在方法上
    作用：不进行页面跳转，通过响应体响应数据。 