package com.simon.subwaydating.service;


import com.simon.subwaydating.dao.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @version: java version 1.7+
 * @Author : Simon
 * @Explain :
 * @contact:
 * @Time : 2018/8/28 15:26
 * @File : UserService
 * @Software: IntelliJ IDEA 2017.3.2
 */

public interface UserService{

    /**
     * Find a User from Ignite DB with given name.
     * @param name the given name
     * @return The User found in  DB
     */
    User findPersonByUsername(String name);

    /**
     * Insert into a User in DB.
     * @param user
     * @return
     */
     void insertUser(User user);

    /**
     * Update a User in DB.
     * @param user
     * @return
     */
    void updateUser(User user);

}
