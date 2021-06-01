package com.shiju.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author shiju
 * @date 2021/06/01 15:08
 */
public class MybatisConfig {
    //这个方法是由Spring容器调用,如果方法有参数，那么Spring会在容器中找对应的值/对象,参数按照类型匹配,相当于省略了@Autowired
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        //创建SqlSessionFactoryBean对象
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //配置参数
        sqlSessionFactoryBean.setDataSource(dataSource);
        //返回SqlSessionFactoryBean对象
        return sqlSessionFactoryBean;
    }

    /*
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
           <!--扫描mapper所在的包，映射文件需要和包在一起，如果不在一起，就需要在SqlSessionFactoryBean中配置额外指定-->
           <property name="basePackage" value="com.itheima.mapper"/>
       </bean>
    */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        //创建MapperScannerConfigurer对象
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //配置参数
        msc.setBasePackage("com.shiju.mapper");
        //返回MapperScannerConfigurer对象
        return msc;
    }

}
