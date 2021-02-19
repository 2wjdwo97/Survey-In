package com.survey_in.entity;

public class Question {
    private int id;
    private int survey_id;
    private String title;

    public Question(int id, int survey_id, String title){
        this.id = id;
        this.survey_id = survey_id;
        this.title = title;
    }

    public Question(int survey_id, String title){
        this.survey_id = survey_id;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
