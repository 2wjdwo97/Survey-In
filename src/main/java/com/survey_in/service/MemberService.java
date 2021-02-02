package com.survey_in.service;

import java.sql.SQLException;

public interface MemberService {
    Boolean signIn(String id, String pw) throws ClassNotFoundException, SQLException;
    void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender, String job)
            throws ClassNotFoundException, SQLException;
}
