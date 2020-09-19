package com.mall.userservice.util;

/**
 * @author cheng
 * @date 2020/7/14 12:11
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisClientUtil {
    @Resource
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        redisTemplate.setKeySerializer(new GenericToStringSerializer<>(String.class));
    }


    /**
     * redis存值
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * hash存
     *
     * @param key   键
     * @param hash  hash
     * @param value 值
     */
    public void set(String key, String hash, String value) {
        redisTemplate.opsForHash().put(key, hash, value);
    }

    /**
     * redis获取值
     *
     * @param key 键
     * @return 返回值
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * hash取值
     *
     * @param key  键
     * @param hash hash
     * @return 返回redis存取的值
     */
    public String get(String key, String hash) {
        return (String) redisTemplate.opsForHash().get(key, hash);
    }

    /**
     * 设置String键值对，并设置过期时间
     *
     * @param key
     * @param value
     * @param millis
     */
    public void set(String key, Object value, long millis) {
        redisTemplate.opsForValue().set(key, value, millis, TimeUnit.MINUTES);
    }

    /**
     * 从redis数据库中删除一条数据
     */
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 看对应的key是否存在
     */
    public boolean persist(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 对指定的key的键值减一
     * @param key
     * @return
     */
    public Long decrBy(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }

    /**
     * 获取redis的锁
     *
     * @param key   键
     * @param value 值为当前毫秒数加过期时间毫秒数
     * @return 返回true/false
     */
    public boolean lock(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        /**
         *  不加下面这个可能出现死锁情况
         *  value为当前时间+超时时间
         *  获取上一个锁的时间,并判断是否小于当前时间,小于就下一步判断,就返回true加锁成功
         *  currentValue=A 这两个线程的value都是B 其中一个线程拿到锁
         */
        String currentValue = (String) redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //存储时间要小于当前时间
            //出现死锁的另一种情况,当多个线程进来后都没有返回true,接着往下执行,执行代码有先后,而if判断里只有一个线程才能满足条件
            //oldValue=currentValue
            //多个线程进来后只有其中一个线程能拿到锁(即oldValue=currentValue),其他的返回false
            //获取上一个锁的时间
            String oldValue = (String) redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                //上一个时间不为空，并且等于当前时间
                return true;
            }
        }
        return false;
    }

    public void unlock(String key, String value) {
        try {
            String currentValue = (String) redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                //如果不为空，就删除锁
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
