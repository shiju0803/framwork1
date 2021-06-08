**1.改造页面请求，处理springMVC后台接收请求参数问题;**

异步调用【重要】

    get请求：请求参数在地址url后面，格式：url?name=value&name=value&...后台controller中方法里面可以直接将参数封装成POJO类型对象。
	post请求:如果在传递参数写的是对象，那么实际发送过去的是json格式的参数，并且在请求体中。后台Controller中方法里面需要给形参加上@RequestBody注解。
	axios.post("student/addStudent",this.student).then(resp=>{})
        @RequestMapping("/addStudent")
        @ResponseBody
	    public void save(@RequestBody Student student){}
    @RequestBody和@ReponseBody的区别？
		@RequestBody：将请求体中的json数据转换成java对象。
		@ReponseBody：不进行页面跳转，通过响应体响应数据。

**2.使用自定义拦截器，处理在未登录情况下直接在浏览器发送请求导致数据泄露问题;**

拦截器

    作用：拦截controller中方法的调用，可以对Controller中的方法进行增强。
    拦截目标：Controller中的方法
    使用拦截器的步骤：
    【第一步】：写一个类实现HandlerIntercepter接口，重写方法。
    public class MyInterceptor  implements HandlerInterceptor {}
    【第二步】：在springmvc配置文件中配置拦截器
    <!--配置拦截器-->
    <mvc:interceptors>
    <mvc:interceptor>
    <!--配置拦截路径-->
    <mvc:mapping path="/student/**"/>
        <!--排除selectByPage不拦截-->
        <mvc:exclude-mapping path="/student/selectByPage"/>
            <!--配置拦截器的bean-->
            <bean class="com.itheima.interceptor.MyInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>

**3.使用restful开发风格改造了案例的增删改查请求地址**

restful风格【掌握】

    rest风格：将请求参数写到路径url中的一种方式。
    好处：路径书写变得简单。隐藏了具体的行为，行为有请求方式决定。
        http://localhost:8080/springmvc_02/student/1   + GET请求--->查询id=1的学生信息
        http://localhost:8080/springmvc_02/student   + GET请求--->查询所有学生信息
        http://localhost:8080/springmvc_02/student/1/5   + GET请求--->分页查询学生信息
        http://localhost:8080/springmvc_02/student   + POST请求--->保存学生信息
        http://localhost:8080/springmvc_02/student   + PUT请求--->修改学生信息
        http://localhost:8080/springmvc_02/student/1   + DELETET请求--->删除id=1的学生信息
    @GetMapping()：要求客户端必须发送get请求
	@PostMapping()：要求客户端必须发送post请求
	@PutMapping()：要求客户端必须发送put请求
	@DeleteMapping()：要求客户端必须发送delete请求
	@PathVariable：从路径中获取请求参数

**4.增加了分页助手合理化设置**

     <!--配置分页插件-->
    <property name="plugins">
        <!-- 3.3.0版本可用 - 分页参数合理化，默认false禁用 -->
        <!-- 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 -->
        <!-- 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 -->
        <bean class="com.github.pagehelper.PageInterceptor">
               <property name="properties">
                   <props>
                      <prop key="reasonable">true</prop>
                   </props>
               </property>
         </bean>
    </property>