package com.simon.subwaydating.engine;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/20 11:12
 * @File : IRedisEngine
 * @Software: IntelliJ IDEA 2017.3.2
 */
public interface IRedisEngine {


    //=============================common============================

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

    /**
     * set key's life time.
     * @param key
     * @param time
     * @return
     */
    boolean setKeyLifeTime(String key, long time);

    /**
     * get Redis' key expire date.
     * @param key
     */
    long getExpire(String key);

    /**
     * key is or not existed.
     * @param key
     * @return
     */
    boolean isKeyExisted(String key);

    //============================String=============================

    Object get(String key);

    boolean set(String key, Object value);

    void setStrKV(String key,String value);

    void setForTimeMS(String key,String value,long time);

    void setForTimeMIN(String key,String value,long time);

    void setForTimeCustom(String key,String value,long time,TimeUnit type);

    String getAndSet(String key,String value);

    void batchSet(Map<String,String> keyAndValue);

    void batchSetIfAbsent(Map<String,String> keyAndValue);

    Long increment(String key,long number);

    Double increment(String key,double number);

    boolean expire(String key,long time,TimeUnit type);

    boolean persist(String key);

    void rename(String key,String newKey);

    void delete(String ... key);

    //===============================hash操作==============================
    void put(String key, String hashKey, String value);

    void putAll(String key,Map<String,String> map);

    boolean putIfAbsent(String key, String hashKey, String value);

    Long delete(String key, String ...hashKeys);

    Long increment(String key, String hashKey,long number);

    Double increment(String key, String hashKey,Double number);

    Object getHashKey(String key,String hashKey);

    Map<Object,Object> getHashEntries(String key);

    boolean isHashKey(String key,String hashKey);

    Set<Object> hashKeys(String key);

    Long hashSize(String key);

    Long leftPush(String key,Object value);

    Object leftPop(String key);

    Long leftPushAll(String key,Collection<Object> values);

    Long rightPush(String key,Object value);

    Object rightPop(String key);

    Long rightPushAll(String key,Collection<Object> values);

    Object popIndex(String key,long index);

    Long listSize(String key,long index);

    List<Object> listRange(String key, long start, long end);

    Long listRemove(String key,long count,Object value);

    void listTrim(String key,long start,long end);

    Object rightPopAndLeftPush(String key,String key2);

    Long add(String key ,String ...values);

    Set<Object> difference(String key ,String key2);

    Set<Object> difference(String key ,Collection<Object> otherKeys);

    Long differenceAndStore(String key ,String otherkey,String newKey);

    Long remove(String key,Object ...values);

    Object randomSetPop(String key);

    Object randomSet(String key);

    List<Object> randomSet(String key,long count);

    Set<Object> randomSetDistinct(String key,long count);

    boolean moveSet(String key,Object value,String destKey);

    Long setSize(String key);

    boolean isMember(String key,Object value);

    Set<Object> unionSet(String key,String otherKey);

    Long unionAndStoreSet(String key, String otherKey,String destKey);

    Set<Object> members(String key);

    boolean add(String key,Object value,double score);

    Long batchAddZset(String key,Set<ZSetOperations.TypedTuple<Object>> tuples);

    Long removeZset(String key,String ...values);

    Double incrementScore(String key,Object value,double score);

    Long rank(String key,Object value);

    Long reverseRank(String key,Object value);

    Set<ZSetOperations.TypedTuple<Object>> rangeWithScores(String key, long start, long end);

    Set<Object> range(String key, long start, long end);

    Set<Object> rangeByScore(String key, double min, double max);

    Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max);

    Set<Object> rangeByScore(String key, double min, double max,long offset,long count);

    Set<ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count);

    Set<Object> reverseRange(String key,long start,long end);

    Set<ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end);

    Set<Object> reverseRangeByScore(String key,double min,double max);

    Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max);

    Set<Object> reverseRangeByScore(String key,double min,double max,long offset,long count);

    Set<ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count);

    long countZSet(String key,double min,double max);

    long sizeZset(String key);

    Double score(String key,Object value);

    Long removeRange(String key,long start ,long end);

    Long removeRangeByScore(String key,double min ,double max);

    Long unionAndStoreZset(String key,String otherKey,String destKey);

    Long unionAndStoreZset(String key, Collection<String> otherKeys, String destKey);

    Long intersectAndStore(String key,String otherKey,String destKey);

    Long intersectAndStore(String key,Collection<String> otherKeys,String destKey);

}
