package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("surveyDaoBean")
public class SurveyDaoImpl implements SurveyDao {

    private final SqlSession sqlSession;

    @Autowired
    public SurveyDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Survey> searchSurvey(String keyword, String category, String age) {
        Map<String, Object> param = new HashMap<>();

        param.put("keyword", keyword);
        param.put("category", category);
        param.put("age", age);

        return sqlSession.selectList("SurveyMapper.searchSurvey", param);
    }
}
