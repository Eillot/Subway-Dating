package com.simon.subwaydating.service;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/14 15:42
 * @File : RedisService
 * @Software: IntelliJ IDEA 2017.3.2
 */
public interface RedisService {

    /**
     * add a token to Redis.
     * @param key
     * @param value
     * @return
     */
    boolean addToken(String key, Object value);

    /**
     * get user token form Redis.
     * @param key
     * @return
     */
    Object getToken(String key);
}
