package com.survey_in.controller;
import java.security.Principal;


import com.survey_in.entity.Survey;
import com.survey_in.service.ExploreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ExploreController {

    private ExploreService exploreService;

    @Autowired
    public ExploreController( @Qualifier("serviceBeanExplore") ExploreService exploreService){
        this.exploreService = exploreService;
    }

    @RequestMapping(value = ("/explore"), method = RequestMethod.GET)
    public String index(Model model, Principal principal){
        try {
            List<Survey> surveys = exploreService.getAllSurveys();
            model.addAttribute("surveys", surveys);
            model.addAttribute("username", principal.getName());
            surveys.forEach((elem) -> {
                System.out.println(elem.getTitle());
            });
        }catch(Exception e){
            System.out.println("exception!! " + e.toString());
            if(e instanceof ClassNotFoundException){
                // log
            }else{
                //log
            }
        }
        System.out.println("returning explore.explore");
        return "explore.explore";
    }




}
