<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: KYEONGMIN PARK
  Date: 2021-02-14
  Time: AM 2:09
  To change this template use File | Settings | File Templates.
--%>

<link href="/css/style_search.css" rel="stylesheet" type="text/css">
<link href="/css/framework.css" rel="stylesheet" type="text/css">


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
                        <option value="survey" <c:if test="${filter.tar == 'survey'}">selected="selected"</c:if>>Search
                            for survey
                        </option>
                        <option value="question" <c:if test="${filter.tar == 'question'}">selected="selected"</c:if>>
                            Search for question
                        </option>
                    </select>
                </li>
                <li class="filter-box">
                    <select class="select-dropdown" id="filter-order" name="ord">
                        <%--                        <option value="default" <c:if test="${filter.ord == 'default'}">selected="selected"</c:if>>Default order</option>--%>
                        <option value="latest" <c:if test="${filter.ord == 'latest'}">selected="selected"</c:if>>Latest
                            order
                        </option>
                        <option value="point" <c:if test="${filter.ord == 'point'}">selected="selected"</c:if>>Point
                            order
                        </option>
                    </select>
                </li>
                <li class="filter-box">
                    <select class="select-dropdown" id="filter-category" name="cat">
                        <option value="all" <c:if test="${filter.cat == 'all'}">selected="selected"</c:if>>All
                            categories
                        </option>
                        <option value="life" <c:if test="${filter.cat == 'life'}">selected="selected"</c:if>>Lifestyle
                        </option>
                        <option value="food" <c:if test="${filter.cat == 'food'}">selected="selected"</c:if>>Food
                        </option>
                        <option value="machine" <c:if test="${filter.cat == 'machine'}">selected="selected"</c:if>>
                            Machine
                        </option>
                        <option value="mobile" <c:if test="${filter.cat == 'mobile'}">selected="selected"</c:if>>
                            Mobile
                        </option>
                    </select>
                </li>
                <li class="filter-box">
                    <select class="select-dropdown" id="filter-age" name="age">
                        <option value="all" <c:if test="${filter.age == 'all'}">selected="selected"</c:if>>All ages
                        </option>
                        <option value="lt10" <c:if test="${filter.age == 'lt10'}">selected="selected"</c:if>>Less than
                            10
                        </option>
                        <option value="10" <c:if test="${filter.age == '10'}">selected="selected"</c:if>>10s</option>
                        <option value="20" <c:if test="${filter.age == '20'}">selected="selected"</c:if>>20s</option>
                        <option value="30" <c:if test="${filter.age == '30'}">selected="selected"</c:if>>30s</option>
                        <option value="40" <c:if test="${filter.age == '40'}">selected="selected"</c:if>>40s</option>
                        <option value="50" <c:if test="${filter.age == '50'}">selected="selected"</c:if>>50s</option>
                        <option value="mt60" <c:if test="${filter.age == 'mt60'}">selected="selected"</c:if>>More than
                            60
                        </option>
                    </select>
                </li>
                <li class="filter-box">
                    <select class="select-dropdown" id="filter-gender" name="gen">
                        <option value="all" <c:if test="${filter.gen == 'all'}">selected="selected"</c:if>>gender
                        </option>
                        <option value="men" <c:if test="${filter.gen == 'men'}">selected="selected"</c:if>>men</option>
                        <option value="women" <c:if test="${filter.gen == 'women'}">selected="selected"</c:if>>women
                        </option>
                    </select>
                </li>
            </ul>
        </form>
    </div>
    <!-- ################################################################################################ -->
    <div id="search-list">
        <ul>
            <c:choose>
                <c:when test="${filter.tar == 'survey'}">
                    <c:forEach var="s" items="${surveys}" varStatus="status">
                        <li>
                            <article>
                                <div class="survey-header">
                                    <div class="survey-title">
                                        <h3><a href="#">${s.title}</a></h3>
                                        <h4>${s.participant}/${s.capacity}</h4>
                                    </div>
                                    <div class="survey-point">
                                        <h4>${s.point} POINT</h4>
                                    </div>
                                </div>
                                <div class="survey-body">
                                    <a href="#">
                                        <h5>header</h5>
                                        <p>content</p>
                                    </a>
                                </div>
                                <div class="survey-footer">
                                    <time>${s.createdAt}</time>
                                </div>
                            </article>
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach var="s" items="${surveys}">
                        <c:forEach var="q" items="${s.questions}">
                            <li>
                                <article>
                                    <div class="survey-header">
                                        <div class="survey-title">
                                            <h3><a href="javascript:void(0);">${s.title}</a></h3>
                                            <h4>(temp)/${s.capacity}</h4>
                                        </div>
                                        <div class="survey-point">
                                            <h4>${s.point} POINT</h4>
                                        </div>
                                    </div>
                                    <div class="survey-body">
                                        <a href="#">
                                            <h5>Q. ${q.title}</h5>
                                            <p>
                                                <c:forEach var="op" items="${q.option}" varStatus="st">
                                                    ${st.index+1}. ${op.data}<br/>
                                                </c:forEach>
                                            </p>
                                        </a>
                                    </div>
                                    <div class="survey-footer">
                                        <time>${s.createdAt}</time>
                                    </div>
                                </article>
                            </li>
                        </c:forEach>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <!-- ################################################################################################ -->
    <nav class="pagination">
        <ul>
            <li <c:if test="${paging.prev eq false}">class="hidden"</c:if>><a id="paging-prev">&laquo; Previous</a></li>

            <c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
                <c:choose>
                    <c:when test="${i == paging.page.page}">
                        <li><a id="paging-cur">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a class="paging-other">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <li <c:if test="${paging.next eq false}">class="hidden"</c:if>><a id="paging-next">Next &raquo;</a></li>
        </ul>
    </nav>
    <!-- ################################################################################################ -->
</div>
<script type="text/javascript" src="/js/searchJs.js"></script>
