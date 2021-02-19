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

    public Survey(int member_id, String title, String category, int capacity, int point, int questionCnt) {
        this.member_id = member_id;
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCnt = questionCnt;
    }

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

    public int getQuestionCnt() {
        return questionCnt;
    }

    public void setQuestionCnt(int questionCnt) {
        this.questionCnt = questionCnt;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", member_id=" + member_id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", capacity=" + capacity +
                ", point=" + point +
                ", questionCnt=" + questionCnt +
                ", createdAt=" + createdAt +
                '}';
    }
}