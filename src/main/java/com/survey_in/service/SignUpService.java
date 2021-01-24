package com.survey_in.service;

import com.survey_in.entity.SignUpInfo;

import java.sql.Date;

public class SignUpService {
    public SignUpInfo getSignUpInfo() {
        return signUpInfo;
    }

    public void setSignUpInfo(SignUpInfo signUpInfo) {
        this.signUpInfo = signUpInfo;
    }

    public SignUpService(){
        signUpInfo = new SignUpInfo();
    }

    private SignUpInfo signUpInfo;

    public void signUp(){
        //DB에 저장

//        private String username;
//        private String password;
//        private String password_confirm;
//        private String first_name;
//        private String last_name;
//        private String email;
//        private Date birthday;
//        private Boolean male;
    }
}
