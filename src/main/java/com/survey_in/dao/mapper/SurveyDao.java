package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;

import java.util.HashMap;
import java.util.List;

public interface SurveyDao {
    List<Survey> getAllSurvey();
    void createSurvey(Survey survey);
    Survey selectSurvey(String survey_id);
    void deleteSurvey(String survey_id);
}
