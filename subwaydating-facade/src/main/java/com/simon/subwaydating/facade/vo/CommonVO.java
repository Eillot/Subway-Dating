package com.simon.subwaydating.facade.vo;

import java.io.Serializable;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/21 17:08
 * @File : CommonVO
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class CommonVO {

    /**
     * 用户token
     */
    private String appToken;

    /**
     * 访问api口令
     */
    private String Appkey;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getAppkey() {
        return Appkey;
    }

    public void setAppkey(String appkey) {
        Appkey = appkey;
    }


}
