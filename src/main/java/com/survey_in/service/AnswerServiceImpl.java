package com.survey_in.service;

import com.survey_in.dao.mapper.AnswerDao;
import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.dto.AnswerDto;
import com.survey_in.entity.Answer;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("answerServiceBean")
public class AnswerServiceImpl implements AnswerService{
    private AnswerDao answerDao;
    private MemberDao memberDao;

    @Autowired
    public AnswerServiceImpl(@Qualifier("answerDaoBean") AnswerDao answerDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao){
        this.answerDao = answerDao;
        this.memberDao = memberDao;
    }

    public void createAnswer(List<AnswerDto> answerDtoList, String username) {
        int memberId = memberDao.selectMemberId(username);

        for(AnswerDto answerDto: answerDtoList) {
            answerDao.createAnswer(Answer.of(answerDto, memberId));
        }
    }

}
