package com.survey_in.service;


import com.survey_in.entity.Survey;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ExploreService {
    public List<Survey> getAllSurveys()
            throws ClassNotFoundException, SQLException;

    public List<Survey> getSurveyByFilter()
            throws ClassNotFoundException, SQLException;


}
