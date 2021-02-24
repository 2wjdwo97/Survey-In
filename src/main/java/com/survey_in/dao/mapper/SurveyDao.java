package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;

import java.util.List;

public interface SurveyDao {
    List<Survey> getSurveys();
    void insertSurvey(Survey survey);
    Survey selectSurvey(String survey_id);
    void deleteSurvey(String survey_id);
    List<Survey> selectMemberSurveys(int member_id);

    int getCntSearchSurvey(String keyword, FilterVO filter);
    List<Survey> searchSurvey(String keyword, FilterVO filter, PagingVO paging);
}
