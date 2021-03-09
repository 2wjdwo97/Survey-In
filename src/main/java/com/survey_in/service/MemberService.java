package com.survey_in.service;

import com.survey_in.dto.MemberDto;
import com.survey_in.entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberService {
    void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender, String job)
            throws ClassNotFoundException, SQLException;
    Boolean checkAttendance(String username, int surveyId);
    MemberDto getMember(String username);
    int getPoint(String username);
    void givePoint(String from, String to, int point);
}