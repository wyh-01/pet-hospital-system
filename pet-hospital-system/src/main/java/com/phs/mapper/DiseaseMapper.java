package com.phs.mapper;

import java.util.List;
import com.phs.entity.DiseaseEntity;


public interface DiseaseMapper {

    List<DiseaseEntity> getDiseaseByKindId(int kind_id);

    DiseaseEntity getDiseaseById(int id);

}
