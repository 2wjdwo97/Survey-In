package com.survey_in.dto;

import com.survey_in.entity.Survey;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SurveyDto {
    private String title;
    private int capacity;
    private int point;
    private Timestamp createdAt;
    private int participant;
    private List<QuestionDto> questions = new ArrayList<>();
    private String genderLimit;
    private String ageLimit;

    public SurveyDto(){

    }

    public SurveyDto(String title, List<QuestionDto> questions, String genderLimit, String ageLimit){
        this.title = title;
        this.questions = questions;
        this.genderLimit = genderLimit;
        this.ageLimit = ageLimit;
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

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public static SurveyDto of(Survey survey, List<QuestionDto> questions, String genderLimit, String ageLimit){
        return new SurveyDto(survey.getTitle(), questions, genderLimit, ageLimit);
    }

    public String getGenderLimit() {
        return genderLimit;
    }

    public void setGenderLimit(String genderLimit) {
        this.genderLimit = genderLimit;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }
}
