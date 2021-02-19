package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("surveyDaoBean")
public class SurveyDaoImpl implements SurveyDao{

    private final SqlSession sqlSession;

    @Autowired
    public SurveyDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Survey> getAllSurvey() {
        System.out.println(sqlSession.selectList("SurveyMapper.getAllSurvey").getClass());
        return sqlSession.selectList("SurveyMapper.getAllSurvey");
    }

    @Override
    public void createSurvey(Survey survey) {

    }

    @Override
    public Survey selectSurvey(String survey_id) {
        return null;
    }

    @Override
    public void deleteSurvey(String survey_id) {

    }
}
