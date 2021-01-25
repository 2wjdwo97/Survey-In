package com.survey_in.service;

import java.sql.SQLException;

public interface SignUpServ {
    void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender)
            throws ClassNotFoundException, SQLException;
}
