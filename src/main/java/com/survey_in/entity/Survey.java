package com.survey_in.entity;

import java.sql.Time;

public class Survey {
    private int id;
    private int member_id;
    private String title;
    private String category;
    private int capacity;
    private int point;
    private int questionCnt;
    private Time createdAt;
    private String age_limit;

    private String gender_limit;

    public Survey(int id, int member_id, String title, String category, int capacity, int point, int questionCnt,
                  Time createdAt, String age_limit, String gender_limit) {
        this.id = id;
        this.member_id = member_id;
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCnt = questionCnt;
        this.createdAt = createdAt;
        this.age_limit = age_limit;
        this.gender_limit = gender_limit;
    }

    public Survey(int member_id, String title, String category, int capacity, int point, int questionCnt, String age_limit, String gender_limit) {
        this.member_id = member_id;
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCnt = questionCnt;
        this.age_limit = age_limit;
        this.gender_limit = gender_limit;
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

    public int getQuestionCnt() {
        return questionCnt;
    }

    public void setQuestionCnt(int questionCnt) {
        this.questionCnt = questionCnt;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getId(){ return id;}

    public void setId(int id) {this.id = id;}

    public Time getCreatedAt(){return createdAt;}

    public void setCreatedAt(Time createdAt){this.createdAt = createdAt;}

    public String getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(String age_limit) {
        this.age_limit = age_limit;
    }

    public String getGender_limit() {
        return gender_limit;
    }

    public void setGender_limit(String gender_limit) {
        this.gender_limit = gender_limit;
    }

}
