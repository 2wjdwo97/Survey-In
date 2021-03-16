package com.survey_in.service;

import com.survey_in.dto.QuestionDto;

public interface QuestionService {
    QuestionDto getQuestionDetail(int questionId);
}
