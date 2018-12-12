package com.simon.subwaydating.service.impl;


import com.simon.subwaydating.engine.util.RedisUtil;
import com.simon.subwaydating.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/14 16:49
 * @File : RedisServiceImp
 * @Software: IntelliJ IDEA 2017.3.2
 */

@Service
public class RedisServiceImp implements RedisService{

    @Autowired private RedisUtil redisUtil;

    @Override
    public boolean addToken(String key, Object value) {
        redisUtil.set(key,value);
        return true;
    }

    @Override
    public Object getToken(String key) {
        Object object=redisUtil.get(key);
        return object;
    }
}
