package com.survey_in.service;

import com.survey_in.controller.SecretInfo;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class JDBCMemberService implements MemberService {
    public void signUp()  throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(SecretInfo.url(), SecretInfo.id(), SecretInfo.password());
        String sql = "SELECT ID, TITLE FROM NOTICE";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql); //결과집합 return

        while(rs.next()) {
            System.out.println(rs.getString("TITLE"));
        }
        //DB에 저장

//        private String username;
//        private String password;
//        private String password_confirm;
//        private String first_name;
//        private String last_name;
//        private String email;
//        private Date birthday;
//        private Boolean male;
    }

    @Override
    public void signIn(String id, String pw) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(SecretInfo.url(), SecretInfo.id(), SecretInfo.password());
        String sql = "SELECT ID FROM MEMBER WHERE ID='"+id+"' AND PWD='"+pw+"'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next())
            System.out.println("log in succeeded");
        else
            System.out.println("log in failed");

        rs.close();
        st.close();
        con.close();
    }
}
