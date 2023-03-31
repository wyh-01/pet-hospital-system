package com.phs.service.facade;

import com.phs.entity.CaseEntity;
import org.springframework.http.ResponseEntity;

public interface CaseManageService
{

    ResponseEntity caseAdd(CaseEntity caseEntity);
//
//    ResponseEntity caseDeleteByName(String case_name);
//
//    ResponseEntity caseChange(CaseEntity caseEntity);
}
