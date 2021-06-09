**spring整合mybatis【重要】**

需要配置三个bean：DataSource、SqlSessionFactoryBean、MapperScannerConfigurer

    <!--1 配置DruidDataSource连接池-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
    </bean>
    <!--2 配置SqlSessionFactoryBean，作用：
            2.1 创建Mybatis需要的SqlSessionFactoryBuilder、SqlSessionFactory...
            2.2 创建Mybatis的环境对象(别名、连接池、映射配置文件、核心配置文件...)
    -->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
    <!--注入dataSouce连接池【必须】-->
    <property name="dataSource" ref="dataSource"/>
    <!--注入别名【可选】-->
    <property name="typeAliasPackage" value="com.itheima.bean"/>
    <!--注入mybatis和核心配置文件【可选】-->
    <property name="configLocation" value="classpath:MybatisConfig.xml"/>
    <!--注入mybatis映射配置文件【可选】-->
    <property name="mapperLocations" value="classpath:StudentMapper.xml"/
    </bean>

	<!--3 配置MapperScannerConfigurer，作用：
		3.1 扫描mapper接口所在的包，给mapper接口创建代理对象保存到spring容器中
		3.2 如果映射配置文件在mapper包中，并且名字和mapper一样，那么会自动加载映射配置文件。
	-->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigure">
		<!--注入mapper接口的包名称【必须】-->
		<property name="basePackage" value="com.itheima.mapper"/>
	</bean>