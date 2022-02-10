package com.survey_in.service;

import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;

import java.util.List;

public interface SearchService {
    int getCntSearchSurvey(String keyword, FilterVO filter);
    int getCntSearchQuestion(String keyword, FilterVO filter);
    List<SurveyDto> searchSurvey(String keyword, FilterVO filter, PagingVO paging);
    List<SurveyDto> searchQuestion(String keyword, FilterVO filter, PagingVO paging);
}
