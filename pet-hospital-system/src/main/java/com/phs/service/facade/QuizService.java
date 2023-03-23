package com.phs.service.facade;

import com.phs.entity.QuizEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface QuizService {

    List<QuizEntity> getRandomQuiz(int diseaseId);

}
