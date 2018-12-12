package com.simon.subwaydating.engine.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain : 用户详情信息加密demon
 * @contact:
 * @Time : 2018/11/1 22:07
 * @File : JwtUser
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class JwtUser implements UserDetails{


    private Date lastPasswordResetDate;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
