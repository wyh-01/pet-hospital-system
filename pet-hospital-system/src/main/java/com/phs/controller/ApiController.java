package com.phs.controller;


import com.phs.entity.*;
import com.phs.service.facade.*;
import com.phs.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private CaseManageService caseManageService;

    @Autowired
    private FileUploadService fileUploadService;

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

    @RequestMapping(value = "/disease/add", method = RequestMethod.POST)
    public ResponseEntity addDisease(DiseaseEntity diseaseEntity, @RequestParam("files") MultipartFile[] files){
        StringBuffer urls = new StringBuffer("");
        if(!isEmpty(files)) {
            int count = 0;
            for (MultipartFile file : files) {
                if(count > 0){
                    urls.append("#");
                }
                urls.append(fileUploadService.upload(file));
                count++;
            }
        }else{
            return new ResponseEntity("上传失败，因为文件是空的.", HttpStatus.BAD_REQUEST);
        }
        diseaseEntity.setImage(urls.toString());
        return diseaseService.addDisease(diseaseEntity);
    }

    @RequestMapping(value = "/disease/delete", method = RequestMethod.POST)
    public ResponseEntity deleteDisease(int id){
        return diseaseService.deleteDisease(id);
    }

    @RequestMapping(value = "/disease/update", method = RequestMethod.POST)
    public ResponseEntity updateDisease(DiseaseEntity diseaseEntity){
        return diseaseService.updateDisease(diseaseEntity);
    }

    @RequestMapping(value = "/quiz/detail", method = RequestMethod.POST)
    public List<QuizEntity> getQuiz(Integer diseaseId){
        return quizService.getRandomQuiz(diseaseId);
    }

    @RequestMapping(value = "/work/detail", method = RequestMethod.POST)
    public List<WorkEntity> getWork(Integer jobId){
        return workService.getWorksByJobId(jobId);
    }

    @RequestMapping(value = "/caseManage/caseAdd", method = RequestMethod.POST)
    public ResponseEntity caseAdd(CaseEntity caseEntity){
        return caseManageService.caseAdd(caseEntity);
    }

    @RequestMapping(value = "/caseManage/caseDelete", method = RequestMethod.POST)
    public ResponseEntity caseDelete(Integer case_id){
        return caseManageService.caseDelete(case_id);
    }

    @RequestMapping(value = "/caseManage/caseUpdate", method = RequestMethod.POST)
    public ResponseEntity caseUpdate(CaseEntity caseEntity){
        return caseManageService.caseUpdate(caseEntity);
    }


    private boolean isEmpty(MultipartFile files[]){
        if(files.length == 1 && files[0].isEmpty()){
            return true;
        }
        return  false;
    }




}
