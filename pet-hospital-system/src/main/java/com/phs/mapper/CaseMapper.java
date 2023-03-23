package com.phs.mapper;

import java.util.List;
import com.phs.entity.CaseEntity;

public interface CaseMapper {

    List<CaseEntity> getCaseByDiseaseId(int diseaseId);

}
