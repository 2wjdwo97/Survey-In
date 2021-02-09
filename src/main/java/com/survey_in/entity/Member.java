package com.survey_in.entity;

public class Member {
    private String username;
    private String pwd;
    private String name;
    private String gender;
    private int age;
    private String birthday;
//    private String phone;
//    private Date regDate;
    private String email;
    private String job;
    private String auth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

/*    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAuth(){return auth;}

    public void setAuth(String auth){this.auth = auth;}

    public Member(String username, String pwd, String name, String gender, int age, String birthday,
                   String email, String job) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
//        this.phone = phone;
        this.email = email;
        this.job = job;
    }
}
