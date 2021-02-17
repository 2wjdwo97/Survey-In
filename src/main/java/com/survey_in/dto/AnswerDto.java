package com.survey_in.dto;

import com.survey_in.entity.Answer;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AnswerDto {
    private MemberDto member;
    private Time createdAt;

    public AnswerDto(MemberDto member, Time createdAt) {
        this.member = member;
        this.createdAt = createdAt;
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
