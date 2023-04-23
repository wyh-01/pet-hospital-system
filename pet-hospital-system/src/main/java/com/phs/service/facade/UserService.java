package com.phs.service.facade;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wyh on 2023/3/23
 */
public interface UserService {

    ResponseEntity getVerifyResult(String name, String password, HttpServletRequest request);

    ResponseEntity saveUser(String name, String password);

}
