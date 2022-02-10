package com.survey_in.service;

import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.dto.MemberDto;
import com.survey_in.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service("memberServiceBean")
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("encoder") BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.memberDao = memberDao;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }


    public void signUp(String id, String pw, String fname, String lname, String email, String birthday, String gender, String job) {
        Calendar cal = Calendar.getInstance();
        int age = cal.get(Calendar.YEAR) - Integer.parseInt(birthday.split("-")[0]) + 1;

        Member member = new Member(id, bcryptPasswordEncoder.encode(pw), fname + lname, gender, age, birthday, email, job);
        memberDao.insertMember(member);
    }

    public MemberDto getMember(String username) {
        Member memberEntity = memberDao.selectMember(username);
        if (memberEntity == null)
            return null;

        return MemberDto.of(memberEntity);
    }

    @Override
    public MemberDto getMemberBySurvey(int id) {
        Member memberEntity = memberDao.selectMemberBySurvey(id);
        if (memberEntity == null)
            return null;

        return MemberDto.of(memberEntity);
    }

    public Boolean checkAttendance(String username, int survey_id) {
        int member_id = memberDao.selectMemberId(username);
        Map<String, Integer> info = new HashMap<>();
        info.put("member_id", member_id);
        info.put("survey_id", survey_id);
        return memberDao.countMember(info) == 0;
    }

    public int getPoint(String username) {
        return memberDao.getPoint(username);
    }

    public void givePoint(String from, String to, int point) {
        Map<String, Object> info = new HashMap<>();
        info.put("from", from);
        info.put("to", to);
        info.put("point", point);

        memberDao.subPoint(info);
        memberDao.addPoint(info);
    }

}
