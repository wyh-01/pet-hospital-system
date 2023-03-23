package com.phs.service.impl;

import com.phs.entity.WorkEntity;
import com.phs.mapper.WorkMapper;
import com.phs.service.facade.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
@Service
public class WorkImpl implements WorkService{

    @Autowired
    private WorkMapper workMapper;

    @Override
    public List<WorkEntity> getWorksByJobId(int jobId){
        return workMapper.getWorkByJobId(jobId);
    }

}
