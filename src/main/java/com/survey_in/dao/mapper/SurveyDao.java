package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;

import java.util.List;

public interface SurveyDao {
    int getCntSurvey();
    List<Survey> searchSurvey(String keyword, FilterVO filter);
}
