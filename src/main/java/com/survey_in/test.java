package com.survey_in;

import com.survey_in.entity.Exam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        이 내용을 spring에게 만들어달라고 요청
//        Exam exam = new WebExam(1,2,3,4);
//        PrintConsole console = new totalPrintConsole();
//        PrintConsole console = new avgPrintConsole();
//        console.setExam(exam);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("setting.xml");
//                new AnnotationConfigApplicationContext("com.survey_in");


//      request.getRequestDispatcher("test.jsp").forward(request, response);
        Exam exam = (Exam)context.getBean("exam");
        System.out.println(exam.calcTotal());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
