package com.survey_in.dto;

import com.survey_in.entity.Option;
import com.survey_in.entity.Question;
import com.survey_in.entity.Survey;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    private int id;
    private String title;
    private List<OptionDto> option = new ArrayList<OptionDto>();

    public QuestionDto(){
    }
    public QuestionDto(String title, List<OptionDto> option){
        this.title = title;
        this.option = option;
    }
    public QuestionDto(String title, List<OptionDto> option, int id){
        this.title = title;
        this.option = option;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }

    public void setOption(List<String> option) {
        for(String op : option) {
            this.option.add(new OptionDto(op));
        }
    }

    public List<OptionDto> getOption () {
        return this.option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static QuestionDto of(Question question, List<OptionDto> optionDtos){
        return new QuestionDto(question.getTitle(), optionDtos);
    }
}
