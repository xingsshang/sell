package com.etoak.service;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/26
 */
@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * @param *     @param key productId
     * @param value 当前时间+加上超时时间
     * @return boolean
     * @author xingsshang
     * @date 2018/5/26 11:26
     */
    public boolean lock(String key, String value) {

        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        /*如果锁过期*/
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            /*获取上一个锁的时间*/
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equalsIgnoreCase(currentValue)) {
                return true;
            }
        }
        return false;
    }

    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && value.equals(currentValue)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }

        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常 e:{}",e);
        }

    }
}
