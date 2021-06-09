package com.shiju.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shiju
 * @date 2021/06/04 15:48
 */
@Configuration
@ComponentScan("com.shiju")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class SpringConfiguration {
}
