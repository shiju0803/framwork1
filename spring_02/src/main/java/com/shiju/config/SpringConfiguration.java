package com.shiju.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shiju
 * @date 2021/06/01 11:33
 */
@Configuration//用在类上，表示该类是一个spring配置类，代替applicationContext.xml配置文件
@ComponentScan("com.shiju")//相当于<context:component-scan base-package="com.itheima"/>开启spring注解扫描
@PropertySource("classpath:jdbc.properties")
@Import({Jdbcconfig.class})
public class SpringConfiguration {

}
