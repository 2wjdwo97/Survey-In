package com.survey_in.service;

import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;

import java.util.List;

public interface SearchService {
    int getCntSearchSurvey(String keyword, FilterVO filter);
    List<Survey> searchSurvey(String keyword, FilterVO filter, PagingVO paging);
    List<Survey> searchQuestion();
}
