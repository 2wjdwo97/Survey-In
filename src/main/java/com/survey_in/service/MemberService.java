package com.survey_in.service;

import com.survey_in.entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberService {
    List<Member> signIn() throws ClassNotFoundException, SQLException;
    void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender, String job)
            throws ClassNotFoundException, SQLException;
}