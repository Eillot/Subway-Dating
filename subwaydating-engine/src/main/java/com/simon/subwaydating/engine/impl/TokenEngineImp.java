package com.simon.subwaydating.engine.impl;

import com.simon.subwaydating.engine.ITokenEngine;
import com.simon.subwaydating.engine.util.*;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/16 17:26
 * @File :
 * @Software: IntelliJ IDEA 2017.3.2
 */

@Component
public class TokenEngineImp implements ITokenEngine{

    public JwtTokenUtil jwtTokenUtil=new JwtTokenUtil();

    public TokenEngineImp() {
    }

    @Override
    public String getUsernameFromToken(String token) {
        return jwtTokenUtil.getUsernameFromToken(token);
    }

    @Override
    public Date getIssuedAtDateFromToken(String token) {
        return jwtTokenUtil.getIssuedAtDateFromToken(token);
    }

    @Override
    public Date getExpirationDateFromToken(String token) {
        return jwtTokenUtil.getExpirationDateFromToken(token);
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        return jwtTokenUtil.getClaimFromToken(token,claimsResolver);
    }

    @Override
    public Claims getAllClaimsFromToken(String token) {
        return jwtTokenUtil.getAllClaimsFromToken(token);
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return jwtTokenUtil.isTokenExpired(token);
    }

    @Override
    public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return jwtTokenUtil.isCreatedBeforeLastPasswordReset(created,lastPasswordReset);
    }

    @Override
    public Boolean ignoreTokenExpiration(String token) {
        return jwtTokenUtil.ignoreTokenExpiration(token);
    }

    @Override
    public String generateToken(UserDetails userDetails,Long expiration) {
        return jwtTokenUtil.generateToken(userDetails,expiration);
    }

    @Override
    public String doGenrateToken(Map<String, Object> claims, String subject,Long expiration) {
        return jwtTokenUtil.doGenerateToken(claims,subject,expiration);
    }

    @Override
    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        return jwtTokenUtil.canTokenBeRefreshed(token,lastPasswordReset);
    }

    @Override
    public String refreshToken(String token,Long expiration) {
        return jwtTokenUtil.refreshToken(token,expiration);
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        return jwtTokenUtil.validateToken(token,userDetails);
    }

    @Override
    public Boolean validateToken(String token) {
        return null;
    }

    @Override
    public Date calculateExpirationDate(Date createdDate, Long expiration) {
        return jwtTokenUtil.calculateExpirationDate(createdDate,expiration);
    }

    @Override
    public Date getLastPasswordResetDate(Date lastPasswordResetDate) {
        return jwtTokenUtil.getLastPasswordResetDate(lastPasswordResetDate);
    }
}
