package com.survey_in.service;

import com.survey_in.entity.Question;

public interface SurveyService {
    void createSurvey(String memberID, String title, int capacity, String category, int point);
}
