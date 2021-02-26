package com.syg.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author 靖鸿宣
 * @since 2021/1/23
 */
public class TestAll {
    @Test
    public void test()
    {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.setex("name",20,"jhx");
        String name = jedis.get("name");
        System.out.println(name);
        
        jedis.close();
    }

}
