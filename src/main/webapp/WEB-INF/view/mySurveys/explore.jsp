<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xmapple
  Date: 2021/02/13
  Time: 11:10 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <link href="/css/style_explore.css" rel="stylesheet" type="text/css">
    <link href="/css/framework.css" rel="stylesheet" type="text/css">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
</head>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
<div class="explore_main-container">
    <div class="explore_head-box">
        <h1 class="font-x3"> Survey In Hottest! </h1>
    </div>
    <div class="filter-type-container">
        <span>
            <h2 class="font-x2">
                Explore New Surveys!
            </h2>
        </span>
    </div>

<%--    -----------   content --%>
    <div style="display: flex; flex-direction: column">
    <div class="content-box">
        <h2>
            Recents
        </h2>
        <hr>
        <c:forEach var="r" items="${recents}" varStatus="status">
            <div class="survey-view display-inline-block" onclick="location.href='mySurveys/surveys/${r.id}/answer';">
                <div class="survey-main-info">
                    <div class="survey-title-participate-container">
                        <div class="survey-name">
                            <strong id="recent-title-id">
                                ${r.title}
                            </strong>
                        </div>
                        <div class="survey-participate">
                            <strong id="recent-part-id">
                                ${r.capacity}
                            </strong>
                        </div>
                    </div>
                    <div class="survey-point-block">
                        <strong class="survey-point-inline">
                            ${r.point} points
                        </strong>
                    </div>
                </div>
                <div class="survey-description-block">
                    <span>
                        <p>
                            카테고리 : ${r.category} <br>
                            문제수 : ${r.questionCnt} <br>
                            나이제한 : ${r.ageLimit} <br>
                            참여인원 : ${r.participant}
                        </p>
                    </span>
                </div>
            </div>
        </c:forEach>
    </div>
    <br>
    <div class="content-box">
        <h2>
            Most Valuable
        </h2>
        <hr>
        <c:forEach var="p" items="${points}" varStatus="status">
            <div class="survey-view display-inline-block" onclick="location.href='mySurveys/surveys/${p.id}/answer';">
                <div class="survey-main-info">
                    <div class="survey-title-participate-container">
                        <div class="survey-name">
                            <strong id="survey-title-id">
                                    ${p.title}
                            </strong>
                        </div>
                        <div class="survey-participate">
                            <strong id="survey-part-id">
                                    ${p.capacity}
                            </strong>
                        </div>
                    </div>
                    <div class="survey-point-block">
                        <strong class="survey-point-inline">
                                ${p.point} points
                        </strong>
                    </div>
                </div>
                <div class="survey-description-block">
                    <span>
                        <p>
                            카테고리 : ${p.category} <br>
                            문제수 : ${p.questionCnt} <br>
                            나이제한 : ${p.ageLimit}
                        </p>
                    </span>
                </div>
                <div class="info-tip">
                </div>
            </div>
        </c:forEach>
    </div>
    </div>

<script type="text/javascript" src="/js/exploreJs.js"></script>
