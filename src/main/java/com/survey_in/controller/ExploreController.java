package com.survey_in.controller;


import com.survey_in.entity.Survey;
import com.survey_in.service.ExploreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ExploreController {

    private ExploreService exploreService;

    @Autowired
    public ExploreController( @Qualifier("serviceBeanExplore") ExploreService exploreService){
        this.exploreService = exploreService;
        System.out.println("hihi");
    }

    @RequestMapping(value = ("/explore"), method = RequestMethod.GET)
    public String index(){
        try {
            List<Survey> surveys = exploreService.getAllSurveys();
            surveys.forEach((elem) -> {
                System.out.println(elem.getTitle());

            });

        }catch(Exception e){
            System.out.println("exception!! "+ e.toString());
            if(e instanceof ClassNotFoundException){
                // log
            }else{
                //log
            }
        }

        return "explore.explore";
    }

//    public ModelAndView getAllSurveyList(){
//        ModelAndView v = new ModelAndView();
//        v.setViewName("explore/explore");
//    }



}
