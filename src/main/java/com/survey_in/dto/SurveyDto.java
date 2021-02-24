package com.survey_in.dto;

import com.survey_in.entity.Option;
import com.survey_in.entity.Question;
import com.survey_in.entity.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyDto {
    private String title;
    private List<QuestionDto> questions = new ArrayList<QuestionDto>();

    public SurveyDto(){

    }

    public SurveyDto(String title, List<QuestionDto> questions){
        this.title = title;
        this.questions = questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
    public List<QuestionDto> getQuestions () {
        return questions;
    }

    public static SurveyDto of(Survey survey, List<QuestionDto> questions){
        return new SurveyDto(survey.getTitle(), questions);
    }
}
