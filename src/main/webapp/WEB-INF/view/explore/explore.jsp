<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xmapple
  Date: 2021/02/13
  Time: 11:10 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
<div class="explore_main-container">
    <div class="explore_head-box">
        <h1> Survey In Hottest! </h1>
        <hr>
    </div>
    <div class="filter-type-container">
        <span>
            <h2>
                Trending
            </h2>
        </span>
    </div>

<%--    -----------   content --%>
    <div class="content-box">
        <div class="ad-view-extra">
            광고주 구합니다
        </div>
            <c:forEach var="asurvey" items="${surveys}">
<%--                will fix route later !!! --%>
                <div class="survey-view display-inline-block" onclick="location.href='mySurveys/surveys/${asurvey.id}';">
                    <div class="survey-main-info">
                        <div class="survey-title-participate-container">
                            <div class="survey-name">
                                <strong id="survey-title-id">
                                    <h3>
                                        ${asurvey.title}
                                    </h3>
                                </strong>
                            </div>
                            <div class="survey-participate">
                                <strong id="survey-part-id">
                                    <h3>
                                        ${asurvey.capacity}
                                    </h3>
                                </strong>
                            </div>
                        </div>
                        <div class="survey-point-block">
                            <strong class="survey-point-inline">
                                <h3>
                                    ${asurvey.point} points
                                </h3>
                            </strong>
                        </div>
                    </div>
                    <div class="survey-description-block">
                        <span>
                            <p>
                                카테고리 : ${asurvey.category} <br>
                                문제수 : ${asurvey.questionCnt} <br>
                                나이제한 : ${asurvey.ageLimit}
                            </p>
                        </span>
                    </div>
                    <div class="info-tip">

                    </div>
                </div>

            </c:forEach>

    </div>


    <script type="text/javascript" src="/js/exploreJs.js"></script>
    <script>
        function togglePointSort() {
            let sortbutton = document.getElementById("sortToggle");



        }

    </script>
</div>


