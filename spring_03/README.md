spring框架学习第三天，AOP

1 AOP的概念和作用

    AOP面向切面编程，作用是在不改变业务层方法源代码的情况下对方法进行增强，底层使用的是动态代理技术，也叫面向动态代理编程。

2 AOP的纯xml配置

    <!--配置目标对象，也就是service-->
    <bean id="studentService" class="com.itheima.service.impl.StudentServiceImpl"/>
    <!--配置通知对象，也就是Advice-->
    <bean id="advice" class="com.itheima.aop.Advice"/>
    <!--AOP配置-->
    <aop:config>
    <!--配置切入点-->
    <aop:pointcut id="pt" expression="execution(* com.itheima.service.StudentService.*(..))"/>
    <!--配置切面：切入点+通知方法 -->
    <aop:aspect ref="advice">
    <!--配置不同类型的通知-->
    <aop:before method="before" pointcut-ref="pt"/>
    <aop:after-returning method="afterReturn" pointcut-ref="pt"/>
    ...
    </aop:aspectj>
    </aop:config>

3 AOP的半xml半注解配置

    applicationContext.xml配置：
    <context:component-scan basePackage="com.itheima"/>
    <!--开启spring aop注解支持-->
    <aop:aspectj-autoProxy/>

	Advice通知类中的配置：
	@Component
	@Aspect //该类是一个切面类
	public class Advice{
		//1 配置切入点表达式方法
		@Pointcut("execution(* com.itheima.service.StudentService.*(..))")
		public void pt(){}

		//2 配置不同的通知类型
		@Before("pt()")
		public void before(){}

		@AfterReturning("pt()")
		public void afterReturning(){}
		...
		
		@Around("pt()")
		public Object around(ProceedingJointPoint pjp){
			try{
				//前置通知
                 //执行目标方法
                 //后置通知
			}catch(Throwable err){
				//异常通知
			}finally{//最终通知}
		}
    }