<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-29
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <link href="/css/style_mySurveys.css?ba" rel="stylesheet" type="text/css">
    <title><tiles:getAsString name="title" /></title>
</head>
<body>
    <%--header--%>
    <tiles:insertAttribute name="header"/>
    <div class="flex-wrapper display-flex" style="min-height: 100vh;">
        <%--aside--%>
        <tiles:insertAttribute name="aside"/>
        <%--main--%>
        <tiles:insertAttribute name="body"/>
    </div>

    <script type="text/javascript" src="/js/asideJs.js"></script>
</body>
</html>
