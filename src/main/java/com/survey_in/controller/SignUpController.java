package com.survey_in.controller;

import com.survey_in.service.SignUpServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class SignUpController{
    private SignUpServ signUpServ;

    @Autowired
    public SignUpController(SignUpServ signUpServ){
        this.signUpServ = signUpServ;
    }

    @RequestMapping("/join")
    public void join() throws SQLException, ClassNotFoundException {
        signUpServ.signUp();
    }
}