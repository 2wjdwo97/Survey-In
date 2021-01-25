package com.survey_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController{
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

   /* public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }*/
}
