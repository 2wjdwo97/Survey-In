<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-02-25
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="/css/style_answer.css" rel="stylesheet" type="text/css">
<link href="/css/framework.css" rel="stylesheet" type="text/css">

<div id="content-area" class="display-flex flex-content-center">
    <form method="post" id="content" class="position-relative">
        <div id="title-div">
            ${survey.title}
        </div>

        <c:forEach var="question" items="${survey.questions}" varStatus="st">
            <div class="question-div">
                <div class="question-title">
                        ${question.title}
                </div>

                <c:forEach var="option" items="${question.option}">
                    <label class="option-label">
                        <input class="radio" type="radio" name="answers[${st.index}].questionOptionId" value="${option.questionOptionId}"/>
                        ${option.data}</label><br/>
                </c:forEach>
            </div>
        </c:forEach>
        <button class="position-absolute">Submit</button>
    </form>
</div>
