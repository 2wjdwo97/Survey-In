package com.survey_in.entity;


import org.springframework.beans.factory.annotation.Value;

public class WebExam implements Exam{
    @Value("20")
    private float servlet;
    @Value("13.2")
    private float jsp;
    @Value("2.4")
    private float maven;
    @Value("80.5")
    private float spring;

    public WebExam(){
    }

    public WebExam(float servlet, float jsp, float maven, float spring){
        this.servlet = servlet;
        this.jsp = jsp;
        this.maven = maven;
        this.spring = spring;
    }

    @Override
    public void setScore() {
        servlet = 3.4f;
        jsp = 2.6f;
        maven = 5f;
        spring = 2.1f;
    }

    public float calcTotal() {
        return servlet + jsp + maven + spring;
    }

    public float calcAvg() {
        return calcTotal()/4;
    }

}
