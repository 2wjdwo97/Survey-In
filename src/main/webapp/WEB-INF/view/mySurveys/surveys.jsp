<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-29
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="/css/framework.css" rel="stylesheet" type="text/css">
<link href="/css/style_surveys.css" rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

<div class="display-flex flex-wrapper content-box-list">
    <c:forEach var="item" items="${list}">
        <a href="${item.id}" class="survey-box position-relative">
            <div class="header position-relative">
                <div id="timeDiv"  class="position-absolute">
                    ${item.createdAt}
                </div>
                <div id="categoryDiv" class="position-absolute">
                    ${item.category}
                </div>
            </div>
            <div id="titleDiv">
                <span>${item.title}</span>
            </div>
            <div class="position-relative footer">
                <div id="pointDiv" class="position-absolute">
                    ${item.point} points
                </div>
                <div id="capacityDiv" class="position-absolute">
                    ${item.participant}/${item.capacity}
                </div>
            </div>
        </a>
        <form action="surveys/${item.id}" method="post" onsubmit="deleteSurvey(event)" class="<c:if test="${isMySurvey}">hidden</c:if>">
            <div>
                <input type="hidden" name="method" value="delete" />
                <button id="deleteBtn"><img src="/images/deleteBtn2.png"></button>
            </div>
        </form>
    </c:forEach>
</div>
<script type="text/javascript" src="/js/surveyJs.js"></script>
