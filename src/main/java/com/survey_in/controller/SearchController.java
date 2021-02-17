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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                         @RequestParam(value = "tar", defaultValue = "survey") String target,
                         @RequestParam(value = "cat", defaultValue = "all") String category,
                         @RequestParam(value = "age", defaultValue = "all") String age) {

//        System.out.println("keyword:" + keyword + "  page:" + page + "  target:" + target + "  cate:" + category + "  age:" + age);

        List<Survey> surveys;

        if (target.equals("survey"))
            surveys = searchService.searchSurvey(keyword, category, age);
        else
            surveys = searchService.searchQuestion();


        Map<String, String> param = new HashMap<>();

        param.put("keyword", keyword);
        param.put("target", target);
        param.put("category", category);
        param.put("age", age);
        param.put("page", page);


        model.addAttribute("surveys", surveys);
        model.addAttribute("searchParam", param);

        return "mySurveys.search";
    }
}
