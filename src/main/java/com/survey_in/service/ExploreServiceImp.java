package com.survey_in.service;


import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


@Service("exploreServiceBean")
public class ExploreServiceImp implements ExploreService{

    private SurveyDao surveyDao;
    public ExploreServiceImp(@Qualifier("surveyDaoBean") SurveyDao surveyDao){
        this.surveyDao = surveyDao;
    }

    @Override
    public List<Survey> getAllSurveys() throws ClassNotFoundException, SQLException {
        return surveyDao.getAllSurveys();
    }

    @Override
    public List<Survey> getSurveyByFilter() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public List<SurveyDto> getRecentSurveys(int num) throws ClassNotFoundException, SQLException {
        return surveyDao.getSurveyByDate(num);
    }

    @Override
    public List<Survey> getTrendingSurvey(int num) throws ClassNotFoundException, SQLException {
        return surveyDao.getAllSurveys();
    }

    @Override
    public List<SurveyDto> getValuableSurvey(int num) throws ClassNotFoundException, SQLException {
        return surveyDao.getSurveyByPoints(num);
    }


}
