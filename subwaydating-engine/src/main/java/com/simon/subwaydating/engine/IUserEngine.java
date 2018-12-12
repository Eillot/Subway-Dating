package com.simon.subwaydating.engine;

import com.simon.subwaydating.facade.dto.UserDTO;
import com.simon.subwaydating.facade.dto.UserInfoDTO;
import com.simon.subwaydating.facade.support.CommonResult;
import com.simon.subwaydating.facade.vo.CommonVO;
import com.simon.subwaydating.facade.vo.UserInfoVO;

import javax.servlet.ServletException;
import java.util.Map;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain : 用户登录信息Engine接口类
 * @contact:
 * @Time : 2018/11/1 19:17
 * @File : IUserEngine
 * @Software: IntelliJ IDEA 2017.3.2
 */
public interface IUserEngine {

    CommonResult userRegister(UserDTO userDTO) throws ServletException;

    CommonResult userAuth(UserDTO userDTO) throws ServletException;

    CommonResult<UserInfoVO> queryUserInfoByAccount(UserInfoDTO userInfoDTO) throws ServletException;

//    void updateUserInfo(UserInfoVO userInfoVO);
//
//    void saveUserInfo(UserInfoVO userInfoVO);

    CommonResult updateUserInfo(UserInfoVO userInfoVO)throws ServletException;

    CommonResult saveUserInfo(UserInfoVO userInfoVO)throws ServletException;

}
