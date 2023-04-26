package com.phs.service.facade;

import com.phs.entity.QuizEntity;
import com.phs.entity.WorkEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by wyh on 2023/3/23
 */
public interface QuizService {

    List<QuizEntity> getRandomQuiz(int diseaseId);

    List<QuizEntity> getAllQuiz(int diseaseId);

    ResponseEntity addQuiz(QuizEntity quizEntity);

    ResponseEntity deleteQuiz(int id);

    ResponseEntity updateQuiz(QuizEntity quizEntity);

}
