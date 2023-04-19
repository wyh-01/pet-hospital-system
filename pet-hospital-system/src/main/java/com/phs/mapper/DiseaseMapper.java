package com.phs.mapper;

import java.util.List;
import com.phs.entity.DiseaseEntity;
import com.phs.entity.DiseaseKindEntity;
import org.springframework.http.ResponseEntity;


public interface DiseaseMapper {

    List<DiseaseEntity> getDiseaseByKindId(int kind_id);

    DiseaseEntity getDiseaseById(int id);

    void insertDisease(DiseaseEntity diseaseEntity);

    void deleteDisease(int id);

    void updateDisease(DiseaseEntity diseaseEntity);

    List<String> getAllDiseaseName();

    List<DiseaseKindEntity> getAllDiseaseKind();

    List<DiseaseEntity> getAllDisease();
}
