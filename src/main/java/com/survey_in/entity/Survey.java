package com.survey_in.entity;

import java.sql.Timestamp;

public class Survey {
    private int id;
    private int member_id;
    private String title;
    private String category;
    private int capacity;
    private int point;
    private int questionCnt;
    private Timestamp createdAt;
    private String ageLimit;
    private String genderLimit;
    private Boolean status;
    private int participant;

    public Survey(int id, int member_id, String title, String category, int capacity, int point, int questionCnt,
                  String ageLimit, String genderLimit, Timestamp createdAt, Boolean status, int participant) {
        this.id = id;
        this.member_id = member_id;
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCnt = questionCnt;
        this.createdAt = createdAt;
        this.ageLimit = ageLimit;
        this.genderLimit = genderLimit;
        this.status = status;
        this.participant = participant;
    }

    public Survey(int member_id, String title, String category, int capacity, int point, int questionCnt, String ageLimit, String genderLimit) {
        this.id = id;
        this.member_id = member_id;
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCnt = questionCnt;
        this.ageLimit = ageLimit;
        this.genderLimit = genderLimit;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getGenderLimit() {
        return genderLimit;
    }

    public void setGenderLimit(String genderLimit) {
        this.genderLimit = genderLimit;
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
                ", ageLimit='" + ageLimit + '\'' +
                ", genderLimit='" + genderLimit + '\'' +
                '}';
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }
}
