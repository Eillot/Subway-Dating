package com.simon.subwaydating.facade.vo;

import com.simon.subwaydating.facade.constants.RegexpConstant;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain : vo  view data to users.
 * @contact:
 * @Time : 2018/8/29 15:53
 * @File : UserInfoVO
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class UserInfoVO {


    @NotEmpty(message = "用户名不能为空")
    @Max(value = 19,message ="用户名{common.lengthVerify}19",groups = { RegexpConstant.SUBMIT.class, RegexpConstant.MODIFY.class})
    private String userLoginAccount;

    private String userLoginPassword;

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
     * 用户创建日期
     */
    private Timestamp userCreateTime;

    public UserInfoVO(){}

    public UserInfoVO(@NotEmpty(message = "用户名不能为空") @Max(value = 19, message = "用户名{common.lengthVerify}19", groups = {RegexpConstant.SUBMIT.class, RegexpConstant.MODIFY.class}) String userLoginAccount,
                      String emails, long followers, long stars, String roles) {
        this.userLoginAccount = userLoginAccount;
        this.emails = emails;
        this.followers = followers;
        this.stars = stars;
        this.roles = roles;
    }

    public String getUserLoginAccount() {
        return userLoginAccount;
    }

    public void setUserLoginAccount(String userLoginAccount) {
        this.userLoginAccount = userLoginAccount;
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

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "emails='" + emails + '\'' +
                ", followers=" + followers +
                ", stars=" + stars +
                ", roles='" + roles + '\'' +
                '}';
    }
}
