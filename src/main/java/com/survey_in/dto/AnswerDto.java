package com.survey_in.dto;

public class AnswerDto {
    private MemberDto member;

    public AnswerDto(MemberDto member) {
        this.member = member;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }
}
