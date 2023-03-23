package com.phs.entity;

import java.util.List;

/**
 * Created by wyh on 2023/3/22
 */
public class DiseaseFrontEntity extends DiseaseEntity {

    public DiseaseFrontEntity(DiseaseEntity diseaseEntity){
        this.setId(diseaseEntity.getId());
        this.setKind_id(diseaseEntity.getKind_id());
        this.setName(diseaseEntity.getName());
        this.setDescription(diseaseEntity.getDescription());
        this.setImage(diseaseEntity.getImage());
    }

    private List<CaseEntity> caseList;

    public List<CaseEntity> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<CaseEntity> caseList) {
        this.caseList = caseList;
    }


}
