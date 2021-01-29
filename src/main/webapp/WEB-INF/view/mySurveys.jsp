<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-29
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/style_mySurveys.css?ba" rel="stylesheet" type="text/css">
    <title>Survey In</title>
</head>
<header>
    <div>
        <a href="/mySurveys">
            <img src="/images/logo_dark.png"
                 width="45" height="45">
        </a>
        <div class="vertical-center search-wrapper display-inline">
            <form class="display-inline" action="/search">
                <input class="search-input" type="text" name="q"/>
                <input class="search-button position-absolute" type="image" src="/images/1.JPG" alt="Submit" />
            </form>
        </div>
        <form class="vertical-center display-inline position-absolute sign-out-form" action="/logout">
            <input class="sign-out-input" type="submit" value="sign out"/>
        </form>
    </div>
</header>
<aside>
    <div>
        2wjdwo97
    </div>
    <div>
        My surveys
    </div>
    <div>
        New survey
    </div>
    <div>
        Take a survey
    </div>
    <div>
        Edit Account
    </div>
</aside>
<body>
</body>
</html>
