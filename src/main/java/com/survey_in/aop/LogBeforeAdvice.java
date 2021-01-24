package com.survey_in.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before 실행");
    }
}
