package com.survey_in.service;

import com.survey_in.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    void createAnswer(List<AnswerDto> answerDtoList, String username, int surveyId);
}
