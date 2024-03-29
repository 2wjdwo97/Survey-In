package com.survey_in.controller;

import com.survey_in.dto.MemberDto;
import com.survey_in.dto.QuestionDto;
import com.survey_in.dto.SurveyDto;
import com.survey_in.service.MemberService;
import com.survey_in.service.SearchService;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PageVO;
import com.survey_in.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SearchController {

    private final SearchService searchService;
    private final MemberService memberService;

    @Autowired
    public SearchController(@Qualifier("searchService") SearchService searchService,
                            @Qualifier("memberServiceBean") MemberService memberService) {
        this.searchService = searchService;
        this.memberService = memberService;
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
        } else {
            paging = new PagingVO(page, searchService.getCntSearchQuestion(keyword, filter));
            surveys = searchService.searchQuestion(keyword, filter, paging);
        }

        model.addAttribute("surveys", surveys);
        model.addAttribute("paging", paging);
        model.addAttribute("keyword", keyword);
        model.addAttribute("username", principal.getName());

        return "mySurveys.search";
    }

    @RequestMapping(value = "/search/{surveyId}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getRegistrantName(@RequestBody Map<String, Object> param) {
        String username = (String) param.get("username");
        int surveyId = (int) param.get("surveyId");

        MemberDto registrant = memberService.getMemberBySurvey(surveyId);   // 설문을 등록한 사용자
        String registrantName = registrant.getUsername();

        boolean canView = false;
        if (registrantName.equals(username) || !memberService.checkAttendance(username, surveyId))
            canView = true;    // 설문을 등록한 사용자거나 이미 참여한 설문인 경우


        Map<String, Object> map = new HashMap<>();
        map.put("registrant", registrantName);
        map.put("canView", canView);
//        alert(response, "You must participate in the survey to see the results.", surveyId + "/answer");

        return map;
    }
}
