package com.survey_in.controller;

import com.survey_in.entity.Member;
import com.survey_in.service.MemberService;
import com.survey_in.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MySurveyController {
    private SurveyService surveyService;

    @Autowired
    public MySurveyController(@Qualifier("surveyService") SurveyService surveyService){
        this.surveyService = surveyService;
    }

    @RequestMapping(value = "/mySurveys/new", method = RequestMethod.GET)
    public String newSurvey() {
        System.out.println("hi");
        return "mySurveys.new";
    }

    @RequestMapping(value = "/mySurveys/new", method = RequestMethod.POST)
    public String create(Principal principal, String title, int point, String category, int capacity){
        surveyService.createSurvey(principal.getName(), title, point, category, capacity);
        return "mySurveys.list";
    }
}
