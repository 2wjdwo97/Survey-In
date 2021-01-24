package com.survey_in.entity;

import java.sql.Date;

public class SignUpInfo {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    private String username;
    private String password;
    private String password_confirm;
    private String first_name;
    private String last_name;
    private String email;
    private Date birthday;
    private Boolean male;

    public SignUpInfo(){

    }

    public SignUpInfo(String username, String password, String password_confirm, String first_name, String last_name,
                      String email, Date birthday, Boolean male){
        this.username = username;
        this.password = password;
        this.password_confirm = password_confirm;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.birthday = birthday;
        this.male = male;
    }
}
