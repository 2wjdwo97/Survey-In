package com.survey_in.ui;

import com.survey_in.entity.Exam;

public class totalPrintConsole implements PrintConsole{
    Exam exam;

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void printScreen() {
        System.out.println("total:" + exam.calcTotal());
    }
}
