package com.phs.service.impl;

import com.phs.entity.QuizEntity;
import com.phs.mapper.QuizMapper;
import com.phs.service.facade.QuizService;
import com.phs.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
@Service
public class QuizImpl implements QuizService {

    @Autowired
    private QuizMapper quizMapper;

    @Override
    public List<QuizEntity> getRandomQuiz(int diseaseId){
        List<QuizEntity> quizEntities = quizMapper.getQuizByDiseaseId(diseaseId);
        quizEntities = ListUtils.createRandomList(quizEntities,10);
        List<QuizEntity> quizList = new ArrayList<>();
        for (QuizEntity quizEntity:quizEntities) {
            quizEntity.setChoiceList(Arrays.asList(quizEntity.getChoice_list().split("&&")));
            quizList.add(quizEntity);
        }
        return quizList;
    }



}
