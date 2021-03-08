package com.survey_in.dto;

import com.survey_in.entity.Survey;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SurveyDto {
    private String title;
    private int capacity;
    private int point;
    Timestamp createdAt;
    private List<QuestionDto> questions = new ArrayList<>();

    public SurveyDto(){

    }

    public SurveyDto(String title, List<QuestionDto> questions){
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public static SurveyDto of(Survey survey, List<QuestionDto> questions){
        return new SurveyDto(survey.getTitle(), questions);
    }
}
