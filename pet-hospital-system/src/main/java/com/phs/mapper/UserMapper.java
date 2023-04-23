package com.phs.mapper;

import com.phs.entity.UserEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface UserMapper {

    List<UserEntity> getAllUser();

    List<String> getAllUserName();

    void insertUser(UserEntity user);

    UserEntity getUserByUserName(String userName);

}
