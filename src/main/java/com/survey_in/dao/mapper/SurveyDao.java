package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;

import java.util.List;

public interface SurveyDao {
    List<Survey> searchSurvey(String keyword, String category, String age);
}
