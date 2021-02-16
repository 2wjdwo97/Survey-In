<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-02-16
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/style_detail.css" rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">



${survey.title}
<c:forEach var="question" items="${survey.questions}">
    [Question]<br/>
    ${question.title}<br/>
    [Options]<br/>
    <c:forEach var="option" items="${question.option}">
        ${option.data}<br/>
    </c:forEach>
    <br/>
</c:forEach>