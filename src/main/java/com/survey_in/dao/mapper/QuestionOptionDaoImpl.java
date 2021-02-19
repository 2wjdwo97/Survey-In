package com.survey_in.dao.mapper;

import com.survey_in.entity.QuestionOption;
import com.survey_in.entity.Survey;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("questionOptionDaoBean")
public class QuestionOptionDaoImpl implements QuestionOptionDao{
    private final SqlSession sqlSession;

    @Autowired
    public QuestionOptionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public void insertQuestionOption(QuestionOption questionOption) {
        sqlSession.insert("QuestionOptionMapper.insert", questionOption);
    }
}
