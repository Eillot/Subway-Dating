package com.simon.subwaydating.dao.mapper;

import com.simon.subwaydating.dao.domain.User;
import org.springframework.stereotype.Component;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :
 * @contact:
 * @Time : 2018/8/28 15:48
 * @File : UserMapper
 * @Software: IntelliJ IDEA 2017.3.2
 */
@Component
public interface UserMapper {

    /**
     * 根据用户登录账号查询用户信息
     * @param userLoginAccount
     * @return
     */
     User findUserByUserLoginAccount(String userLoginAccount);

    /**
     * 保存用户信息
     * @param user
     */
    void insert(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);


}
