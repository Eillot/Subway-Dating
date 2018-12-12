package com.simon.subwaydating.controller;

import com.simon.subwaydating.facade.UserFacade;
import com.simon.subwaydating.facade.dto.UserDTO;
import com.simon.subwaydating.facade.dto.UserInfoDTO;
import com.simon.subwaydating.facade.support.CommonResult;
import com.simon.subwaydating.facade.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;


/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/8/28 18:15
 * @File :
 * @Software: IntelliJ IDEA 2017.3.2
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 注入用户登录认证facade
     */
    @Autowired
    public UserFacade userFacade;

    /**
     * 用户首次登陆注册操作
     *
     * @param userDTO
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult userRegister(@RequestBody() UserDTO userDTO) throws ServletException {

        CommonResult commonResult = new CommonResult();
        commonResult = userFacade.userRegister(userDTO);

        return commonResult;
    }

    /**
     * 用户(访问服务)认证操作
     *
     * @param userDTO
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/authorizations", method = RequestMethod.POST)
    public CommonResult userAuth(@RequestBody() UserDTO userDTO) throws ServletException {

        CommonResult commonResult = new CommonResult();
        commonResult = userFacade.userAuthenticated(userDTO);
        return commonResult;
    }

    /**
     * 查询用户信息
     *
     * @param userInfoDTO
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.POST)
    public CommonResult queryUserInfo(@RequestBody() UserInfoDTO userInfoDTO) throws ServletException {
        CommonResult commonResult = new CommonResult();
        commonResult = userFacade.queryUserInfoByAccount(userInfoDTO);
        return commonResult;
    }

    /**
     * update user info .
     * @param userInfoVO
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public CommonResult updateAuthUserInfo(@RequestBody() UserInfoVO userInfoVO) throws ServletException {
        CommonResult commonResult = new CommonResult();
        commonResult=userFacade.updateUser(userInfoVO);
        commonResult.setMsg("用户信息更新成功");
        commonResult.setStatus("200");

        return commonResult;
    }

    /**
     * save user info
     * @param userInfoVO
     * @throws ServletException
     */
    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    public CommonResult saveUserAuthInfo(@RequestBody() UserInfoVO userInfoVO) throws ServletException {

        CommonResult commonResult = new CommonResult();
        commonResult=userFacade.insertUser(userInfoVO);
        commonResult.setMsg("用户信息保存成功");
        commonResult.setStatus("200");
        return commonResult;
    }

}


