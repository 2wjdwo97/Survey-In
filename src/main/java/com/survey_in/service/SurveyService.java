package com.survey_in.service;

import com.survey_in.entity.Survey;
import com.survey_in.entity.NewSurveyEntity;

import java.util.List;

public interface SurveyService {
    int getCntSurvey();
    void createSurvey(String username, String title, int capacity, String category, int point, List<NewSurveyEntity> questions);
    List<Survey> getMemberSurveys(String username);
}
