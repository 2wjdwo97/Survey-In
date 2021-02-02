package com.survey_in.service;

import java.sql.SQLException;

public interface MemberService {
    int signIn(String id, String pw) throws ClassNotFoundException, SQLException;
    void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender)
            throws ClassNotFoundException, SQLException;
}
