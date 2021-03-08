package com.survey_in.service;


import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.entity.Survey;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


@Service("serviceBeanExplore")
public class ExploreServiceImp implements ExploreService{

    private SurveyDao surveyDao;
    public ExploreServiceImp(@Qualifier("surveyDaoBean") SurveyDao surveyDao){
        this.surveyDao = surveyDao;
    }

    @Override
    public List<Survey> getAllSurveys() throws ClassNotFoundException, SQLException {
        return surveyDao.getAllSurveys();
    }

    public List<Survey> getTrendingSurvey() throws ClassNotFoundException, SQLException{
//        List<Survey> temp = surveyDao.get
        return surveyDao.getAllSurveys();
    }

    @Override
    public List<Survey> getSurveyByFilter() throws ClassNotFoundException, SQLException {
        return null;
    }
}
