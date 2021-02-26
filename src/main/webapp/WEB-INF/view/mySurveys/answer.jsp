<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-02-25
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <form method="post">
        ${survey.title}<br/>

        <c:forEach var="question" items="${survey.questions}" varStatus="st">
            ${question.title}<br/>
            <c:forEach var="option" items="${question.option}">
                <label>
                    <input class="radio" type="radio" name="answers[${st.index}].questionOptionId" value="${option.questionOptionId}"/>
                    ${option.data}</label><br/>
            </c:forEach>
        </c:forEach>

        <button>Submit</button>
    </form>
</div>
