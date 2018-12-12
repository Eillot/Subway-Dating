package com.simon.subwaydating.facade;

import com.simon.subwaydating.facade.dto.UserDTO;
import com.simon.subwaydating.facade.dto.UserInfoDTO;
import com.simon.subwaydating.facade.support.CommonResult;
import com.simon.subwaydating.facade.vo.UserInfoVO;

import javax.servlet.ServletException;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain : 数据传输层被传输数据封装
 * @contact:
 * @Time : 2018/8/29 16:51
 * @File : UserFacade
 * @Software: IntelliJ IDEA 2017.3.2
 */

public interface UserFacade {

    CommonResult<UserInfoVO> queryUserInfoByAccount(UserInfoDTO userInfoDTO) throws ServletException;

    CommonResult userAuthenticated(UserDTO userDTO) throws ServletException;

    CommonResult userRegister(UserDTO userDTO) throws ServletException;

    /**
     * Insert into a User in DB.
     * @param userInfoVO
     * @return
     */
    //void insertUser(UserInfoVO userInfoVO);
    CommonResult insertUser(UserInfoVO userInfoVO)throws ServletException;

    /**
     * Update a User in DB.
     * @param userInfoVO
     * @return
     */
   // void updateUser(UserInfoVO userInfoVO);
    CommonResult updateUser(UserInfoVO userInfoVO)throws ServletException;

}
