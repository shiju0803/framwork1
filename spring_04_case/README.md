**Spring框架学习第四天案例

applicationContext.xml配置文件总结**

1+3+2模型

    <!--1的部分： 开启spring的注解扫描-->
    <context:component-scan base-package="com.itheima.service"/>
    
    <!--3的部分 spring整合mybatis-->
    <!--3.1 配置druid连接池-->
    <context:property-placeholder location="classpath:jdbc.properties,classpath:redis.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
    </bean>
    
    <!--3.2 配置SqlSessionFactoryBean-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!--注入核心配置文件-->
        <property name="configLocation" value="classpath:MybatisConfig.xml"/>
        <!--配置分页插件-->
        <property name="plugins">
            <bean class="com.github.pagehelper.PageInterceptor"/>
        </property>
    </bean>
    <!--3.3 配置MapperScannerConfigurer-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.itheima.mapper"/>
    </bean>
    
    <!--2的部分 声明式事务管理-->
    <!--2.1  配置平台事务管理器DataSourceTransactionManager-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--2.2 开启声明式事务管理注解驱动-->
    <tx:annotation-driven transaction-manager="transactionManager"/>