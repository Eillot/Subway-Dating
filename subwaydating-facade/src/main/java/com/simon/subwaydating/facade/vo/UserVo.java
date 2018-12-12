package com.simon.subwaydating.facade.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/21 16:44
 * @File : UserVo
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class UserVo {

    /**
     * 主键
     */
    @JsonIgnore
    private Long id;

    /**
     * 用户登录账号
     */
    private String userLoginAccount;
    /**
     * 用户登录密码
     */
    @JsonIgnore
    private String userLoginPassword;

    /**
     * 用户创建日期
     */
    @JsonIgnore
    private Date userCreateTime;

    /**
     * 用户邮箱
     */
    private String emails;

    /**
     * 用户粉丝数
     */
    private long followers;

    /**
     * 用户订阅数
     */
    private long stars ;

    /**
     * 用户权限
     */
    private String roles;


    /**
     * 用户access token
     */
    @JsonIgnore
    private String userToken;

    /**
     * 访问api口令
     */
    @JsonIgnore
    private String usserAppkey;


    public String getUserLoginAccount() {
        return userLoginAccount;
    }

    public void setUserLoginAccount(String userLoginAccount) {
        this.userLoginAccount = userLoginAccount;
    }

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUsserAppkey() {
        return usserAppkey;
    }

    public void setUsserAppkey(String usserAppkey) {
        this.usserAppkey = usserAppkey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userLoginAccount='" + userLoginAccount + '\'' +
                ", userLoginPassword='" + userLoginPassword + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", emails='" + emails + '\'' +
                ", followers=" + followers +
                ", stars=" + stars +
                ", roles='" + roles + '\'' +
                ", userToken='" + userToken + '\'' +
                ", usserAppkey='" + usserAppkey + '\'' +
                '}';
    }
}
