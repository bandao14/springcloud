package com.zl.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisZl {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    /**
     * 指定缓存失效时间
     * @param key 建
     * @param time 失效时间()
     * @param timeUnit (秒，毫秒)
     * @return
     */
    public boolean expire(String key, Long time, TimeUnit timeUnit){
        try {
            if(time>0){
                redisTemplate.expire(key,time,timeUnit);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     * @param key 键
     * @param timeUnit 时间类型(秒,毫秒)
     * @return
     */
    public long getExpire(String  key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 存入的值
     * @return true 成功 false 失败
     */
    public boolean set(String key ,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 带失效时间的缓存放入
     * @param key 键
     * @param value 存入的值
     * @param time 时间
     * @param timeUnit 时间类型(秒 毫秒 分钟)
     * @return true 成功, false 失败
     */
    public boolean set(String key, Object value, Long time,TimeUnit timeUnit){
        try {
            redisTemplate.opsForValue().set(key,value,time,timeUnit);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 通过键获取value
     * @param key 存入的key
     * @return 值
     */
    public Object get(String key){
        return key == null ? null :redisTemplate.opsForValue().get(key);
    }
}
