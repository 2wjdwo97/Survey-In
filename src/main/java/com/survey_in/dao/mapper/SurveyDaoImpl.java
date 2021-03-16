package com.survey_in.dao.mapper;

import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.Survey;
import com.survey_in.vo.FilterVO;
import com.survey_in.vo.PageVO;
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
    public List<Survey> getAllSurveys() {
        return sqlSession.selectList("SurveyMapper.getSurveys");
    }

    @Override
    public void insertSurvey(Survey survey) {
        sqlSession.insert("SurveyMapper.insertSurvey", survey);
    }

    @Override
    public Survey selectSurvey(int survey_id) {
        return sqlSession.selectOne("SurveyMapper.selectSurvey", survey_id);
    }

    @Override
    public void deleteSurvey(int survey_id) {
        sqlSession.delete("SurveyMapper.deleteSurvey", survey_id);
    }

    @Override
    public List<Survey> selectMemberSurveys(int member_id) {
        return sqlSession.selectList("SurveyMapper.selectMemberSurveys", member_id);
    }

    public SurveyDto testJoin(int survey_id){
        return sqlSession.selectOne("SurveyMapper.testJoin", survey_id);
    }

    // search //
    @Override
    public int getCntSearchSurvey(String keyword, FilterVO filter) {
        return sqlSession.selectOne("SurveyMapper.getCntSearchSurvey", getMapParam(keyword, filter));
    }

    @Override
    public int getCntSearchQuestion(String keyword, FilterVO filter) {
        return sqlSession.selectOne("SurveyMapper.getCntSearchQuestion", getMapParam(keyword, filter));
    }

    @Override
    public List<SurveyDto> searchSurvey(String keyword, FilterVO filter, PagingVO paging) {
        return sqlSession.selectList("SurveyMapper.searchSurvey", getMapParam(keyword, filter, paging));
    }

    @Override
    public List<SurveyDto> searchQuestion(String keyword, FilterVO filter, PagingVO paging) {
        return sqlSession.selectList("SurveyMapper.searchQuestion", getMapParam(keyword, filter, paging));
    }

    @Override
    public List<SurveyDto> getSurveyByDate(int searchnum) {
        FilterVO f = new FilterVO();
        PagingVO p = new PagingVO(new PageVO(), 2);
        f.setOrd("latest");
        return sqlSession.selectList("SurveyMapper.getLatest", getMapParam(f, p));
    }

    @Override
    public List<SurveyDto> getSurveyByPoints(int searchnum) {
        FilterVO f = new FilterVO();
        PagingVO p = new PagingVO(new PageVO(), 2);
        f.setOrd("point");
        return sqlSession.selectList("SurveyMapper.getByPoints", getMapParam(f, p));
    public void addParticipant(int surveyId){
        sqlSession.update("SurveyMapper.addParticipant", surveyId);
    }

    Map<String, Object> getMapParam(String keyword, FilterVO filter){
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", keyword);
        param.put("filter", filter);
        return param;
    }
    Map<String, Object> getMapParam(FilterVO filter, PagingVO paging){
        Map<String, Object> param = new HashMap<>();
        param.put("filter", filter);
        param.put("paging", paging);
        return param;
    }
    Map<String, Object> getMapParam(String keyword, FilterVO filter, PagingVO paging){
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", keyword);
        param.put("filter", filter);
        param.put("paging", paging);
        return param;
    }

}
