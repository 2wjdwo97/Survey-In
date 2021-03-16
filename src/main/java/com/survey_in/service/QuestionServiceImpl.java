package com.survey_in.service;

import com.survey_in.dao.mapper.QuestionDao;
import com.survey_in.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("questionServiceBean")
public class QuestionServiceImpl implements QuestionService {
    private QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(@Qualifier("questionDaoBean") QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    public QuestionDto getQuestionDetail(int questionId){
        return questionDao.select(questionId);
    }
}
