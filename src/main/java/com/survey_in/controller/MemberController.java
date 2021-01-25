package com.survey_in.controller;

import com.survey_in.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @RequestMapping("/join")
    public void join() throws SQLException, ClassNotFoundException {
        memberService.signUp();
    }

    @RequestMapping("/login")
    public void login(String id, String pw) throws SQLException, ClassNotFoundException {
        memberService.signIn(id, pw);
    }
}