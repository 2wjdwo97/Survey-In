package com.survey_in.dao.mapper;

import com.survey_in.entity.Answer;

import java.util.List;

public interface AnswerDao {
    List<Answer> selectAnswers(int option_id);
}
