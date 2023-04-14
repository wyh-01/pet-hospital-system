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

    private boolean isNotBlank(String s){
        if(null!=s&&s.length()>0)
            return true;
        return false;
    }

    @Override
    public ResponseEntity caseAdd(CaseEntity caseEntity){
//        数据校验
        if(isNotBlank(caseEntity.getName())){
            if(caseEntity.getDisease_id()==0){
                return new ResponseEntity("缺少病种分类", HttpStatus.BAD_REQUEST);
            }
            else
                caseMapper.addCase(caseEntity);
            return  new ResponseEntity("成功", HttpStatus.OK);
        }
        return new ResponseEntity("病例名不能为空", HttpStatus.BAD_REQUEST);

//      前端需要在caseEntity里返回图片和视频存储在云端的url
//      Image_list用&&分割不同img的url
    }

    @Override
    public ResponseEntity caseDelete(int case_id){
        if(case_id==0)
            return new ResponseEntity("缺少case_id", HttpStatus.BAD_REQUEST);
        else
            caseMapper.deleteCase(case_id);
        return  new ResponseEntity("成功", HttpStatus.OK);
    }

    @Override
    public ResponseEntity caseUpdate(CaseEntity caseEntity){
        if(caseEntity.getId()==0)
            return new ResponseEntity("缺少case_id", HttpStatus.BAD_REQUEST);
        if(!isNotBlank(caseEntity.getName())){
            return new ResponseEntity("病例名不能为空", HttpStatus.BAD_REQUEST);
        }
        if(caseEntity.getDisease_id()==0){
            return new ResponseEntity("缺少病种分类", HttpStatus.BAD_REQUEST);
        }
        else caseMapper.updateCase(caseEntity);
        return  new ResponseEntity("成功", HttpStatus.OK);
    }

}