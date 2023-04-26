package com.phs.service.impl;

import com.phs.entity.QuizEntity;
import com.phs.mapper.QuizMapper;
import com.phs.service.facade.QuizService;
import com.phs.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public List<QuizEntity> getAllQuiz(int diseaseId){
        List<QuizEntity> quizEntities = quizMapper.getQuizByDiseaseId(diseaseId);
        for(QuizEntity quizEntity : quizEntities){
            quizEntity.setChoiceList(Arrays.asList(quizEntity.getChoice_list().split("&&")));
        }
        return quizEntities;
    }

    @Override
    public ResponseEntity addQuiz(QuizEntity quizEntity){
        if(isNotBlank(quizEntity.getQuestion())){
            if(isNotBlank(quizEntity.getAnswer())){
                if(quizEntity.getChoiceList().size() == 4){
                    int count = 0;
                    StringBuffer choice_list = new StringBuffer();
                    for(String choice : quizEntity.getChoiceList()){
                        if(count > 0){
                            choice_list.append("&&");
                        }
                        choice_list.append(choice);
                        count++;
                    }
                    quizEntity.setChoice_list(choice_list.toString());
                    quizMapper.insertQuiz(quizEntity);
                    return new ResponseEntity<>("试题添加成功", HttpStatus.OK);
                }else{
                    return new ResponseEntity("选项不满4个，请重新输入", HttpStatus.BAD_REQUEST);
                }
            }else{
                return new ResponseEntity("答案不能为空，请重新输入", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity("试题不能为空，请重新输入", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteQuiz(int id){
        quizMapper.deleteQuiz(id);
        return new ResponseEntity<>("试题删除成功", HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateQuiz(QuizEntity quizEntity){
        if(isNotBlank(quizEntity.getQuestion())){
            if(isNotBlank(quizEntity.getAnswer())){
                if(quizEntity.getChoiceList().size() == 4){
                    int count = 0;
                    StringBuffer choice_list = new StringBuffer();
                    for(String choice : quizEntity.getChoiceList()){
                        if(count > 0){
                            choice_list.append("&&");
                        }
                        choice_list.append(choice);
                        count++;
                    }
                    quizEntity.setChoice_list(choice_list.toString());
                    quizMapper.updateQuiz(quizEntity);
                    return new ResponseEntity<>("试题更新成功", HttpStatus.OK);
                }else{
                    return new ResponseEntity("选项不满4个，请重新输入", HttpStatus.BAD_REQUEST);
                }
            }else{
                return new ResponseEntity("答案不能为空，请重新输入", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity("试题不能为空，请重新输入", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isNotBlank(String s){
        if(null != s && s.length() > 0){ return true; }
        return false;
    }




}
