package com.simon.subwaydating.engine.impl;

import com.simon.subwaydating.engine.IRedisEngine;
import com.simon.subwaydating.engine.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :
 * @contact:
 * @Time : 2018/11/20 11:13
 * @File : RedisEngineImp
 * @Software: IntelliJ IDEA 2017.3.2
 */
@Component
public class RedisEngineImp implements IRedisEngine{

    @Autowired
    private RedisUtil redisUtil;

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

    @Override
    public boolean setKeyLifeTime(String key, long time) {
        return redisUtil.setKeyLifeTime(key,time);
    }

    @Override
    public long getExpire(String key) {
        return redisUtil.getExpire(key);
    }

    @Override
    public boolean isKeyExisted(String key) {
        return redisUtil.isKeyExisted(key);
    }

    @Override
    public Object get(String key) {
        return redisUtil.get(key);
    }

    @Override
    public boolean set(String key, Object value) {
        return redisUtil.set(key,value);
    }

    @Override
    public void setStrKV(String key, String value) {
        redisUtil.setKeyKV(key,value);
    }

    @Override
    public void setForTimeMS(String key, String value, long time) {
        redisUtil.setForTimeMS(key,value,time);
    }

    @Override
    public void setForTimeMIN(String key, String value, long time) {
        redisUtil.setForTimeMIN(key,value,time);
    }

    @Override
    public void setForTimeCustom(String key, String value, long time, TimeUnit type) {
        redisUtil.setForTimeCustom(key,value,time,type);
    }

    @Override
    public String getAndSet(String key, String value) {
        return redisUtil.getAndSet(key,value);
    }

    @Override
    public void batchSet(Map<String, String> keyAndValue) {
            redisUtil.batchSet(keyAndValue);
    }

    @Override
    public void batchSetIfAbsent(Map<String, String> keyAndValue) {
            redisUtil.batchSetIfAbsent(keyAndValue);
    }

    @Override
    public Long increment(String key, long number) {
        return redisUtil.increment(key,number);
    }

    @Override
    public Double increment(String key, double number) {
        return redisUtil.increment(key,number);
    }

    @Override
    public boolean expire(String key, long time, TimeUnit type) {
        return redisUtil.expire(key,time,type);
    }

    @Override
    public boolean persist(String key) {
        return redisUtil.persist(key);
    }

    @Override
    public void rename(String key, String newKey) {
        redisUtil.rename(key,newKey);
    }

    @Override
    public void delete(String... key) {
        redisUtil.delete(key);
    }

    @Override
    public void put(String key, String hashKey, String value) {
        redisUtil.put(key,hashKey,value);
    }

    @Override
    public void putAll(String key, Map<String, String> map) {
        redisUtil.putAll(key,map);
    }

    @Override
    public boolean putIfAbsent(String key, String hashKey, String value) {
        return redisUtil.putIfAbsent(key,hashKey,value);
    }

    @Override
    public Long delete(String key, String... hashKeys) {
        return redisUtil.delete(key,hashKeys);
    }

    @Override
    public Long increment(String key, String hashKey, long number) {
        return redisUtil.increment(key,hashKey,number);
    }

    @Override
    public Double increment(String key, String hashKey, Double number) {
        return redisUtil.increment(key,hashKey,number);
    }

    @Override
    public Object getHashKey(String key, String hashKey) {
        return redisUtil.getHashKey(key,hashKey);
    }

    @Override
    public Map<Object, Object> getHashEntries(String key) {
        return redisUtil.getHashEntries(key);
    }

    @Override
    public boolean isHashKey(String key, String hashKey) {
        return redisUtil.isHashKey(key,hashKey);
    }

    @Override
    public Set<Object> hashKeys(String key) {
        return redisUtil.hashKeys(key);
    }

    @Override
    public Long hashSize(String key) {
        return redisUtil.hashSize(key);
    }

    @Override
    public Long leftPush(String key, Object value) {
        return redisUtil.leftPush(key,value);
    }

    @Override
    public Object leftPop(String key) {
        return redisUtil.leftPop(key);
    }

    @Override
    public Long leftPushAll(String key, Collection<Object> values) {
        return redisUtil.leftPushAll(key,values);
    }

    @Override
    public Long rightPush(String key, Object value) {
        return redisUtil.rightPush(key,value);
    }

    @Override
    public Object rightPop(String key) {
        return redisUtil.rightPop(key);
    }

    @Override
    public Long rightPushAll(String key, Collection<Object> values) {
        return redisUtil.rightPushAll(key,values);
    }

    @Override
    public Object popIndex(String key, long index) {
        return redisUtil.popIndex(key,index);
    }

    @Override
    public Long listSize(String key, long index) {
        return redisUtil.listSize(key,index);
    }

    @Override
    public List<Object> listRange(String key, long start, long end) {
        return redisUtil.listRange(key,start,end);
    }

    @Override
    public Long listRemove(String key, long count, Object value) {
        return redisUtil.listRemove(key,count,value);
    }

    @Override
    public void listTrim(String key, long start, long end) {
        redisUtil.listTrim(key,start,end);
    }

    @Override
    public Object rightPopAndLeftPush(String key, String key2) {
        return redisUtil.rightPopAndLeftPush(key,key2);
    }

    @Override
    public Long add(String key, String... values) {
        return redisUtil.add(key,values);
    }

    @Override
    public Set<Object> difference(String key, String key2) {
        return redisUtil.difference(key,key2);
    }

    @Override
    public Set<Object> difference(String key, Collection<Object> otherKeys) {
        return redisUtil.difference(key,otherKeys);
    }

    @Override
    public Long differenceAndStore(String key, String otherkey, String newKey) {
        return redisUtil.differenceAndStore(key,otherkey,newKey);
    }

    @Override
    public Long remove(String key, Object... values) {
        return redisUtil.remove(key,values);
    }

    @Override
    public Object randomSetPop(String key) {
        return redisUtil.randomSetPop(key);
    }

    @Override
    public Object randomSet(String key) {
        return redisUtil.randomSet(key);
    }

    @Override
    public List<Object> randomSet(String key, long count) {
        return redisUtil.randomSet(key,count);
    }

    @Override
    public Set<Object> randomSetDistinct(String key, long count) {
        return redisUtil.randomSetDistinct(key,count);
    }

    @Override
    public boolean moveSet(String key, Object value, String destKey) {
        return redisUtil.moveSet(key,value,destKey);
    }

    @Override
    public Long setSize(String key) {
        return redisUtil.setSize(key);
    }

    @Override
    public boolean isMember(String key, Object value) {
        return redisUtil.isMember(key,value);
    }

    @Override
    public Set<Object> unionSet(String key, String otherKey) {
        return redisUtil.unionSet(key,otherKey);
    }

    @Override
    public Long unionAndStoreSet(String key, String otherKey, String destKey) {
        return redisUtil.unionAndStoreSet(key,otherKey,destKey);
    }

    @Override
    public Set<Object> members(String key) {
        return redisUtil.members(key);
    }

    @Override
    public boolean add(String key, Object value, double score) {
        return redisUtil.add(key,value,score);
    }

    @Override
    public Long batchAddZset(String key, Set<ZSetOperations.TypedTuple<Object>> tuples) {
        return redisUtil.batchAddZset(key,tuples);
    }

    @Override
    public Long removeZset(String key, String... values) {
        return redisUtil.removeZset(key,values);
    }

    @Override
    public Double incrementScore(String key, Object value, double score) {
        return redisUtil.incrementScore(key,value,score);
    }

    @Override
    public Long rank(String key, Object value) {
        return redisUtil.rank(key,value);
    }

    @Override
    public Long reverseRank(String key, Object value) {
        return redisUtil.reverseRank(key,value);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> rangeWithScores(String key, long start, long end) {
        return redisUtil.rangeWithScores(key,start,end);
    }

    @Override
    public Set<Object> range(String key, long start, long end) {
        return redisUtil.range(key,start,end);
    }

    @Override
    public Set<Object> rangeByScore(String key, double min, double max) {
        return redisUtil.rangeByScore(key,min,max);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max) {
        return redisUtil.rangeByScoreWithScores(key,min,max);
    }

    @Override
    public Set<Object> rangeByScore(String key, double min, double max, long offset, long count) {
        return redisUtil.rangeByScore(key,min,max,offset,count);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisUtil.rangeByScoreWithScores(key,max,max,offset,count);
    }

    @Override
    public Set<Object> reverseRange(String key, long start, long end) {
        return redisUtil.reverseRange(key,start,end);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end) {
        return redisUtil.reverseRangeWithScores(key,start,end);
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max) {
        return redisUtil.reverseRangeByScore(key,min,max);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max) {
        return redisUtil.reverseRangeByScoreWithScores(key,min,max);
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count) {
        return redisUtil.reverseRangeByScore(key,min,max,offset,count);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisUtil.reverseRangeByScoreWithScores(key,min,max,offset,count);
    }

    @Override
    public long countZSet(String key, double min, double max) {
        return redisUtil.countZSet(key,min,max);
    }

    @Override
    public long sizeZset(String key) {
        return redisUtil.sizeZset(key);
    }

    @Override
    public Double score(String key, Object value) {
        return redisUtil.score(key,value);
    }

    @Override
    public Long removeRange(String key, long start, long end) {
        return redisUtil.removeRange(key,start,end);
    }

    @Override
    public Long removeRangeByScore(String key, double min, double max) {
        return redisUtil.removeRangeByScore(key,min,max);
    }

    @Override
    public Long unionAndStoreZset(String key, String otherKey, String destKey) {
        return redisUtil.unionAndStoreZset(key,otherKey,destKey);
    }

    @Override
    public Long unionAndStoreZset(String key, Collection<String> otherKeys, String destKey) {
        return redisUtil.unionAndStoreZset(key,otherKeys,destKey);
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destKey) {
        return redisUtil.intersectAndStore(key,otherKey,destKey);
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destKey) {
        return redisUtil.intersectAndStore(key,otherKeys,destKey);

    }


}
