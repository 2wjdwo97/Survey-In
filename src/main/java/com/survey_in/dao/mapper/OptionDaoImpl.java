package com.survey_in.dao.mapper;

import com.survey_in.entity.Option;
import com.survey_in.entity.Question;
import com.survey_in.entity.QuestionOption;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<Option> selectOptions(int question_id) {
        return sqlSession.selectList("OptionMapper.selectOption", question_id);
    }
}
