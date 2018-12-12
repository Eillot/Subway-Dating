package com.simon.subwaydating.facade.dto;


/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :
 * @contact:
 * @Time : 2018/8/28 17:38
 * @File : UserDTO
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class UserDTO extends CommonDTO{


    /**
     * 用户登录账号
     */
    private String userLoginAccount;
    /**
     * 用户登录密码
     */
    private String userLoginPassword;

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


}
