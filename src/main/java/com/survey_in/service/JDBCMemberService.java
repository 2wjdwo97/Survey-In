package com.survey_in.service;

import com.survey_in.controller.SecretInfo;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class JDBCMemberService implements MemberService {
    @Override
    public int signIn(String id, String pw) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(SecretInfo.url(), SecretInfo.id(), SecretInfo.password());
        String sql = "SELECT USER_NO FROM MEMBER WHERE ID='" + id + "' AND PWD='" + pw + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int user_no;

        if (rs.next())
            user_no = rs.getInt("USER_NO");
        else
            user_no = -1;

        rs.close();
        st.close();
        con.close();

        return user_no;
    }
    public void signUp(String id, String pw, String fn, String ln, String email, String bd, String gender) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(SecretInfo.url(), SecretInfo.id(), SecretInfo.password());

        String sqlCreate = "INSERT INTO MEMBER(" +
                "ID," +
                "PWD," +
                "NAME," +
                "GENDER," +
                "BIRTHDAY," +
                "EMAIL" +
                ") VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sqlCreate);

        String name = fn + ln;

        pst.setString(1, id);
        pst.setString(2, pw);
        pst.setString(3, name);
        pst.setString(4, gender);
        pst.setString(5, bd);
        pst.setString(6, email);
        int a = pst.executeUpdate(); //몇개의 row 영향을 받았는지 return

        pst.close();
    }
}
