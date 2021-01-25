package com.survey_in.controller;

import com.survey_in.service.SignUpServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements Controller {
    private SignUpServ signUpServ;


    @Autowired
    @Qualifier("Service")
    public void setSignUpServ(SignUpServ signUpServ){
        this.signUpServ = signUpServ;
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView("join");
        signUpServ.signUp();

        return mv;
    }
}