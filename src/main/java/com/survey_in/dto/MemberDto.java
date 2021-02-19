package com.survey_in.dto;

public class MemberDto {
    private int age;
    private String gender;
    private String job;


    public MemberDto(int age, String gender, String job) {
        this.age = age;
        this.gender = gender;
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
