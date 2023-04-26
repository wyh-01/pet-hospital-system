package com.phs.controller;

import com.phs.entity.*;
import com.phs.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    DiseaseMapper diseaseMapper;

    @Autowired
    CaseMapper caseMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    WorkMapper workMapper;

    @Autowired
    QuizMapper quizMapper;


    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @RequestMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap, HttpServletRequest request){
        String userName = request.getSession().getAttribute("userName").toString();
        UserEntity userEntity = userMapper.getUserByUserName(userName);
        modelMap.put("user", userEntity);
        return "index";
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(){
        return "file";
    }

    @RequestMapping("/uploadMultiFile")
    public String uploadMultiFile(){
        return "multiFile";
    }

    @RequestMapping("/manegeSystem")
    public String manegeSystem(){
        return "systemManage/manageSystem";
    }

    @RequestMapping("/diseaseManage")
    public String diseaseManage(){
        return "systemManage/diseaseManage/diseaseManage";
    }

    @RequestMapping("/addDisease")
    public String addDisease(ModelMap modelMap){
        List<DiseaseKindEntity> diseaseKinds = diseaseMapper.getAllDiseaseKind();
        modelMap.put("diseaseKinds", diseaseKinds);
        return "systemManage/diseaseManage/addDisease";
    }

    @RequestMapping("/updateDisease/{id}")
    public String updateDisease(@PathVariable("id") int id, ModelMap modelMap){
        List<DiseaseKindEntity> diseaseKinds = diseaseMapper.getAllDiseaseKind();
        DiseaseEntity diseaseEntity = diseaseMapper.getDiseaseById(id);

        for(int i = 0; i < diseaseKinds.size(); i++){
            if(diseaseKinds.get(i).getId() == diseaseEntity.getKindId()){
                diseaseKinds.get(i).setFlag(true);
                break;
            }
        }
        String[] imgUrls = diseaseEntity.getImage().split("&&");
        modelMap.put("diseaseKinds", diseaseKinds);
        modelMap.put("disease", diseaseEntity);
        modelMap.put("imgUrls", imgUrls);
        return "systemManage/diseaseManage/updateDisease";
    }

    @RequestMapping("/workChoose")
    public String workChoose(){
        return "systemManage/workManage/roleChoose";
    }

    @RequestMapping("/workManage/doctor")
    public String doctorManage(){
        return "systemManage/workManage/doctor";
    }

    @RequestMapping("/workManage/assistant")
    public String assistantManage(){
        return "systemManage/workManage/assistant";
    }

    @RequestMapping("/workManage/receptionist")
    public String receptionistManage(){
        return "systemManage/workManage/receptionist";
    }


    @RequestMapping("/addWork")
    public String addWork(ModelMap modelMap){
        List<JobEntity> jobs = new ArrayList<JobEntity>();
        jobs.add(new JobEntity(1, "医师"));
        jobs.add(new JobEntity(2, "助理"));
        jobs.add(new JobEntity(3, "前台"));
        modelMap.put("jobs", jobs);
        return "systemManage/workManage/addWork";
    }

    @RequestMapping("/updateWork/{id}")
    public String updateWork(@PathVariable("id") int id,ModelMap modelMap){
        WorkEntity workEntity = workMapper.getWorkById(id);
        List<JobEntity> jobs = new ArrayList<JobEntity>();
        jobs.add(new JobEntity(1, "医师"));
        jobs.add(new JobEntity(2, "助理"));
        jobs.add(new JobEntity(3, "前台"));
        for(JobEntity jobEntity : jobs){
            if(jobEntity.getId() == workEntity.getJob_id()){
                jobEntity.setFlag(true);
                break;
            }
        }
        modelMap.put("jobs", jobs);
        modelMap.put("work", workEntity);
        return "systemManage/workManage/updateWork";
    }



    @RequestMapping("/caseManage/{id}")
    public String caseManage(){
        return "systemManage/caseManage/caseManage";
    }

    @RequestMapping("/caseManageChoose")
    public String caseManageChoose(){
        return "systemManage/caseManage/caseManageChoose";
    }

    @RequestMapping("/addCase")
    public String addCase(ModelMap modelMap){
        List<DiseaseEntity> diseases = diseaseMapper.getAllDisease();
        modelMap.put("diseases", diseases);
        return "systemManage/caseManage/addCase";
    }

    @RequestMapping("/updateCase/{id}")
    public String updateCase(@PathVariable("id") int id, ModelMap modelMap){
        List<DiseaseEntity> diseases = diseaseMapper.getAllDisease();
        CaseEntity caseEntity = caseMapper.getCaseByCaseId(id);
        DiseaseEntity disease = diseaseMapper.getDiseaseById(caseEntity.getDisease_id());
        for(DiseaseEntity d : diseases){
            if(d.getId() == disease.getId()){
                d.setFlag(true);
                break;
            }
        }
        String[] imgUrls = caseEntity.getImage_list().split("&&");
        modelMap.put("diseases", diseases);
        modelMap.put("case", caseEntity);
        modelMap.put("imgUrls", imgUrls);
        return "systemManage/caseManage/updateCase";
    }


    @RequestMapping("/rolePlay")
    public String rolePlay(){
        return "rolePlay/roleChoose";
    }

    @RequestMapping("/rolePlay/assistant")
    public String assistant(){
        return "rolePlay/assistant";
    }

    @RequestMapping("/rolePlay/doctor")
    public String doctor(){
        return "rolePlay/doctor";
    }

    @RequestMapping("/rolePlay/receptionist")
    public String receptionist(){
        return "rolePlay/receptionist";
    }

    @RequestMapping("/navigation/")
    public String navigation(){
        return "navigation/allNavigation";
    }

    @RequestMapping("/caseStudy")
    public String caseChoose(){
        return "caseStudy/caseChoose";
    }

    @RequestMapping("/caseStudy/diseaseStudy/{id}")
    public String diseaseStudy(){
        return "caseStudy/diseaseStudy";
    }

    @RequestMapping("/quizChoose")
    public String quizChoose(){
        return  "quiz/quizChoose";
    }

    @RequestMapping("/quiz/{diseaseId}")
    public String quizTest(){
        return  "quiz/quizTest";
    }

    @RequestMapping("/manage/quizChoose")
    public String quizManageChoose(){
        return  "systemManage/quizManage/quizChoose";
    }

    @RequestMapping("/quizManage/{diseaseId}")
    public String quizManage(){
        return  "systemManage/quizManage/quizManage";
    }

    @RequestMapping("/addQuiz")
    public String addQuiz(ModelMap modelMap){
        List<DiseaseEntity> diseases = diseaseMapper.getAllDisease();
        modelMap.put("diseases", diseases);
        return "systemManage/quizManage/addQuiz";
    }

    @RequestMapping("/updateQuiz/{id}")
    public String updateQuiz(@PathVariable("id") int id,ModelMap modelMap){
        List<DiseaseEntity> diseases = diseaseMapper.getAllDisease();
        QuizEntity quizEntity = quizMapper.getQuizById(id);
        DiseaseEntity disease = diseaseMapper.getDiseaseById(quizEntity.getDisease_id());
        for(DiseaseEntity d : diseases){
            if(d.getId() == disease.getId()){
                d.setFlag(true);
                break;
            }
        }
        quizEntity.setChoiceList(Arrays.asList(quizEntity.getChoice_list().split("&&")));
        modelMap.put("diseases", disease);
        modelMap.put("quiz", quizEntity);
        return "systemManage/quizManage/updateQuiz";
    }


}
