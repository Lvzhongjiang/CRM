package com.hy.crm.util;


import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @Auther: wangsq
 * @Date: 2019/7/26 16:22
 * @Description:
 */
public class RedisConnRef {

    public void setConnectionFactory(JedisConnectionFactory connectionFactory) {
        RedisCache.setJedisConnectionFactory(connectionFactory);
    }
}
