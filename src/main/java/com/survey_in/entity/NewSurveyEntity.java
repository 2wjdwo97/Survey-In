package com.survey_in.entity;

import java.util.ArrayList;
import java.util.List;

public class NewSurveyEntity {
    private String title;
    private List<String> option = new ArrayList<String>();
    private List<NewSurveyEntity> list;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setOption(String option) {
        this.option.add(option);
    }

    public List<String> getOption () {
        return this.option;
    }

    public void setList(List<NewSurveyEntity> list) {
        this.list = list;
    }

    public List<NewSurveyEntity> getList() {
        return this.list;
    }
}
