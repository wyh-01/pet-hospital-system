package com.phs.mapper;

import com.phs.entity.WorkEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface WorkMapper {

    List<WorkEntity> getWorkByJobId(int jobId);

}
