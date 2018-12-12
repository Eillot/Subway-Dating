package com.simon.subwaydating.dao.domain;



import java.util.Date;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :用户实体类
 * @contact:
 * @Time : 2018/8/28 14:54
 * @File : User
 * @Software: IntelliJ IDEA 2017.3.2
 */

public class User {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户登录账号
     */
    private String userLoginAccount;
    /**
     * 用户登录密码
     */
    private String userLoginPassword;

    /**
     * 用户创建日期
     */
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
    private String userToken;

    public User(){
    }

    public User(String userLoginAccount, String userToken) {
        this.userLoginAccount = userLoginAccount;
        this.userToken = userToken;
    }

    public User(String userLoginAccount, String userLoginPassword, Date userCreateTime, String roles, String userToken) {
        this.userLoginAccount = userLoginAccount;
        this.userLoginPassword = userLoginPassword;
        this.userCreateTime = userCreateTime;
        this.roles = roles;
        this.userToken = userToken;
    }

    public User(String userLoginAccount, String userLoginPassword, String roles) {
        this.userLoginAccount = userLoginAccount;
        this.userLoginPassword = userLoginPassword;
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLoginAccount() {
        return this.userLoginAccount;
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

    @Override
    public String toString() {
        return "User{" +
                "userLoginAccount='" + userLoginAccount + '\'' +
                ", emails='" + emails + '\'' +
                ", followers=" + followers +
                ", stars=" + stars +
                ", roles='" + roles + '\'' +
                '}';
    }


}
