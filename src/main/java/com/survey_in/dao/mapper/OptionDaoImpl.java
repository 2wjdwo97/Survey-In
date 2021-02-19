package com.survey_in.dao.mapper;

import com.survey_in.entity.Option;
import com.survey_in.entity.QuestionOption;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("optionDaoBean")
public class OptionDaoImpl implements OptionDao {
    private final SqlSession sqlSession;

    @Autowired
    public OptionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public void insertOption(Option option) {
        sqlSession.insert("OptionMapper.insert", option);
    }
}
