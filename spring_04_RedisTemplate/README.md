**Spring框架学习第四天，RedisTemplate**

### RedisTemplate【掌握】

#### 前提：修改redis.conf配置文件

```
1 将bind 127.0.0.1注释掉，那么外部才可以使用ip地址连接
2 搜索到requirepass，requirepass原本是注释掉的，需要取消注释，requirepass是用来设置密码的。
```

#### 添加依赖

```xml
    <dependency>
        <groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
        <version>2.9.0</version>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-redis</artifactId>
        <version>2.1.8.RELEASE</version>
    </dependency>
```

#### 复制applicationContext-redis.xml和redis.properties到项目中

> 注意：需要将applicationContext-redis.xml中的引入属性文件的操作注释掉，不能同时使用两个<context:property-placeholder标签引入属性文件

#### 在applicationContext.xml引入redis.properties属性文件

```xml
<!--加载属性文件-->
<context:property-placeholder location="classpath:jdbc.properties,classpath:redis.properties"/>
```

#### 单元测试类

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    //操作string类型
    @Test
    public void test1(){
        //存值
        redisTemplate.opsForValue().set("name","itheima");
		//取值
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }
    
    //操作list类型
    @Test
    public void test2(){
        //存值
        redisTemplate.opsForList().leftPushAll("list01","100","200","10","20");
		//取值
        List list = redisTemplate.opsForList().range("list01", 0, -1);
        System.out.println(list);
    }
}
```