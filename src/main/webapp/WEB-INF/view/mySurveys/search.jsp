<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: KYEONGMIN PARK
  Date: 2021-02-14
  Time: AM 2:09
  To change this template use File | Settings | File Templates.
--%>

<head>
    <link href="/css/style_search.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="search" class="content-box">
    <!-- ################################################################################################ -->
    <div id="search-title">
        <h2 class="heading underline">Search Results for "<strong>멋쟁이 진원</strong>"</h2>
    </div>
    <!-- ################################################################################################ -->
    <div id="search-filter">
        <ul class="filter-type-container">
            <li class="filter-box">
                <select class="select-dropdown">
                    <option>search for survey</option>
                    <option>search for question</option>
                </select>
            </li>
            <li class="filter-box">
                <select class="select-dropdown">
                    <option>ages</option>
                    <option>less than 10</option>
                    <option>10s</option>
                    <option>20s</option>
                    <option>30s</option>
                    <option>40s</option>
                    <option>50s</option>
                    <option>more than 60</option>
                </select>
            </li>
            <li class="filter-box">
                <select class="select-dropdown">
                    <option>gender</option>
                    <option>male</option>
                    <option>female</option>
                </select>
            </li>
        </ul>
    </div>
    <!-- ################################################################################################ -->
    <div id="search-list">
        <ul>
            <c:forEach var="i" begin="1" end="5">
                <li>
                    <article>
                        <div class="survey-header">
                            <h3><a href="#">Whether to attend the ceremony</a></h3>
                            <h4>4/10</h4>
                        </div>
                        <div class="survey-body">
                            <p class="comcont">
                                <a href="#">
                                    1. Can you attend the ceremony? T/F<br/>
                                    2. How did you get to know this event?
                                </a>
                            </p>
                        </div>
                        <div class="survey-footer">
                            <date datetime="2021-02-13">2021-02-13</date>
                        </div>
                    </article>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!-- ################################################################################################ -->
    <nav class="pagination">
        <ul>
            <li><a href="#">&laquo; Previous</a></li>
            <c:set var="page" value="${(param.page==null)? 1: param.page}"/>
            <c:set var="startNum" value="${page-(page-1)%5}"/>
            <c:forEach var="i" begin="0" end="4">
                <c:choose>
                    <c:when test="${i == 2}">
                        <li class="current"><strong>${startNum+i}</strong></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="?page=${startNum+i}">${startNum+i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <li><a href="#">Next &raquo;</a></li>
        </ul>
    </nav>
    <!-- ################################################################################################ -->
</div>
</body>