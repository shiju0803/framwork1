package com.shiju.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * @author shiju
 * @date 2021/06/05 21:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        Jedis jedis = new Jedis("192.168.175.125", 6379);
        jedis.auth("root");
        jedis.set("name", "黄桂田");
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    public void test() {
        //存值
        redisTemplate.opsForValue().set("name", "Tiga");
        //取值
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }
}
