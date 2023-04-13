package com.phs.service.facade;

import java.util.List;
import java.util.Map;

import com.phs.entity.DiseaseEntity;
import com.phs.entity.DiseaseFrontEntity;
import org.springframework.http.ResponseEntity;

public interface DiseaseService {

    Map<String,List<DiseaseEntity>> getAllDisease();

    DiseaseFrontEntity getDisease(int diseaseId);

    ResponseEntity addDisease(DiseaseEntity diseaseEntity);

    ResponseEntity deleteDisease(int id);

    ResponseEntity updateDisease(DiseaseEntity diseaseEntity);
}
