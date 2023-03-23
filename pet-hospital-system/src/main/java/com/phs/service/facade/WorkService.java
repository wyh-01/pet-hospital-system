package com.phs.service.facade;

import com.phs.entity.WorkEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface WorkService {

    List<WorkEntity> getWorksByJobId(int jobId);

}
