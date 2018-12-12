package com.simon.subwaydating.facade.dto;

import com.simon.subwaydating.facade.constants.RegexpConstant;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/8/28 17:40
 * @File : CommonDTO
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class CommonDTO implements Serializable{


    private static final long serialVersionUID = -1306745857511257905L;

    /**
     * 用户token
     */
    private String userToken;

    /**
     * 访问api口令
     */
    private String usserAppkey;

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

    @Override
    public String toString() {
        return "CommonDTO{" +
                "userToken='" + userToken + '\'' +
                ", usserAppkey='" + usserAppkey + '\'' +
                '}';
    }
}
