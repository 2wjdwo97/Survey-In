package com.survey_in.dao.mapper;

import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;

import java.util.HashMap;
import java.util.List;

public interface SurveyDao {
    List<Survey> getAllSurveys();
    void insertSurvey(Survey survey);
    Survey selectSurvey(int survey_id);
    void deleteSurvey(int survey_id);

    List<Survey> selectMemberSurveys(int member_id);

    SurveyDto testJoin(int survey_id);

    int getCntSearchSurvey(String keyword, FilterVO filter);

    int getCntSearchQuestion(String keyword, FilterVO filter);
    List<SurveyDto> searchSurvey(String keyword, FilterVO filter, PagingVO paging);
    List<SurveyDto> searchQuestion(String keyword, FilterVO filter, PagingVO paging);

    List<SurveyDto> getSurveyByDate(int searchnum);
    List<SurveyDto> getSurveyByPoints(int searchnum);

    void addParticipant(int surveyId);
}
