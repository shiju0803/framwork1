package com.shiju.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shiju
 * @date 2021/06/01 15:05
 */
@Configuration//声明为配置类
@ComponentScan("com.shiju")//开启注解
@PropertySource("classpath:jdbc.properties")//加载配置文件
@Import({MybatisConfig.class, JdbcConfig.class})//引入配置类
public class SpringConfiguration {
}
