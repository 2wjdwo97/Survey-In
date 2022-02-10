package com.survey_in.dao.mapper;

import com.survey_in.dto.QuestionDto;
import com.survey_in.entity.Question;
import com.survey_in.entity.QuestionOption;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public QuestionDto select(int questionId){return sqlSession.selectOne("QuestionMapper.select", questionId);}

}
