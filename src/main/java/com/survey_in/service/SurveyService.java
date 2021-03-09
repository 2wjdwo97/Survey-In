package com.survey_in.service;

import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import com.survey_in.dto.QuestionDto;

import java.util.List;

public interface SurveyService {

    void createSurvey(String username, String title, int capacity, String category, int point,
                       String gender_limit, String age_limit, List<QuestionDto> questions);
    void deleteSurvey(int id);

    List<Survey> getMemberSurveys(String username);
    SurveyDto getSurveyDetail(int id);
}
