**Spring框架学习第二天，使用注解配置spring**

1 常用注解

1.1 创建bean对象的注解 @Component【重点】、@Controller【重点】、@Service【重点】、@Repository【次重点】

用法：写在自己的类上。

作用：将自己定义的类交给spring创建对象，添加到spring容器中，适用于配置自定义bean

	@Bean【重点】
	用法：写在方法上。
	作用：将方法的返回值对象添加到spring容器中，适用于配置第三方bean。

1.2 依赖注入的注解

@Value("数据")【重点】

用法：写在成员变量或者set方法上。

作用：给普通类型的属性注入数据。

	@Autowired【重点】
	用法：写在成员变量或者set方法上。
	作用：给对象类型的属性注入数据，默认按照类型注入，如果同类型对象有多个，按照变量名和容器中对象的名称进行匹配，但是一般使用@Qualifier指定要匹配的对象。
	@Qualifier("指定bean的名称")【次重点】
	用法：写在成员变量或者set方法上
	作用：结合@Autowired注解一起使用，指定要匹配的对象的名称。@Qualifier注解在成员变量或者set方法上不能单独使用。

1.3 纯注解开发：使用配置类代替applicationContext.xml配置文件

    //该类作为一个配置类，代替applicationContext.xml配置文件
    @Configuration //该注解表示该类是一个配置类
    //<context:component-scan base-package="com.itheima"/>

    @ComponentScan("com.itheima")
    //<context:property-placeholder location="classpath:jdbc.properties"/>
    @PropertySource("classpath:jdbc.properties")

    //加载分配置类 <import resource="classpath:applicationContext-dao.xml"/>
    @Import({JdbcConfig.class})
    public class SpringConfiguration {
    
    }