package com.phs.controller;


import com.phs.entity.*;
import com.phs.service.facade.DiseaseService;
import com.phs.service.facade.QuizService;
import com.phs.service.facade.UserService;
import com.phs.service.facade.WorkService;
import com.phs.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wyh on 2023/3/23
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private WorkService workService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(String userName, String password){
        return userService.getVerifyResult(userName,password);
    }

    @RequestMapping(value = "/signup", method =  RequestMethod.POST)
    public ResponseEntity signup(String userName, String password){
        return userService.saveUser(userName, password);
    }

    @RequestMapping(value = "/disease/all", method = RequestMethod.POST)
    public Map<String,List<DiseaseEntity>> getAllDisease(){
        return diseaseService.getAllDisease();
    }

    @RequestMapping(value = "/disease/detail", method = RequestMethod.POST)
    public DiseaseFrontEntity getDisease(Integer diseaseId){
        return diseaseService.getDisease(diseaseId);
    }

    @RequestMapping(value = "/quiz/detail", method = RequestMethod.POST)
    public List<QuizEntity> getQuiz(Integer diseaseId){
        return quizService.getRandomQuiz(diseaseId);
    }

    @RequestMapping(value = "/work/detail", method = RequestMethod.POST)
    public List<WorkEntity> getWork(Integer jobId){
        return workService.getWorksByJobId(jobId);
    }









}
