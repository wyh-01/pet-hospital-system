package com.phs.service.facade;

import org.springframework.http.ResponseEntity;

/**
 * Created by wyh on 2023/3/23
 */
public interface UserService {

    ResponseEntity getVerifyResult(String name, String password);

    ResponseEntity saveUser(String name, String password);

}
