package com.phs.mapper;

import com.phs.entity.WorkEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface WorkMapper {

    List<WorkEntity> getWorkByJobId(int jobId);

    WorkEntity getWorkById(int id);

    void insertWork(WorkEntity workEntity);

    void deleteWork(int id);

    void updateWork(WorkEntity workEntity);

}
