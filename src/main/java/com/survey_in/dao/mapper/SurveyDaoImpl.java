package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;
import com.survey_in.entity.Survey;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("surveyDaoBean")
public class SurveyDaoImpl implements SurveyDao{
    private final SqlSession sqlSession;

    @Autowired
    public SurveyDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertSurvey(Survey survey) {
        sqlSession.insert("SurveyMapper.insertSurvey", survey);
    }
}
