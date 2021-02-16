package com.survey_in.dto;

import java.util.ArrayList;
import java.util.List;

public class NewSurveyDto {
    private String title;
    private List<OptionDto> option = new ArrayList<OptionDto>();
    private List<NewSurveyDto> list;

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }

    public void setOption(String option) {
        this.option.add(new OptionDto(option));
    }
    public List<OptionDto> getOption () {
        return this.option;
    }

    public void setList(List<NewSurveyDto> list) {
        this.list = list;
    }
    public List<NewSurveyDto> getList() {
        return this.list;
    }
}
