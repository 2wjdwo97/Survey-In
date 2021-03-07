<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-18
  Time: 오후 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="/css/framework.css" rel="stylesheet" type="text/css">
    <link href="/css/style_login.css?a" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

    <title>Sign in to Survey In</title>
</head>
<body>
    <div class="position-relative logo-section">
        <a class='position-absolute logo' href="/index">
            <img src="/images/logo_light.png"
             width="70" height="70">
        </a>
    </div>
    <div class="position-relative login-section">
        <div>
            <h1>Sign in to Survey In</h1>
        </div>
        <form action="/login" class="position-relative login-form" method="post" onsubmit="return validateMyForm(event);">
            <label for="id-field">Username</label>
                <input id="id-field" type="text" name="id"/>
            <label for="pw-field">Password</label>
                <input id="pw-field" type="password" name="pw"/>
            <input class=position-relative id="submit-form" type="submit" value="Submit"/>
        </form>
    </div>
    <p class="position-relative button sign-up-section">
        New to Survey In?
        <a href="/join">Create an account.</a>
    </p>


    <script type="text/javascript" src="/js/loginJs.js?a"></script>
</body>
</html>
