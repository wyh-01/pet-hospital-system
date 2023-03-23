package com.phs.service.facade;

import java.util.List;
import java.util.Map;

import com.phs.entity.DiseaseEntity;
import com.phs.entity.DiseaseFrontEntity;

public interface DiseaseService {

    Map<String,List<DiseaseEntity>> getAllDisease();

    DiseaseFrontEntity getDisease(int diseaseId);

}
