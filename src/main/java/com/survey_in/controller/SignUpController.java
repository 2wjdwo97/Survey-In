package com.survey_in.controller;

import com.survey_in.service.SignUpServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class SignUpController{
    private SignUpServ signUpServ;

    @Autowired
    public SignUpController(SignUpServ signUpServ){
        this.signUpServ = signUpServ;
    }

    @RequestMapping("/join")
    public String join(String id, String pw, String pwc, String fn, String ln, String email,
                    String bd, String gender) throws SQLException, ClassNotFoundException {
        if(id != null && !id.equals("")) {
            signUpServ.signUp(id, pw, fn, ln, email, bd, gender);
            System.out.println(id);
            return "login";
        }

        return "join";
    }
}

//id, pw, pwc, fn, ln, email, bd, gender