package com.survey_in.service;

import com.survey_in.dao.mapper.MemberDao;
import com.survey_in.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@Service("serviceBean")
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("encoder") BCryptPasswordEncoder bcryptPasswordEncoder){
        this.memberDao = memberDao;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    public List<Member> signIn() throws ClassNotFoundException, SQLException {
        return memberDao.getMembers();
    }
    public void signUp(String id, String pw, String fname, String lname, String email, String birthday, String gender, String job) {
        Calendar cal = Calendar.getInstance();
        int age = cal.get(Calendar.YEAR) - Integer.parseInt(birthday.split("-")[0]) + 1;

        Member member = new Member(id, bcryptPasswordEncoder.encode(pw), fname + lname, gender, age, birthday, email, job);
        memberDao.insertMember(member);
    }
}
