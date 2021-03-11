<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-31
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div class="display-flex flex-content-cross-center position-relative" style="height: 100%">
        <a href="/mySurveys">
            <img src="/images/logo_dark.png"
                 width="40" height="40">
        </a>

        <div class="search-wrapper">
            <form class="form-search-input display-inline" action="/search">
                <input class="search-input" type="text" name="q"
                <c:if test="${searchPar.keyword != null}">value=${searchPar.keyword}</c:if>/>
            </form>
        </div>

        <form class="position-absolute display-flex flex-content-cross-center sign-out-form" action="/logout" method="post">
            <input class="sign-out-input" type="submit" value="Sign Out"/>
        </form>
    </div>
</header>