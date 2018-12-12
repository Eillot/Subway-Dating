package com.simon.subwaydating.facade.dto;

import java.util.HashMap;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain : to get users infomation ,example: username , flowing .
 * @contact:
 * @Time : 2018/11/13 15:12
 * @File : UserInfoDTO
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class UserInfoDTO extends CommonDTO{

    private static final long serialVersionUID = 682802119259960871L;

    /**
     * user access token
     */
    private String accessToken;

    /**
     * user login account
     */
    private String userLoginAccount;


    public UserInfoDTO(){

    }

    public UserInfoDTO(String accessToken, String userLoginAccount) {
        this.accessToken = accessToken;
        this.userLoginAccount = userLoginAccount;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserLoginAccount() {
        return userLoginAccount;
    }

    public void setUserLoginAccount(String userLoginAccount) {
        this.userLoginAccount = userLoginAccount;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "accessToken='" + accessToken + '\'' +
                ", userLoginAccount='" + userLoginAccount + '\'' +
                '}';
    }
}
