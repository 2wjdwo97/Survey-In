package com.survey_in.dto;

import com.survey_in.entity.Member;

public class MemberDto {
    private String username;
    private int age;
    private String gender;
    private String job;
    private int point;
    private String name;
    private String email;

    public MemberDto(){

    }

    public MemberDto(String username, int age, String gender, String job, int point, String name, String email) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.job = job;
        this.point = point;
        this.name = name;
        this.email = email;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static MemberDto of(Member member){
        return new MemberDto(member.getUsername(), member.getAge(), member.getGender(), member.getJob(),
                member.getPoint(), member.getName(), member.getEmail());
    }
}

