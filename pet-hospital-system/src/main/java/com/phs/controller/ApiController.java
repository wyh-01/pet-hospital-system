package com.phs.controller;


import com.phs.entity.*;
import com.phs.mapper.CaseMapper;
import com.phs.mapper.DiseaseMapper;
import com.phs.service.facade.*;
import com.phs.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private DiseaseMapper diseaseMapper;

    @Autowired
    private CaseMapper caseMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(String userName, String password, HttpServletRequest request){
        return userService.getVerifyResult(userName,password, request);
    }

    /**
     * 登出
     */
    @RequestMapping(value = "/logout")
    public ResponseEntity logout(HttpServletRequest request)
    {
        //销毁session对象
        request.getSession().invalidate();

        return new ResponseEntity("登出成功", HttpStatus.OK);
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
                    urls.append("&&");
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
    public ResponseEntity updateDisease(DiseaseEntity diseaseEntity, @RequestParam("imgs") MultipartFile[] imgs, @RequestParam("imgUrlArr") String[] imgUrlArr){
        StringBuffer imgUrls = new StringBuffer("");
        int imgCount = 0;
        for(String imgUrl : imgUrlArr){
            if(!"".equals(imgUrl)){
                if(imgCount > 0){
                    imgUrls.append("&&");
                }
                imgUrls.append(imgUrl);
                imgCount++;
            }
        }
        if(!isEmpty(imgs)) {
            for (MultipartFile img : imgs) {
                if(imgCount > 0){
                    imgUrls.append("&&");
                }
                imgUrls.append(fileUploadService.upload(img));
                imgCount++;
            }
        }else{
            return new ResponseEntity("上传失败，因为文件是空的.", HttpStatus.BAD_REQUEST);
        }
        diseaseEntity.setImage(imgUrls.toString());
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
    public ResponseEntity caseAdd(CaseEntity caseEntity, @RequestParam("imgs") MultipartFile[] imgs, @RequestParam("videos") MultipartFile[] videos){
        StringBuffer imgUrls = new StringBuffer("");
        StringBuffer videoUrls = new StringBuffer("");
        if(!isEmpty(imgs)) {
            int count = 0;
            for (MultipartFile img : imgs) {
                if(count > 0){
                    imgUrls.append("&&");
                }
                imgUrls.append(fileUploadService.upload(img));
                count++;
            }
        }else{
            return new ResponseEntity("上传失败，因为图片文件是空的.", HttpStatus.BAD_REQUEST);
        }
        if(!isEmpty(videos)) {
            int count = 0;
            for (MultipartFile video : videos) {
                if(count > 0){
                    imgUrls.append("&&");
                }
                videoUrls.append(fileUploadService.upload(video));
                count++;
            }
        }else{
            return new ResponseEntity("上传失败，因为视频文件是空的.", HttpStatus.BAD_REQUEST);
        }
        caseEntity.setImage_list(imgUrls.toString());
        caseEntity.setVideo(videoUrls.toString());
        return caseManageService.caseAdd(caseEntity);
    }

    @RequestMapping(value = "/caseManage/caseDelete", method = RequestMethod.POST)
    public ResponseEntity caseDelete(int id){
        return caseManageService.caseDelete(id);
    }

    @RequestMapping(value = "/caseManage/caseUpdate", method = RequestMethod.POST)
    public ResponseEntity caseUpdate(CaseEntity caseEntity, @RequestParam("imgs") MultipartFile[] imgs, @RequestParam("videos") MultipartFile[] videos,
                                     @RequestParam("imgUrlArr") String[] imgUrlArr, @RequestParam("videoUrlArr") String[] videoUrlArr){
        StringBuffer imgUrls = new StringBuffer("");
        StringBuffer videoUrls = new StringBuffer("");
        int imgCount = 0;
        for(String imgUrl : imgUrlArr){
            if(!"".equals(imgUrl)){
                if(imgCount > 0){
                    imgUrls.append("&&");
                }
                imgUrls.append(imgUrl);
                imgCount++;
            }
        }
        if(!isEmpty(imgs)) {
            for (MultipartFile img : imgs) {
                if(imgCount > 0){
                    imgUrls.append("&&");
                }
                imgUrls.append(fileUploadService.upload(img));
                imgCount++;
            }
        }else{
            return new ResponseEntity("上传失败，因为图片文件是空的.", HttpStatus.BAD_REQUEST);
        }
        int videoCount = 0;
        for(String  videoUrl : videoUrlArr) {
            if (!"".equals(videoUrl)) {
                if(videoCount > 0){
                    videoUrls.append("&&");
                }
                videoUrls.append(videoUrl);
                videoCount++;
            }
        }
        if(!isEmpty(videos)) {
            for (MultipartFile video : videos) {
                if(videoCount > 0){
                    imgUrls.append("&&");
                }
                videoUrls.append(fileUploadService.upload(video));
                videoCount++;
            }
        }else{
            return new ResponseEntity("上传失败，因为视频文件是空的.", HttpStatus.BAD_REQUEST);
        }
        caseEntity.setImage_list(imgUrls.toString());
        caseEntity.setVideo(videoUrls.toString());
        return caseManageService.caseUpdate(caseEntity);
    }


    private boolean isEmpty(MultipartFile files[]){
        if(files.length == 1 && files[0].isEmpty()){
            return true;
        }
        return  false;
    }




}
