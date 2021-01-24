package com.survey_in;

import com.survey_in.entity.Exam;
import com.survey_in.entity.WebExam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.survey_in.ui")
@Configuration
public class SurveyInConfig
{
    @Bean
    public Exam exam(){
        return new WebExam();
    }
}
