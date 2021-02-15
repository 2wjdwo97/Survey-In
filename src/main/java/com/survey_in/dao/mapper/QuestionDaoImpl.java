package com.survey_in.dao.mapper;

import com.survey_in.entity.Question;
import com.survey_in.entity.QuestionOption;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("questionDaoBean")
public class QuestionDaoImpl implements QuestionDao{
    private final SqlSession sqlSession;

    @Autowired
    public QuestionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public void insertQuestion(Question question) {
        sqlSession.insert("QuestionMapper.insert", question);
    }
}
