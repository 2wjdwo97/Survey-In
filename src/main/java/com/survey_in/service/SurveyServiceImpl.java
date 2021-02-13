package com.survey_in.service;

import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.entity.Member;
import com.survey_in.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
    private SurveyDao surveyDao;
    private MemberDao memberDao;

    @Autowired
    public SurveyServiceImpl(@Qualifier("surveyDaoBean") SurveyDao surveyDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao){
        this.surveyDao = surveyDao;
        this.memberDao = memberDao;
    }

    public void createSurvey(String memberID, String title, int capacity, String category, int point){
        System.out.println(memberID);
        int id = memberDao.selectMemberId(memberID);
        System.out.println(id);
        Survey newSurvey = new Survey(id, title, category, capacity, point, 0);
        surveyDao.insertSurvey(newSurvey);
    }
}