package com.phs.service.facade;

import com.phs.entity.ResultEntity;

/**
 * Created by wyh on 2023/3/23
 */
public interface UserService {

    ResultEntity getVerifyResult(String name, String password);

    ResultEntity saveUser(String name, String password);

}
