package com.phs.mapper;

import com.phs.entity.QuizEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface QuizMapper {

    List<QuizEntity> getQuizByDiseaseId(int diseaseId);

    QuizEntity getQuizById(int id);

    void insertQuiz(QuizEntity quizEntity);

    void updateQuiz(QuizEntity quizEntity);

    void deleteQuiz(int id);

}
