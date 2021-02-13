package com.survey_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
//
//    private SearchService searchService;
//
//    @Autowired
//    public SearchController(@Qualifier("searchServiceBean") SearchService searchService){
//        this.searchService = searchService;
//    }

    @RequestMapping("/search")
    public String search() {
        return "mySurveys.search";
    }
}
