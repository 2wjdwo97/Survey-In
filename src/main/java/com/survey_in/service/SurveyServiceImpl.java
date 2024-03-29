package com.survey_in.service;

import com.survey_in.dao.mapper.*;
import com.survey_in.dto.QuestionDto;
import com.survey_in.dto.OptionDto;
import com.survey_in.dto.SurveyDto;
import com.survey_in.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
    private SurveyDao surveyDao;
    private MemberDao memberDao;
    private QuestionDao questionDao;
    private OptionDao optionDao;
    private QuestionOptionDao questionOptionDao;
    private AnswerDao answerDao;

    @Autowired
    public SurveyServiceImpl(@Qualifier("surveyDaoBean") SurveyDao surveyDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("questionDaoBean") QuestionDao questionDao,
                             @Qualifier("optionDaoBean") OptionDao optionDao,
                             @Qualifier("questionOptionDaoBean") QuestionOptionDao questionOptionDao,
                             @Qualifier("answerDaoBean") AnswerDao answerDao){
        this.surveyDao = surveyDao;
        this.memberDao = memberDao;
        this.questionDao = questionDao;
        this.optionDao = optionDao;
        this.questionOptionDao = questionOptionDao;
        this.answerDao = answerDao;
    }

    @Override
    public void createSurvey(String username, String title, int capacity, String category, int point, String gender_limit, String age_limit, List<QuestionDto> questions) {
        int memberId = memberDao.selectMemberId(username);

        Map<String, Object> info = new HashMap<String, Object>();
        info.put("from", username);
        info.put("point", point * capacity);
        memberDao.subPoint(info);

        Survey newSurvey = new Survey(memberId, title, category, capacity, point,
                questions.size(), age_limit, gender_limit);
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

    @Override
    public void deleteSurvey(int id) {
        surveyDao.deleteSurvey(id);
    }

    public List<Survey> getMemberSurveys(String username) {
        int memberId = memberDao.selectMemberId(username);
        return surveyDao.selectMemberSurveys(memberId);
    }

    public SurveyDto getSurveyDetail(int id) {
        return surveyDao.testJoin(id);
    }

    public boolean checkCapacity(int surveyId) {
        Survey survey = surveyDao.selectSurvey(surveyId);
        return survey.getParticipant() < survey.getCapacity();
    }
}