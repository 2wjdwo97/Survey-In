package com.survey_in.controller;

import com.survey_in.entity.NewSurveyEntity;
import com.survey_in.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("/mySurveys")
public class MySurveyController {
    private SurveyService surveyService;

    @Autowired
    public MySurveyController(@Qualifier("surveyService") SurveyService surveyService){
        this.surveyService = surveyService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey() {
        return "mySurveys.new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(NewSurveyEntity newSurveyEntity, Principal principal, String title, int point, String category, int capacity){
        surveyService.createSurvey(principal.getName(), title, point, category, capacity, newSurveyEntity.getList());
        return "mySurveys/surveys";
    }

    @RequestMapping("/surveys")
    public String mySurveys(Model model, Principal principal){
        model.addAttribute("list", surveyService.getMemberSurveys(principal.getName()));
        return "mySurveys.surveys";
    }
}