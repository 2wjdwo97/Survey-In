package com.survey_in.dao.mapper;

import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PagingVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("surveyDaoBean")
public class SurveyDaoImpl implements SurveyDao{

    private final SqlSession sqlSession;

    @Autowired
    public SurveyDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Survey> getSurveys() {
        return sqlSession.selectList("SurveyMapper.getSurveys");
    }

    @Override
    public void insertSurvey(Survey survey) {
        sqlSession.insert("SurveyMapper.insertSurvey", survey);
    }

    @Override
    public Survey selectSurvey(String survey_id) {
        return sqlSession.selectOne("SurveyMapper.selectSurvey", survey_id);
    }

    @Override
    public void deleteSurvey(String survey_id) {
        sqlSession.delete("MemberMapper.deleteMember", survey_id);
    }

    @Override
    public List<Survey> selectMemberSurveys(int member_id) {
        return sqlSession.selectList("SurveyMapper.selectMemberSurveys", member_id);
    }

    // search
    @Override
    public int getCntSearchSurvey(String keyword, FilterVO filter) {
        Map<String, Object> param = new HashMap<>();

        param.put("keyword", keyword);
        param.put("filter", filter);

        return sqlSession.selectOne("SurveyMapper.getCntSearchSurvey", param);
    }

    @Override
    public List<Survey> searchSurvey(String keyword, FilterVO filter, PagingVO paging) {
        Map<String, Object> param = new HashMap<>();

        param.put("keyword", keyword);
        param.put("filter", filter);
        param.put("paging", paging);

        return sqlSession.selectList("SurveyMapper.searchSurvey", param);
    }
}
