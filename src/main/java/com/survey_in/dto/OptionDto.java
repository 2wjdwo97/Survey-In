package com.survey_in.dto;

import java.util.List;

public class OptionDto {
    private String data;
    private List<AnswerDto> answer;

    public OptionDto(String data){
        this.data = data;
        answer = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<AnswerDto> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerDto> answer) {
        this.answer = answer;
    }
}
