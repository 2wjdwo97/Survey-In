package com.survey_in.service;

import com.survey_in.dao.mapper.AnswerDao;
import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.dao.mapper.SurveyDao;
import com.survey_in.dto.AnswerDto;
import com.survey_in.entity.Answer;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("answerServiceBean")
public class AnswerServiceImpl implements AnswerService{
    private AnswerDao answerDao;
    private MemberDao memberDao;
    private SurveyDao surveyDao;

    @Autowired
    public AnswerServiceImpl(@Qualifier("answerDaoBean") AnswerDao answerDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("surveyDaoBean") SurveyDao surveyDao){
        this.answerDao = answerDao;
        this.memberDao = memberDao;
        this.surveyDao = surveyDao;
    }

    public void createAnswer(List<AnswerDto> answerDtoList, String username, int surveyId) {
        int memberId = memberDao.selectMemberId(username);
        int point = surveyDao.testJoin(surveyId).getPoint();

        surveyDao.addParticipant(surveyId);

        Map<String, Object> info = new HashMap<String, Object>();
        info.put("to", username);
        info.put("point", point);
        memberDao.addPoint(info);

        for(AnswerDto answerDto: answerDtoList) {
            answerDao.createAnswer(Answer.of(answerDto, memberId));
        }
    }

}
