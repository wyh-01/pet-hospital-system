package com.phs.service.impl;

import com.phs.entity.UserEntity;
import com.phs.mapper.UserMapper;
import com.phs.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity getVerifyResult(String userName, String password, HttpServletRequest request){
        if(isNotBlank(userName) && checkUserNameExist(userName)){
            if(isNotBlank(password) && verifyPassword(userName, password)){
                //验证成功，记录Session信息
                request.getSession().setAttribute("userName", userName);
                request.getSession().setAttribute("role", userMapper.getUserByUserName(userName).getRole());
                return new ResponseEntity("登录成功", HttpStatus.OK);
            }
            else{
                return new ResponseEntity("密码错误，请重新输入", HttpStatus.UNAUTHORIZED);
            }
        }
        else{
            return new ResponseEntity("没有相关用户", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity saveUser(String userName, String password){
        if(isNotBlank(userName)){
            if(!checkUserNameExist(userName)) {
                if (isNotBlank(password)) {
                    userMapper.insertUser(new UserEntity(userName, password, 2));
                    return new ResponseEntity("注册成功", HttpStatus.OK);
                } else {
                    return new ResponseEntity("密码不合规，请重新输入", HttpStatus.BAD_REQUEST);
                }
            }else{
                return new ResponseEntity("该用户名已存在，请重新输入", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity("用户名不能为空，请重新输入", HttpStatus.BAD_REQUEST);
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
