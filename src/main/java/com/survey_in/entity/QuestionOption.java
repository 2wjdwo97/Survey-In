package com.survey_in.entity;

public class QuestionOption {
    private int question_id;
    private int option_id;

    public QuestionOption(int question_id, int option_id) {
        this.question_id = question_id;
        this.option_id = option_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }
}
