package com.phs.controller;

import com.phs.entity.DiseaseEntity;
import com.phs.entity.DiseaseKindEntity;
import com.phs.mapper.DiseaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    DiseaseMapper diseaseMapper;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @RequestMapping("/index")
    public String index(){
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

    @RequestMapping("/diseaseChoose")
    public String diseaseChoose(){
        return "systemManage/diseaseManage/diseaseChoose";
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
        modelMap.put("diseaseKinds", diseaseKinds);
        modelMap.put("disease", diseaseEntity);
        return "systemManage/diseaseManage/updateDisease";
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

}
