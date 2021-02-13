package com.survey_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    @RequestMapping("/mySurveys/list")
    public String mySurveys(){
        return "mySurveys.list";
    }

//    @RequestMapping("/search")
//    public void search(){
//        System.out.println("a");
//    }
}
