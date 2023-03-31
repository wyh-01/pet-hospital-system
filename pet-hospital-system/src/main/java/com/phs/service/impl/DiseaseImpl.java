package com.phs.service.impl;

import com.phs.entity.CaseEntity;
import com.phs.entity.DiseaseEntity;
import com.phs.entity.DiseaseFrontEntity;
import com.phs.mapper.CaseMapper;
import com.phs.mapper.DiseaseMapper;
import com.phs.service.facade.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wyh on 2023/3/23
 */
@Service
public class DiseaseImpl implements DiseaseService {

    @Autowired
    private CaseMapper caseMapper;

    @Autowired
    private DiseaseMapper diseaseMapper;

    @Override
    public Map<String,List<DiseaseEntity>> getAllDisease(){
        List<DiseaseEntity> firstKind = diseaseMapper.getDiseaseByKindId(1);
        List<DiseaseEntity> secondKind = diseaseMapper.getDiseaseByKindId(2);
        List<DiseaseEntity> thirdKind = diseaseMapper.getDiseaseByKindId(3);
        List<DiseaseEntity> forthKind = diseaseMapper.getDiseaseByKindId(4);
        Map<String,List<DiseaseEntity>> kindMap = new HashMap<>();
        kindMap.put("one",firstKind);
        kindMap.put("two",secondKind);
        kindMap.put("three",thirdKind);
        kindMap.put("four",forthKind);
        return kindMap;
    }

    @Override
    public DiseaseFrontEntity getDisease(int diseaseId){
        DiseaseEntity diseaseEntity = diseaseMapper.getDiseaseById(diseaseId);
        DiseaseFrontEntity frontEntity = new DiseaseFrontEntity(diseaseEntity);
        List<CaseEntity> caseEntities = caseMapper.getCaseByDiseaseId(diseaseId);
        List<CaseEntity> caseList = new ArrayList<>();
        for (CaseEntity caseEntity:caseEntities) {
            caseEntity.setImageList(Arrays.asList(caseEntity.getImage_list().split("&&")));
            caseList.add(caseEntity);
        }
        frontEntity.setCaseList(caseList);
        return frontEntity;
    }

    @Override
    public ResponseEntity addDisease(DiseaseEntity diseaseEntity){
        diseaseMapper.insertDisease(diseaseEntity);
        return new ResponseEntity<>("病种添加成功", HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteDisease(int id){
        diseaseMapper.deleteDisease(id);
        return new ResponseEntity<>("病种删除成功", HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateDisease(DiseaseEntity diseaseEntity){
        diseaseMapper.updateDisease(diseaseEntity);
        return new ResponseEntity<>("病种更新成功", HttpStatus.OK);
    }

}
