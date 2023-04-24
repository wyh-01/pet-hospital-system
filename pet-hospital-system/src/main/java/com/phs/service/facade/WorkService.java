package com.phs.service.facade;

import com.phs.entity.WorkEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface WorkService {

    List<WorkEntity> getWorksByJobId(int jobId);

    ResponseEntity addWork(WorkEntity workEntity);

    ResponseEntity deleteWork(int id);

    ResponseEntity updateWork(WorkEntity workEntity);

}
