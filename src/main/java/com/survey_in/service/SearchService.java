package com.survey_in.service;

import com.survey_in.entity.Question;
import com.survey_in.entity.Survey;

import java.util.List;

public interface SearchService {
    List<Survey> searchSurvey(String keyword, String category, String age);
    List<Survey> searchQuestion();
}
