package com.survey_in.entity;

import com.survey_in.dto.AnswerDto;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private int question_option_id;
    private int member_id;
    private Time createdAt;

    public int getQuestion_option_id() {
        return question_option_id;
    }

    public void setQuestion_option_id(int question_option_id) {
        this.question_option_id = question_option_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    public Answer(){

    }

    public Answer(int question_option_id, int member_id){
        this.question_option_id = question_option_id;
        this.member_id = member_id;
    }

    public Answer(int question_option_id, int member_id, Time createdAt) {
        this.question_option_id = question_option_id;
        this.member_id = member_id;
        this.createdAt = createdAt;
    }

    public static Answer of(AnswerDto answerDto, int member_id){
        return new Answer(answerDto.getQuestionOptionId(), member_id);
    }
}
