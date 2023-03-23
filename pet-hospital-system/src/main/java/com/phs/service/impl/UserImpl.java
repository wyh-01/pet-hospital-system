package com.phs.service.impl;

import com.phs.entity.ResultEntity;
import com.phs.entity.UserEntity;
import com.phs.mapper.UserMapper;
import com.phs.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultEntity getVerifyResult(String userName, String password){
        if(isNotBlank(userName) && checkUserNameExist(userName)){
            if(isNotBlank(password) && verifyPassword(userName, password)){
                return ResultEntity.success("登陆成功");
            }
            else{
                return ResultEntity.error("密码错误，请重新输入");
            }
        }
        else{
            ResultEntity.error("没有相关用户");
        }
        return ResultEntity.error("登录失败");
    }

    @Override
    public ResultEntity saveUser(String userName, String password){
        if(isNotBlank(userName)){
            if(!checkUserNameExist(userName)) {
                if (isNotBlank(password)) {
                    userMapper.insertUser(new UserEntity(userName, password, 2));
                    return ResultEntity.success("注册成功");
                } else {
                    return ResultEntity.error("密码不合规，请重新输入");
                }
            }else{
                return ResultEntity.error("该用户名已存在，请重新输入");
            }
        }else{
            return ResultEntity.error("用户名不能为空，请重新输入");
        }
    }

    private boolean checkUserNameExist(String userName){
        List<String> userNames = userMapper.getAllUserName();
        if(userNames.contains(userName)){ return true; }
        return false;
    }

    private boolean isNotBlank(String s){
        if(null != s && s.length() > 0){ return true; }
        return false;
    }

    private boolean verifyPassword(String userName, String password){
        List<UserEntity> users = userMapper.getAllUser();
        boolean flag = false;
        for(UserEntity user:users){
            if(user.getUserName().equals(userName)){
                if(user.getPassword().equals(password)){
                    flag = true;
                    break;
                }
                else {
                    break;
                }
            }
        }
        return flag;
    }

}
