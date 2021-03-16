package com.survey_in.controller;


import com.survey_in.dto.*;
import com.survey_in.service.AnswerService;
import com.survey_in.service.MemberService;
import com.survey_in.service.QuestionServiceImpl;
import com.survey_in.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private QuestionServiceImpl questionService;

    @Autowired
    public MySurveyController(@Qualifier("surveyService") SurveyService surveyService,
                              @Qualifier("answerServiceBean") AnswerService answerService,
                              @Qualifier("memberServiceBean") MemberService memberService,
                              @Qualifier("questionServiceBean") QuestionServiceImpl questionService) {
        this.surveyService = surveyService;
        this.answerService = answerService;
        this.memberService = memberService;
        this.questionService = questionService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey(Model model, Principal principal) {
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "mySurveys.new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(Principal principal, SurveyDto surveyDto, String title, int capacity, String category,
                         int point, String gender_limit, String age_limit, HttpServletRequest request) {
        surveyService.createSurvey(principal.getName(), title, capacity, category, point, gender_limit, age_limit,
                surveyDto.getQuestions());
        return "redirect:/" + principal.getName() + "/surveys";
    }

    @RequestMapping("/surveys")
    public String mySurveys(Model model, @PathVariable String username, Principal principal) {
        boolean isMySurvey;
        isMySurvey = !username.equals(principal.getName());

        model.addAttribute("isMySurvey", isMySurvey);
        model.addAttribute("list", surveyService.getMemberSurveys(username));
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "mySurveys.surveys";
    }

    @RequestMapping("/surveys/{surveyId}")
    public String manageSurvey(Model model, HttpServletResponse response, HttpServletRequest request,
                               @RequestParam(defaultValue = "get") String method,
                               @PathVariable int surveyId, Principal principal) throws IOException {
        // View detail of surveys
        if (method.equals("get")) {

            MemberDto registerMember = memberService.getMemberBySurvey(surveyId);   // 설문을 등록한 사용자
            String registrantName = registerMember.getUsername();

            // 설문을 등록한 사용자거나 이미 참여한 설문인 경우
            if (registrantName.equals(principal.getName()) ||
                    !memberService.checkAttendance(principal.getName(), surveyId)) {

                model.addAttribute("survey", surveyService.getSurveyDetail(surveyId));
                model.addAttribute("member", memberService.getMember(principal.getName()));
                return "mySurveys.detail";
            }
            // 설문을 참여 안한 경우
            else {
                alert(response, "You must participate in the survey to see the results.", surveyId + "/answer");
            }
        }
        // Delete a survey
        else if (method.equals("delete")) {
            surveyService.deleteSurvey(surveyId);
            return "redirect:/" + principal.getName() + "/surveys";
        }

        return null; // error
    }

    @RequestMapping("/surveys/detail")
    @ResponseBody
    public QuestionDto detail(int questionId) {
        return questionService.getQuestionDetail(questionId);
    }

    @RequestMapping(value = "/surveys/{surveyId}/answer", method = RequestMethod.GET)
    public String getAnswerSheet(Model model, @PathVariable String username,
                                 @PathVariable int surveyId, Principal principal,
                                 HttpServletResponse response, HttpServletRequest request) throws IOException {
        MemberDto member = memberService.getMember(principal.getName());
        SurveyDto survey = surveyService.getSurveyDetail(surveyId);

        if (username.equals(principal.getName())) {
            alert(response, "자신의 설문에 참여할 수 없습니다.", request.getHeader("Referer"));
        } else if (!memberService.checkAttendance(principal.getName(), surveyId)) {
            alert(response, "이미 참여한 설문입니다.", request.getHeader("Referer"));
        } else if (!surveyService.checkCapacity(surveyId)) {
            alert(response, "종료된 설문입니다.", request.getHeader("Referer"));
        } else if (!(survey.getGenderLimit().equals("all") || survey.getGenderLimit().equals(member.getGender())
        ) || !(survey.getAgeLimit().equals("all") || (member.getAge() - Integer.parseInt(survey.getAgeLimit()) < 10 && member.getAge() - Integer.parseInt(survey.getAgeLimit()) >= 0))) {
            alert(response, "참여할 수 없는 설문입니다.", request.getHeader("Referer"));
        }

        model.addAttribute("survey", survey);
        model.addAttribute("member", member);
        return "mySurveys.answer";
    }

    @RequestMapping(value = "/surveys/{surveyId}/answer", method = RequestMethod.POST)
    public String submitAnswerSheet(AnswerSheetDto answerSheetDto, Model model,
                                    @PathVariable int surveyId, Principal principal, HttpServletRequest request) {
        answerService.createAnswer(answerSheetDto.getAnswers(), principal.getName(), surveyId);
        model.addAttribute("member", memberService.getMember(principal.getName()));
        return "redirect: /explore";
    }

    void alert(HttpServletResponse response, String msg, String href) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>" +
                "alert('" + msg + "');" +
                "location.href='" + href + "';" +
                "</script>");
        out.flush();
    }
}