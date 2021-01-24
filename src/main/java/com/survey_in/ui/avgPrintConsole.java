package com.survey_in.ui;

import com.survey_in.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("console")
public class avgPrintConsole implements PrintConsole{
    Exam exam;

    @Autowired
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void printScreen() {
        if (exam != null)
            System.out.println("avg: "+exam.calcAvg());
        else
            System.out.println("avg: 0");
    }
}
