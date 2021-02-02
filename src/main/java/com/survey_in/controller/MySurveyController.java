package com.survey_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MySurveyController {
    @RequestMapping("/mySurveys/new")
    public String create() {
        return "mySurveys.new";
    }
}
