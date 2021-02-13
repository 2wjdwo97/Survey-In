package com.survey_in.service;

import com.survey_in.entity.Question;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SurveyServiceImpl implements SurveyService{
    public void createSurvey(int memberNum, int capacity, String category, int point){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;

        String username = userDetails.getUsername();

    }
}
