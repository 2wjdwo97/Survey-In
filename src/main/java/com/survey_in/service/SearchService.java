package com.survey_in.service;

import com.survey_in.entity.Question;
import com.survey_in.entity.Survey;

import java.util.List;

public interface SearchService {
    List<Survey> searchSurveys();
    List<Question> searchQuestions();
}
