package com.survey_in.entity;

import java.sql.Time;

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

    public Answer(int question_option_id, int member_id, Time createdAt) {
        this.question_option_id = question_option_id;
        this.member_id = member_id;
        this.createdAt = createdAt;
    }
}
