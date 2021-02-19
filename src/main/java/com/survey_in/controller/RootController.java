package com.survey_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    @RequestMapping("/search")
    public void search(){
        System.out.println("a");
    }
}
