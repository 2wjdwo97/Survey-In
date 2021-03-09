package com.survey_in.dao.mapper;

import com.survey_in.dto.QuestionDto;
import com.survey_in.entity.Question;

import java.util.List;

public interface QuestionDao {
    void insertQuestion(Question question);
    QuestionDto select(int questionId);
}
