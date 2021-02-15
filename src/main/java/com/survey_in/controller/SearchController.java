package com.survey_in.controller;

import com.survey_in.entity.Survey;
import com.survey_in.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(@Qualifier("searchServiceBean") SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,
                         @RequestParam(value = "q", defaultValue = "") String keyword,
                         @RequestParam(value = "p", defaultValue = "1") String page,
                         String target, String category, String age) {

        List<Survey> surveys;

        if (null == category) category = "all";
        if (null == age) age = "all";

        if (null == target || target.equals("question"))
            surveys = searchService.searchSurvey(keyword, category, age);
        else
            surveys = searchService.searchQuestion();

        System.out.println(surveys.size());

        model.addAttribute("keyword", keyword);
        model.addAttribute("surveys", surveys);
        model.addAttribute("patage", page);

        return "mySurveys.search";
    }
}
