package com.leaveword.service;

import com.alibaba.fastjson.JSON;
import com.leaveword.Utils.CommonTools;
import com.leaveword.Utils.Response;
import com.leaveword.domain.User;
import com.leaveword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Response getUser(Integer userId) {
        User user = null;
        if((user = userRepository.findOne(userId))!=null)
            return new Response();
        else
            return new Response();
    }

    @Override
    public Response userRegister(String userName, String userPassword) {
        if(CommonTools.isEmpty(userName))
            return new Response();
        if(CommonTools.isEmpty(userPassword))
            return new Response();
        try {
            if(userRepository.findByUserName(userName)!=null)
                return new Response();
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setRegisterTime(CommonTools.getCurrentTime());
            user = userRepository.save(user);
            user.setUserPassword("");
            return new Response();
        }catch (Exception e){
            return new Response();
        }
    }

    @Override
    public Response userLogin(String userName, String userPassword) {
        if(CommonTools.isEmpty(userName))
            return new Response("-1","用户名不能为空");
        if(CommonTools.isEmpty(userPassword))
            return new Response("-1","用户密码不能为空");
        User user = userRepository.findByUserName(userName);
        if(user != null){
            if(user.getUserPassword().equals(userPassword)) {
                user.setUserPassword("");
                return new Response("0", JSON.toJSONString(user));
            }
            else
                return new Response("-1","密码错误");
        }
        else
            return new Response("-1","用户不存在");
    }

}
