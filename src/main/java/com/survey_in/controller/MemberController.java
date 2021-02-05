package com.survey_in.controller;

import com.survey_in.entity.Member;
import com.survey_in.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(@Qualifier("service") MemberService memberService){
        this.memberService = memberService;
    }

    @RequestMapping("/join")
    public String join(String id, String pw, String pwc, String fn, String ln, String email,
                       String bd, String gender, String job) throws SQLException, ClassNotFoundException {
        if(id != null && !id.equals("")) {
            memberService.signUp(id, pw, fn, ln, email, bd, gender, job);
            return "login";
        }

        return "join";
    }

    @RequestMapping("/login")
    public String login(HttpServletResponse response, String id, String pw) throws SQLException, ClassNotFoundException {
        List<Member> list = memberService.signIn();
        System.out.println(list.get(0).getUsername());
        return "login";
/*        int user_no = memberService.signIn(id, pw);
        if(user_no != -1) {
            Cookie user = new Cookie("user_id", Integer.toString(user_no));
            user.setMaxAge(1000);
            response.addCookie(user);
            return "redirect: mySurveys/list";
        }
        else
            return "login";*/
    }
}