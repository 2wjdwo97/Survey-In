package com.survey_in.dao.mapper;

import com.survey_in.entity.Answer;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("answerDaoBean")
public class AnswerDaoImpl implements AnswerDao{
    private final SqlSession sqlsession;

    @Autowired
    public AnswerDaoImpl(SqlSession sqlsession) {
        this.sqlsession = sqlsession;
    }

    public List<Answer> selectAnswers(int option_id) {
        return sqlsession.selectList("AnswerMapper.selectAnswers", option_id);
    }

    public void createAnswer(Answer answer){
        sqlsession.insert("AnswerMapper.createAnswer", answer);
    }
}
