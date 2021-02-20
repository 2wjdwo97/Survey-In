package com.survey_in.controller;

import com.survey_in.dto.QuestionDto;
import com.survey_in.dto.SurveyDto;
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
@RequestMapping("/{username}")
public class MySurveyController {
    private SurveyService surveyService;

    @Autowired
    public MySurveyController(@Qualifier("surveyService") SurveyService surveyService){
        this.surveyService = surveyService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "mySurveys.new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(Principal principal, SurveyDto surveyDto, String title, int capacity, String category,
                         int point, String gender_limit, String age_limit){
        surveyService.createSurvey(principal.getName(), title, point, category, capacity, gender_limit, age_limit,
                surveyDto.getQuestions());
        return "redirect:/" + principal.getName() + "/surveys";
    }

    @RequestMapping("/surveys")
    public String mySurveys(Model model, @PathVariable String username, Principal principal){
        model.addAttribute("list", surveyService.getMemberSurveys(username));
        model.addAttribute("username", principal.getName());
        return "mySurveys.surveys";
    }

    @RequestMapping("/surveys/{surveyId}")
    public String mySurveyDetail(Model model, @PathVariable int surveyId, Principal principal){
        model.addAttribute("survey", surveyService.getSurveyDetail(surveyId)); //return survey
        model.addAttribute("username", principal.getName());
        return "mySurveys.detail";
    }
}