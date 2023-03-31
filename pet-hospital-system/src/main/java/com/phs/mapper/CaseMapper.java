package com.phs.mapper;

import java.util.List;
import com.phs.entity.CaseEntity;

public interface CaseMapper {

    List<CaseEntity> getCaseByDiseaseId(int diseaseId);

    void addCase(CaseEntity caseEntity);

    void deleteCase(int case_id);

    void updateCase(CaseEntity caseEntity);
}
