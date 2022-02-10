package com.survey_in.service;

import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Question;
import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

    private SurveyDao surveyDao;

    @Autowired
    public SearchServiceImpl(@Qualifier("surveyDaoBean") SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    @Override
    public int getCntSearchSurvey(String keyword, FilterVO filter) {
        return surveyDao.getCntSearchSurvey(keyword, filter);
    }

    @Override
    public int getCntSearchQuestion(String keyword, FilterVO filter) {
        return surveyDao.getCntSearchQuestion(keyword, filter);
    }

    @Override
    public List<SurveyDto> searchSurvey(String keyword, FilterVO filter, PagingVO paging) {
        return surveyDao.searchSurvey(keyword, filter, paging);
    }

    @Override
    public List<SurveyDto> searchQuestion(String keyword, FilterVO filter, PagingVO paging) {
        return surveyDao.searchQuestion(keyword, filter, paging);
    }
}
