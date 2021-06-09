Spring框架学习第三天，纯注解方式配置AOP

AOP的纯注解配置

    @Configuration
    @ComponentScan("com.itheima")
    @EnableAspectJAutoProxy
    public class SpringConfiguration{
    
    }