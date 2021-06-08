**改造spring第四天的综合案例**

    改造步骤：
    【第一步】添加依赖：spring-webmvc
    【第二步】将StudentServlet改造成StudentController，改造方法，添加对应的注解。
    【第三步】创建spring-mvc.xml的配置文件，配置springmvc的相关信息(开启包扫描、忽略静态资源访问、springmvc注解驱动)
    【第四步】在web.xml中配置DispatcherServlet前端控制(加载springmvc配置文件)和统一字符集过滤器，以及加载spring的配置文件
    <!--spring整合springmvc很简单，只需要分开加载各自配置文件就行了，springmvc的配置文件由DispatcherServlet，
    spring-web包中提供了一个叫ContextLoaderListener监听器，使用这个监听器来加载spring的配置文件就行了-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    【第五步】修改页面发送请求的路径