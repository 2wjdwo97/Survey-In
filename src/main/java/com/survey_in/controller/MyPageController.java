package com.survey_in.controller;


import com.survey_in.entity.Member;
import com.survey_in.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
@RequestMapping("/{username}")
public class MyPageController {

    private MemberService memberService;

    @Autowired
    public MyPageController(@Qualifier("memberServiceBean") MemberService memberService) {

        this.memberService = memberService;
    }

    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public String myPage(Model model, Principal principal){

        model.addAttribute("member", memberService.getMember(principal.getName()));

        return "mySurveys.mypage";
    }



}
