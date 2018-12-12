package com.simon.subwaydating.engine;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/16 17:27
 * @File : TokenEngineImp
 * @Software: IntelliJ IDEA 2017.3.2
 */
public interface ITokenEngine {

    /**
     * get user name from token.
     * @param token
     * @return
     */
    String getUsernameFromToken(String token);

    /**
     * get issued(发行) date from token.
     * @param token
     * @return
     */
    Date getIssuedAtDateFromToken(String token);

    /**
     * get  expiration(满期) Date from token.
     * @param token
     * @return
     */
    Date getExpirationDateFromToken(String token);

    /**
     * 获取token身份信息.
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    /**
     * 获取token所有的身份信息
     * @param token
     * @return
     */
    Claims getAllClaimsFromToken(String token);

    /**
     * 判断token是否满（过）期
     * @param token
     * @return
     */
    Boolean isTokenExpired(String token);

    /**
     * 判断（日期）是否是上次密码重置前创建的
     * @param created
     * @param lastPasswordReset
     * @return
     */
    Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset);

    /**
     * 指定token并忽略（它的）满(过)期
     * @param token
     * @return
     */
    Boolean ignoreTokenExpiration(String token);

    /**
     * (通用的方式)生成的token
     * @param userDetails
     * @return
     */
    String generateToken(UserDetails userDetails,Long expiration);

    /**
     * 组装生成token
     * @param claims
     * @param subject
     * @return
     */
    String doGenrateToken(Map<String,Object> claims,String subject,Long expiration);

    /**
     * 判断token是否需要被刷新
     * @param token
     * @param lastPasswordReset
     * @return
     */
    Boolean canTokenBeRefreshed(String token, Date lastPasswordReset);

    /**
     * 刷新token
     * @param token
     * @return
     */
    String refreshToken(String token,Long expiration);

    /**
     * 校验(用户属性中的)token是否合法
     * @param token
     * @param userDetails
     * @return
     */
    Boolean validateToken(String token, UserDetails userDetails);

    /**
     * 校验token是否合法
     * @param token
     * @return
     */
    Boolean validateToken(String token);

    /**
     * 计算截止日期
     * @param createdDate
     * @return
     */
    Date calculateExpirationDate(Date createdDate,Long expiration);

    /**
     * 获取用户最后重置密码的日期
     * @param lastPasswordResetDate
     * @return
     */
    Date getLastPasswordResetDate(Date lastPasswordResetDate);

}
