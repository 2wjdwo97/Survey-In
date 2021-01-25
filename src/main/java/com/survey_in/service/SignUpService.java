package com.survey_in.service;

import com.survey_in.controller.SecretInfo;
import com.survey_in.entity.SignUpInfo;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class SignUpService implements SignUpServ{
    public SignUpInfo getSignUpInfo() {
        return signUpInfo;
    }

    public void setSignUpInfo(SignUpInfo signUpInfo) {
        this.signUpInfo = signUpInfo;
    }

    public SignUpService(){
        signUpInfo = new SignUpInfo();
    }

    private SignUpInfo signUpInfo;

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
