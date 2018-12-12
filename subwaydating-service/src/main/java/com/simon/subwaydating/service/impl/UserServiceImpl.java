package com.simon.subwaydating.service.impl;

import com.simon.subwaydating.dao.domain.User;
import com.simon.subwaydating.dao.mapper.UserMapper;
import com.simon.subwaydating.engine.IUserEngine;
import com.simon.subwaydating.facade.UserFacade;
import com.simon.subwaydating.facade.dto.UserDTO;
import com.simon.subwaydating.facade.dto.UserInfoDTO;
import com.simon.subwaydating.facade.support.CommonResult;
import com.simon.subwaydating.facade.vo.UserInfoVO;
import com.simon.subwaydating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/11/9 16:02
 * @File : UserServiceImpl
 * @Software: IntelliJ IDEA 2017.3.2
 */

@Service
public class UserServiceImpl implements UserFacade {

    @Autowired private IUserEngine iUserEngine;

    @Override
    public CommonResult<UserInfoVO> queryUserInfoByAccount(UserInfoDTO userInfoDTO) throws ServletException{

        CommonResult<UserInfoVO> commonResult = iUserEngine.queryUserInfoByAccount(userInfoDTO);
        return commonResult;
    }

    @Override
    public CommonResult userAuthenticated(UserDTO userDTO) throws ServletException{
        CommonResult commonResult = iUserEngine.userAuth(userDTO);
        return commonResult;
    }

    @Override
    public CommonResult userRegister(UserDTO userDTO) throws ServletException{
        CommonResult commonResult = iUserEngine.userRegister(userDTO);
        return commonResult;
    }

    @Override
    public CommonResult insertUser(UserInfoVO userInfoVO) throws ServletException{
        CommonResult commonResult = new CommonResult();
        commonResult=iUserEngine.saveUserInfo(userInfoVO);
        return commonResult;

    }

    @Override
    public CommonResult updateUser(UserInfoVO userInfoVO) throws ServletException{
        CommonResult commonResult = new CommonResult();
        commonResult=iUserEngine.updateUserInfo(userInfoVO);
        return commonResult;
    }

}
