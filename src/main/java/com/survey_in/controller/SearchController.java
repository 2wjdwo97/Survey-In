package com.survey_in.controller;

import com.survey_in.entity.Survey;
import com.survey_in.service.SearchService;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PageVO;
import com.survey_in.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(@Qualifier("searchService") SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,
                         @RequestParam(value = "q", defaultValue = "") String keyword,
                         @ModelAttribute("page") PageVO page,
                         @ModelAttribute("filter") FilterVO filter) {

        List<Survey> surveys;
        PagingVO paging = new PagingVO(page, searchService.getCntSearchSurvey(keyword, filter));

        if (filter.getTar().equals("survey"))
            surveys = searchService.searchSurvey(keyword, filter, paging);
        else
            surveys = searchService.searchQuestion();

        model.addAttribute("surveys", surveys);
        model.addAttribute("paging", paging);
        model.addAttribute("keyword", keyword);

        return "mySurveys.search";
    }
}
