package com.survey_in.controller;

import com.survey_in.dto.SurveyDto;
import com.survey_in.service.SearchService;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PageVO;
import com.survey_in.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(@Qualifier("searchService") SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, Principal principal,
                         @RequestParam(value = "q", defaultValue = "") String keyword,
                         @ModelAttribute("page") PageVO page,
                         @ModelAttribute("filter") FilterVO filter) {

        if (keyword.equals(""))
            return "mySurveys.search";

        List<SurveyDto> surveys;
        PagingVO paging;

        if (filter.getTar().equals("survey")) {
            paging = new PagingVO(page, searchService.getCntSearchSurvey(keyword, filter));
            surveys = searchService.searchSurvey(keyword, filter, paging);
        }
        else {
            paging = new PagingVO(page, searchService.getCntSearchQuestion(keyword, filter));
            surveys = searchService.searchQuestion(keyword, filter, paging);
        }

        model.addAttribute("surveys", surveys);
        model.addAttribute("paging", paging);
        model.addAttribute("keyword", keyword);
        model.addAttribute("username", principal.getName());

        return "mySurveys.search";
    }
}