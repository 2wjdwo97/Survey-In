package com.survey_in.service;

import com.survey_in.entity.Question;

public interface SurveyService {
    void createSurvey(Question questions, int memberNum);
}
