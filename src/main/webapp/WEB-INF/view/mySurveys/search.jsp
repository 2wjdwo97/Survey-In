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
        <h2 class="heading underline">Search Results for "<strong>${keyword}</strong>"</h2>
    </div>
    <!-- ################################################################################################ -->
    <div id="search-filter">
        <form action="/search" method="get">
            <ul class="filter-type-container">
                <li class="filter-box">
                    <select class="select-dropdown" name="target">
                        <option value="survey">Search for survey</option>
                        <option value="question">Search for question</option>
                    </select>
                </li>
                <li>
                    <select class="select-dropdown" name="category">
                        <option value="all">All categories</option>
                        <option value="life">Lifestyle</option>
                        <option value="food">Food</option>
                        <option value="machine">Machine</option>
                        <option value="mobile">Mobile</option>
                    </select>
                </li>
                <li class="filter-box">
                    <select class="select-dropdown" name="age">
                        <option value="all">All ages</option>
                        <option value="lt10">Less than 10</option>
                        <option value="10">10s</option>
                        <option value="20">20s</option>
                        <option value="30">30s</option>
                        <option value="40">40s</option>
                        <option value="50">50s</option>
                        <option value="mt60">More than 60</option>
                    </select>
                </li>
                <%--            <li class="filter-box">--%>
                <%--                <select class="select-dropdown" name="gender">--%>
                <%--                    <option value="all">gender</option>--%>
                <%--                    <option value="m">male</option>--%>
                <%--                    <option value="f">female</option>--%>
                <%--                </select>--%>
                <%--            </li>--%>
                <li>
                    <input class="search-btn" type="submit" value="search">
                </li>
            </ul>
        </form>
    </div>
    <!-- ################################################################################################ -->
    <div id="search-list">
        <ul>
            <c:forEach var="s" items="${surveys}" varStatus="status">
                <li>
                    <article>
                        <div class="survey-header">
                            <h3><a href="#">${s.title}</a></h3>
                            <h4>?/${s.capacity}</h4>
                        </div>
                        <div class="survey-body">
                            <p>
                                <a href="#">(desc of the survey)</a>
                            </p>
                        </div>
                        <div class="survey-footer">
                            <time>${s.createdAt}</time>
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
                    <c:when test="${startNum+i == page}">
                        <li class="current"><strong>${startNum+i}</strong></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="?p=${startNum+i}">${startNum+i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <li><a href="#">Next &raquo;</a></li>
        </ul>
    </nav>
    <!-- ################################################################################################ -->
</div>
</body>