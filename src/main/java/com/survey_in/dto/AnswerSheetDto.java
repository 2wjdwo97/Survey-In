package com.survey_in.dto;

import java.util.List;

public class AnswerSheetDto {
    private List<AnswerDto> answers;

    public AnswerSheetDto(){}

    public AnswerSheetDto(List<AnswerDto> answers) {
        this.answers = answers;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
