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
    public String join(String id, String pw, String pwc, String fn, String ln, String email,
                       String bd, String gender) throws SQLException, ClassNotFoundException {
        if(id != null && !id.equals("")) {
            memberService.signUp(id, pw, fn, ln, email, bd, gender);
            System.out.println(id);
            return "login";
        }

        return "join";
    }

    @RequestMapping("/login")
    public String login(String id, String pw) throws SQLException, ClassNotFoundException {
        Boolean verified;
        verified = memberService.signIn(id, pw);
        if(verified)
            return "index";
        else
            return null;
    }
}