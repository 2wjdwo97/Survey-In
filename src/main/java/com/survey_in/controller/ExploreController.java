package com.survey_in.controller;
import java.security.Principal;


import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import com.survey_in.service.ExploreService;
import com.survey_in.service.MemberService;
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
    private MemberService memberService;


    @Autowired
    public ExploreController( @Qualifier("exploreServiceBean") ExploreService exploreService,
                              @Qualifier("memberServiceBean") MemberService memberService){
        this.exploreService = exploreService;
        this.memberService = memberService;

    }

    @RequestMapping(value = ("/explore"), method = RequestMethod.GET)
    public String index(Model model, Principal principal){
        // 1. get newest by date
        // 2. get most valuable by points
        // 3. get shortest by question cnt

        List<SurveyDto> recents = null;
//        List<SurveyDto> trending = null;
        List<SurveyDto> points = null;

        try {
            recents = exploreService.getRecentSurveys(5);
            points = exploreService.getValuableSurvey(5);

            model.addAttribute("recents", recents);
            model.addAttribute("points", points);
            model.addAttribute("username", principal.getName());
            model.addAttribute("member", memberService.getMember(principal.getName()));

        }catch(Exception e){
            System.out.println("exception!! " + e.toString());
            if(e instanceof ClassNotFoundException){
                // log
            }else{
                //log
            }
        }
//        System.out.println("returning explore");
//        System.out.println(recents);
//        System.out.println(points);
        return "mySurveys.explore";
    }




}
