package com.survey_in.service;

import com.survey_in.dao.mapper.*;
import com.survey_in.dto.QuestionDto;
import com.survey_in.dto.OptionDto;
import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
    private SurveyDao surveyDao;
    private MemberDao memberDao;
    private QuestionDao questionDao;
    private OptionDao optionDao;
    private QuestionOptionDao questionOptionDao;

    @Autowired
    public SurveyServiceImpl(@Qualifier("surveyDaoBean") SurveyDao surveyDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("questionDaoBean") QuestionDao questionDao,
                             @Qualifier("optionDaoBean") OptionDao optionDao,
                             @Qualifier("questionOptionDaoBean") QuestionOptionDao questionOptionDao){
        this.surveyDao = surveyDao;
        this.memberDao = memberDao;
        this.questionDao = questionDao;
        this.optionDao = optionDao;
        this.questionOptionDao = questionOptionDao;
    }

    public void createSurvey(String username, String title, int capacity, String category, int point, List<QuestionDto> questions){
        int memberId = memberDao.selectMemberId(username);

        Survey newSurvey = new Survey(memberId, title, category, capacity, point, questions.size());
        surveyDao.insertSurvey(newSurvey);
        int lastSurveyId = newSurvey.getId();


        for(QuestionDto question: questions){
            Question newQuestion = new Question(lastSurveyId, question.getTitle());
            questionDao.insertQuestion(newQuestion);
            int lastQuestionId = newQuestion.getId();

            for(OptionDto option: question.getOption()) {
                Option newOption = new Option(option.getData());
                optionDao.insertOption(newOption);
                int lastOptionId = newOption.getId();

                QuestionOption newQuestionOption = new QuestionOption(lastQuestionId, lastOptionId);
                questionOptionDao.insertQuestionOption(newQuestionOption);
            }
        }
    }

    public List<Survey> getMemberSurveys(String username) {
        int memberId = memberDao.selectMemberId(username);
        return surveyDao.selectMemberSurveys(memberId);
    }

    public SurveyDto getSurveyDetail(int id) {
        Survey survey = surveyDao.selectSurvey(id);
        List<Question> questionEntities = questionDao.selectQuestions(survey.getId());
        List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();

        for(Question questionEntity: questionEntities){
            List<Option> optionEntities = optionDao.selectOptions(questionEntity.getId());
            questionDtos.add(QuestionDto.of(questionEntity, OptionDto.of(optionEntities)));
        }

        SurveyDto surveyDto = SurveyDto.of(survey, questionDtos);
        return surveyDto;
    }
}