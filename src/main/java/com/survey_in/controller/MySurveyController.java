package com.survey_in.controller;


import com.survey_in.dto.AnswerDto;
import com.survey_in.dto.AnswerSheetDto;
import com.survey_in.dto.QuestionDto;
import com.survey_in.dto.SurveyDto;
import com.survey_in.service.AnswerService;
import com.survey_in.service.MemberService;
import com.survey_in.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@Controller
@RequestMapping("/{username}")
public class MySurveyController {
    private SurveyService surveyService;
    private AnswerService answerService;
    private MemberService memberService;

    @Autowired
    public MySurveyController(@Qualifier("surveyService") SurveyService surveyService,
                              @Qualifier("answerServiceBean") AnswerService answerService,
                              @Qualifier("serviceBean") MemberService memberService){
        this.surveyService = surveyService;
        this.answerService = answerService;
        this.memberService = memberService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey(Model model, Principal principal) {
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "mySurveys.new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(Principal principal, SurveyDto surveyDto, String title, int capacity, String category,
                         int point, String gender_limit, String age_limit , HttpServletRequest request){
        surveyService.createSurvey(principal.getName(), title, point, category, capacity, gender_limit, age_limit,
                surveyDto.getQuestions());
        memberService.subPoint(principal.getName(), point * capacity);
        return "redirect:/" + principal.getName() + "/surveys";
    }

    @RequestMapping("/surveys")
    public String mySurveys(Model model, @PathVariable String username, Principal principal){
        model.addAttribute("list", surveyService.getMemberSurveys(username));
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "mySurveys.surveys";
    }

    @RequestMapping("/surveys/{surveyId}")
    public String mySurveyDetail(Model model, @PathVariable int surveyId, Principal principal){
        model.addAttribute("survey", surveyService.getSurveyDetail(surveyId)); //return survey
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "mySurveys.detail";
    }

    @RequestMapping(value = "/surveys/{surveyId}/answer", method = RequestMethod.GET)
    public String getAnswerSheet(Model model, @PathVariable String username,
                                 @PathVariable int surveyId, Principal principal,
                                 HttpServletResponse response, HttpServletRequest request) throws IOException  {
        if(username.equals(principal.getName())) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('자신의 설문에 참여할 수 없습니다.'); location.href='" + request.getHeader("Referer") + "';</script>");
            out.flush();
        }
        else if(!memberService.checkAttendance(principal.getName(), surveyId)){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 참여한 설문입니다.'); location.href='" + request.getHeader("Referer") + "';</script>");
            out.flush();
        }
        model.addAttribute("survey", surveyService.getSurveyDetail(surveyId));
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "mySurveys.answer";
    }

    @RequestMapping(value = "/surveys/{surveyId}/answer", method = RequestMethod.POST)
    public String submitAnswerSheet(AnswerSheetDto answerSheetDto, Model model,
                                    @PathVariable int surveyId, Principal principal,HttpServletRequest request){
        answerService.createAnswer(answerSheetDto.getAnswers(), principal.getName());
        memberService.addPoint(principal.getName(), surveyService.getSurveyDetail(surveyId).getPoint());
        model.addAttribute("member", memberService.getMember(principal.getName()));

        return "redirect: /explore";
    }
}