<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-31
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div>
        <a href="/mySurveys">
            <img src="/images/logo_dark.png"
                 width="40" height="40">
        </a>
        <div class="vertical-center search-wrapper display-inline">
            <form class="display-inline" action="/search">
                <input class="search-input" type="text" name="q"/>
<%--                <input class="search-button position-absolute" type="image" src="/images/1.JPG" alt="Submit" />--%>
            </form>
        </div>
        <form class="vertical-center display-inline position-absolute sign-out-form" action="/logout" method="post">
            <input class="sign-out-input" type="submit" value="Sign Out"/>
        </form>
    </div>
</header>