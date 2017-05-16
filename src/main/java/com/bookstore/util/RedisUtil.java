package com.bookstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Created by googo on 16/04/2017.
 */
public class RedisUtil {

//    @Autowired
//    private static JedisPool jedisPool;

    public static Jedis getRedisClient(){
        try{
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            JedisPool jedisPool = (JedisPool)context.getBean("jedisPool");
            return jedisPool.getResource();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Object jedisSet(String key, Object value){
        try {
            Jedis jedis = getRedisClient();
            if(jedis == null) return null;
            return jedis.set(key.getBytes(), SerializationUtil.serialize(value));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static Object jedisGet(String key){
        try{
            Jedis jedis = getRedisClient();
            if(jedis == null) return null;
            return SerializationUtil.deserialize(jedis.get(key.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void jedisDelete(String key){
        try{
            Jedis jedis = getRedisClient();
            if(jedis == null) return;
            jedis.del(key);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
