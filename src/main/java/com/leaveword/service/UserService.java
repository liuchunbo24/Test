package com.leaveword.service;

import com.leaveword.Utils.Response;

/**
 * Created by Administrator on 2018/7/24.
 */
public interface UserService {
    Response getUser(Integer userId);
    Response userRegister(String userName,String userPassword);
    Response userLogin(String userName,String userPassword);
}
