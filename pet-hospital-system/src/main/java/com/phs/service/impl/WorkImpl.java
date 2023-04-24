package com.phs.service.impl;

import com.phs.entity.WorkEntity;
import com.phs.mapper.WorkMapper;
import com.phs.service.facade.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity addWork(WorkEntity workEntity){
        if(isNotBlank(workEntity.getName())){
            workMapper.insertWork(workEntity);
            return new ResponseEntity<>("工作流程添加成功", HttpStatus.OK);
        }else{
            return new ResponseEntity("工作流程名称不能为空，请重新输入", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteWork(int id){
        workMapper.deleteWork(id);
        return new ResponseEntity<>("工作流程删除成功", HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateWork(WorkEntity workEntity){
        if(isNotBlank(workEntity.getName())){
            workMapper.updateWork(workEntity);
            return new ResponseEntity<>("工作流程更新成功", HttpStatus.OK);
        }else{
            return new ResponseEntity("工作流程名称不能为空，请重新输入", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isNotBlank(String s){
        if(null != s && s.length() > 0){ return true; }
        return false;
    }

}
