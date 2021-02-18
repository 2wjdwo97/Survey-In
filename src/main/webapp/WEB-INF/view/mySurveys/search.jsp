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
            <input type="hidden" id="search-hidden-input" name="q" value=${keyword}>
            <ul class="filter-type-container">
                <li class="filter-box">
                    <select class="select-dropdown" id="filter-target" name="tar">
                        <option value="survey" <c:if test="${filter.tar == 'survey'}">selected="selected"</c:if>>Search for survey</option>
                        <option value="question" <c:if test="${filter.tar == 'question'}">selected="selected"</c:if>>Search for question</option>
                    </select>
                </li>
                <li>
                    <select class="select-dropdown" id="filter-category" name="cat">
                        <option value="all" <c:if test="${filter.cat == 'all'}">selected="selected"</c:if>>All categories</option>
                        <option value="life" <c:if test="${filter.cat == 'life'}">selected="selected"</c:if>>Lifestyle</option>
                        <option value="food" <c:if test="${filter.cat == 'food'}">selected="selected"</c:if>>Food</option>
                        <option value="machine" <c:if test="${filter.cat == 'machine'}">selected="selected"</c:if>>Machine</option>
                        <option value="mobile" <c:if test="${filter.cat == 'mobile'}">selected="selected"</c:if>>Mobile</option>
                    </select>
                </li>
                <li class="filter-box">
                    <select class="select-dropdown" id="filter-age" name="age">
                        <option value="all" <c:if test="${filter.age == 'all'}">selected="selected"</c:if>>All ages</option>
                        <option value="lt10" <c:if test="${filter.age == 'lt10'}">selected="selected"</c:if>>Less than 10</option>
                        <option value="10s" <c:if test="${filter.age == '10s'}">selected="selected"</c:if>>10s</option>
                        <option value="20s" <c:if test="${filter.age == '20s'}">selected="selected"</c:if>>20s</option>
                        <option value="30s" <c:if test="${filter.age == '30s'}">selected="selected"</c:if>>30s</option>
                        <option value="40s" <c:if test="${filter.age == '40s'}">selected="selected"</c:if>>40s</option>
                        <option value="50s" <c:if test="${filter.age == '50s'}">selected="selected"</c:if>>50s</option>
                        <option value="mt60" <c:if test="${filter.age == 'mt60'}">selected="selected"</c:if>>More than 60</option>
                    </select>
                </li>
                <%--            <li class="filter-box">--%>
                <%--                <select class="select-dropdown" id="gender" name="gender">--%>
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
                            <h4>(참여인원)/${s.capacity}</h4>
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
            <li <c:if test="${paging.prev eq false}">class="hidden"</c:if>><a href="#">&laquo; Previous</a></li>

            <c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
                <c:choose>
                    <c:when test="${i == paging.pagevo.page}">
                        <li class="current"><strong>${i}</strong></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="?page=${i}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <li <c:if test="${paging.next eq false}">class="hidden"</c:if>><a href="#">Next &raquo;</a></li>
        </ul>
    </nav>
    <!-- ################################################################################################ -->
</div>
<script type="text/javascript" src="/js/searchJs.js"></script>
</body>