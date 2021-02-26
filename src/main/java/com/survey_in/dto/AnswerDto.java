package com.survey_in.dto;

import com.survey_in.entity.Answer;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AnswerDto {
    private MemberDto member;
    private int questionOptionId;
    private Time createdAt;

    public AnswerDto(){

    }

    public AnswerDto(MemberDto member, Time createdAt) {
        this.member = member;
        this.createdAt = createdAt;
    }

    public AnswerDto(MemberDto member, Time createdAt, int questionOptionId) {
        this.member = member;
        this.createdAt = createdAt;
        this.questionOptionId = questionOptionId;
    }

    public AnswerDto(Time createdAt){
        this.createdAt = createdAt;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public int getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(int questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    public static AnswerDto of(Answer answer){
        return new AnswerDto(answer.getCreatedAt());
    }
    public static List<AnswerDto> of(List<Answer> answers){
        List<AnswerDto> answerDtos = new ArrayList<AnswerDto>();
        for (Answer answer: answers) {
            answerDtos.add(AnswerDto.of(answer));
        }
        return  answerDtos;
    }
}
