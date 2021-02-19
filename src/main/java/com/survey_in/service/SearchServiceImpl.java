package com.survey_in.service;

import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.entity.Question;
import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
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
    public List<Survey> searchSurvey(String keyword, FilterVO filter) {
        return surveyDao.searchSurvey(keyword, filter);
    }

    @Override
    public List<Survey> searchQuestion() {
        return null;
    }
}
