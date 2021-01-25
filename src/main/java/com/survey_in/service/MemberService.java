package com.survey_in.service;

import java.sql.SQLException;

public interface MemberService {
    void signUp() throws ClassNotFoundException, SQLException;
    Boolean signIn(String id, String pw) throws ClassNotFoundException, SQLException;
}
