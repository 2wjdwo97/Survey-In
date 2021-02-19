package com.survey_in.entity;

import java.sql.Time;
import java.util.HashMap;

public class Survey {
    private String title;
    private String category;
    private int id;
    private int capacity;
    private int point;
    private int questionCount;
    private String optionGender;
    private String optionAge;
    private Time createdAt;
    private int member_id;
    private String survey_id;
    private int questionCnt;

    public Survey(int id, int member_id, String title, String category, int capacity, int point, int questionCnt, Time createdAt) {
        this.id = id;
        this.member_id = member_id;
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCnt = questionCnt;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public String getOptionGender() {
        return optionGender;
    }

    public void setOptionGender(String optionGender) {
        this.optionGender = optionGender;
    }

    public String getOptionAge() {
        return optionAge;
    }

    public void setOptionAge(String optionAge) {
        this.optionAge = optionAge;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }
}
