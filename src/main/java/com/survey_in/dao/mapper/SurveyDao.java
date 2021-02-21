package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;

import java.util.List;

public interface SurveyDao {
    List<Survey> getAllSurveys();
    void insertSurvey(Survey survey);
    Survey selectSurvey(int survey_id);
    void deleteSurvey(String survey_id);
    List<Survey> selectMemberSurveys(int member_id);

    int getCntSurvey();
    List<Survey> searchSurvey(String keyword, FilterVO filter);
}
