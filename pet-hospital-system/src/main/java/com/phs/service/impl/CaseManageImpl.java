package com.phs.service.impl;

import com.phs.entity.CaseEntity;
import com.phs.mapper.CaseMapper;
import com.phs.mapper.DiseaseMapper;
import com.phs.service.facade.CaseManageService;
import com.phs.service.facade.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CaseManageImpl implements CaseManageService {

    @Autowired
    private CaseMapper caseMapper;

    @Override
    public ResponseEntity caseAdd(CaseEntity caseEntity){
//        数据校验
        if(caseEntity.getName()==null){
            return new ResponseEntity("缺少名字", HttpStatus.NO_CONTENT);
        }
        if(caseEntity.getDisease_id()==0){
            return new ResponseEntity("缺少病种分类", HttpStatus.NO_CONTENT);
        }
        else
            caseMapper.addCase(caseEntity);
            return  new ResponseEntity("成功", HttpStatus.OK);
//      前端需要在caseEntity里返回图片和视频存储在云端的url
//      Image_list用&&分割不同img的url
    }

//
//    ResponseEntity CaseDeleteByName(String case_name);
//
//    ResponseEntity CaseUpdate(CaseEntity caseEntity);
}
