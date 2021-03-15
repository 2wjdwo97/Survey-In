package com.survey_in.service;


import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ExploreService {
    public List<Survey> getAllSurveys()
            throws ClassNotFoundException, SQLException;

    public List<Survey> getSurveyByFilter()
            throws ClassNotFoundException, SQLException;

    public List<SurveyDto> getRecentSurveys(int num)
            throws ClassNotFoundException, SQLException;

    public List<Survey> getTrendingSurvey(int num)
            throws ClassNotFoundException, SQLException;

    public List<SurveyDto> getValuableSurvey(int num)
            throws ClassNotFoundException, SQLException;

}
