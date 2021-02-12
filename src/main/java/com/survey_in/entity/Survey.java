package com.survey_in.entity;

public class Survey {
    private String title;
    private String category;
    private int capacity;
    private int point;
    private int questionCount;
    private String optionGender;
    private String optionAge;
    private String createdAt;

    public Survey(String title, String category, int capacity, int point, int questionCount, String optionGender,
                  String optionAge, String createdAt) {
        this.title = title;
        this.category = category;
        this.capacity = capacity;
        this.point = point;
        this.questionCount = questionCount;
        this.optionGender = optionGender;
        this.optionAge = optionAge;
        this.createdAt = createdAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
