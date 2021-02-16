package com.survey_in.dto;

import com.survey_in.entity.Option;

import java.util.ArrayList;
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

    public static OptionDto of(Option option){
        return new OptionDto(option.getData());
    }

    public static List<OptionDto> of(List<Option> options){
        List<OptionDto> list = new ArrayList<OptionDto>();
        for(Option option : options) {
            list.add(OptionDto.of(option));
        }
        return list;
    }
}
