1 两个概念

    IOC：（Inversion Of Control），反转控制，把创建对象的权利交给spring，我们从spring容器中获取需要的对象使用。
    DI：（Dependence Inject），告诉spring在创建bean对象的时候，给bean中的属性赋值。这就叫做依赖注入，注入的方式有两种：set方法注入和构造方式注入。

2 入门案例（搭建一个spring环境）

    【第一步】添加依赖：spring-context
    【第二步】创建spring的配置文件：applicationContext.xml
    【第三步】在单元测试类中：1 创建spring容器对象，2 从容器中获取bean对象，3 调用bean的方法

3 IOC配置

    3.1 bean的基本属性【重要】

    <bean
    id="" //bean对象保存到spring容器中的唯一标识。【重要】
    class=""  //要创建的bean的全类名，底层反射创建对象【重要】
    name=""  //给bean取别名，多个名称用逗号隔开【了解】
    
            scope=""  //定义bean是单例还是多例，默认取值singleton表示单例，prototype表示多例。但是该属性的取值不止这两个。【了解】
            
            init-method="bean中初始化方法的名称"  //指定初始化方法【了解】
            detroy-method="bean中销毁方法的名称"  //指定销毁方法【了解】
            
            factory-bean=""	//如果factory-method指定的方法是非静态方法，那么此处需要指定工程bean的id。【了解】
            factory-method=""   //工程中创建bean的方法(可以是静态的方法可以是非静态方法)【了解】
        ></bean>
	
	3.2 依赖注入的两种方式【重要】

	set方式注入：底层执行setXxx方法
	<bean id="" class="">
		<property name="属性名称(set方法去掉set首字母小写的部分)" value="普通类型数据"/>
		<property name="属性名称(set方法去掉set首字母小写的部分)" ref="对象类型数据"/>
	</bean>
 	构造方式注入：底层执行的是对应的有参构造方法
    <bean id="" class="">
        <constructor-arg name="属性名称(set方法去掉set首字母小写的部分)" value="普通类型数据"/>
        <constructor-arg name="属性名称(set方法去掉set首字母小写的部分)" ref="对象类型数据"/>
    </bean>

	3.3 引入jdbc.properties属性文件【重要】

	【第一步】：添加xmlns:context名称空间
	【第二步】：在applicationContext.xml中引入属性文件
		<context:property-placeHolder location="classpath:jdbc.propertyes"/>
	【第三步】：在需要的地方使用${}表达式取值
	
	3.4 引入spring分配置文件【了解】

	<import resource="classpath:applicationContext-dao.xml"/