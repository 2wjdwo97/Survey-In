package com.survey_in.service;

import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("surveyServiceBean")
public class SurveyServiceImpl implements SurveyService{

    private SurveyDao surveyDao;

    @Autowired
    public SurveyServiceImpl(@Qualifier("surveyDaoBean") SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }


    @Override
    public void createSurvey(Question questions, int memberNum) {

    }

    @Override
    public int getCntSurvey() {
        return surveyDao.getCntSurvey();
    }
}
