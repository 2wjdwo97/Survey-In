package com.survey_in.service;

import com.survey_in.controller.SecretInfo;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class JDBCMemberService implements MemberService {
    @Override
    public Boolean signIn(String id, String pw) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(SecretInfo.url(), SecretInfo.id(), SecretInfo.password());
        String sql = "SELECT ID FROM MEMBER WHERE ID='" + id + "' AND PWD='" + pw + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            rs.close();
            st.close();
            con.close();
            return true;
        } else {
            rs.close();
            st.close();
            con.close();
            return false;
        }
    }
    public void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender, String job)
            throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(SecretInfo.url(), SecretInfo.id(), SecretInfo.password());

        String sqlCreate = "INSERT INTO MEMBER(" +
                "ID," +
                "PWD," +
                "NAME," +
                "GENDER," +
                "BIRTHDAY," +
                "EMAIL," +
                "JOB" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sqlCreate);

        String name = fn + ln;

        pst.setString(1, id);
        pst.setString(2, pw);
        pst.setString(3, name);
        pst.setString(4, gender);
        pst.setString(5, bd);
        pst.setString(6, email);
        pst.setString(7, job);
        int a = pst.executeUpdate(); //몇개의 row 영향을 받았는지 return

        pst.close();
    }
}
