package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;
import com.survey_in.entity.Survey;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return (Survey) sqlSession.selectOne("SurveyMapper.selectSurvey", survey_id);
    }

    @Override
    public void deleteSurvey(String survey_id) {
        sqlSession.delete("MemberMapper.deleteMember", survey_id);
    }

    public List<Survey> selectMemberSurveys(int member_id) {
        return sqlSession.selectList("SurveyMapper.selectMemberSurveys", member_id);
    }

}
