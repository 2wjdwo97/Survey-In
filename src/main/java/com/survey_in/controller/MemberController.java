package com.survey_in.controller;

import com.survey_in.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(@Qualifier("serviceBean") MemberService memberService){
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response, String id, String pw) throws SQLException, ClassNotFoundException {
//        List<Member> list = memberService.signIn();
//        System.out.println(list.get(0).getUsername());
        return "login";
    }

    @RequestMapping(value="/givePoint", method = RequestMethod.GET)
    public String givePoint(){
        return "givePoint";
    }

    @RequestMapping(value="/givePoint", method = RequestMethod.POST)
    public String givePoint(Principal principal, String username, int point){
        memberService.givePoint(principal.getName(), username, point);
        return "givePoint";
    }

    @RequestMapping(value="/checkValidity", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> checkValidity(Principal principal,
                                              @RequestParam("username") String username,
                                              @RequestParam("point") int point){
        Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
        if(memberService.getMember(username) == null) {
            resultMap.put("result_user", false);
            resultMap.put("result_point", false);
        }
        else {
            resultMap.put("result_user", true);

            if(memberService.getPoint(principal.getName()) < point)
                resultMap.put("result_point", false);
            else
                resultMap.put("result_point",true);
        }


        return resultMap;
    }

    @RequestMapping(value="/checkPoint", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> checkPoint(Principal principal,
                                          @RequestParam("point") int point){
        Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

        if(memberService.getPoint(principal.getName()) < point)
            resultMap.put("result_point", false);
        else
            resultMap.put("result_point",true);

        return resultMap;
    }
}