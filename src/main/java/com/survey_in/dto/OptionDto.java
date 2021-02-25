package com.survey_in.dto;

import com.survey_in.entity.Answer;
import com.survey_in.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class OptionDto {
    private String data;
    private List<AnswerDto> answers;

    public OptionDto(){

    }

    public OptionDto(String data){
        this.data = data;
        answers = null;
    }

    public OptionDto(String data, List<AnswerDto> answers){
        this.data = data;
        this.answers = answers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }

    public static OptionDto of(Option option, List<AnswerDto> answers){
        return new OptionDto(option.getData(), answers);
    }
}
