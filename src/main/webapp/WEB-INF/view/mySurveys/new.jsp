<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-31
  Time: 오전 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/css/style_create.css" rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

<form class="display-flex flex-auto content-box" method="post">
    <div class="query-area flex-auto">
        <div>
            <input class="title-input" type="text" placeholder="Title" name="title"/>
        </div>
<%--
        <div class="query-box position-relative">
            <input type="button" valaue="X" class="delete-query-button""/>
            <div class="query-form">
                <input type="text" placeholder="Question" class="query-title-input"/>
            </div>
            <input type="button" value="+"/>
        </div>
--%>
    </div>

    <div class="floating-area flex-auto">
        <div class="floating-box">
            <div>
                <label>Points:
                    <input type="text" name="point"/>
                </label>
            </div>
            <div>
                <label>Capacity:
                    <input type="text" name="capacity"/>
                </label>
            </div>
            <div>
                <label for="category">Category:</label>
                <select name="category" id="category">
                    <option value="life">Life Style</option>
                    <option value="food">Food</option>
                    <option value="machine">Machine</option>
                    <option value="mobile">Mobile</option>
                </select>
            </div>
            <div>
                Options:
            </div>
            <div>
                <label>
                    <input class="radio" type="radio" name="option" checked=true value="all"/>
                    All</label>
                <label>
                    <input class="radio" type="radio" name="option" value="men"/>
                    Men Only</label>
                <label>
                    <input class="radio" type="radio" name="option" value="women"/>
                    Women Only</label>
            </div>
            <div>
                <button id="create-button" title="Add question" type="button"></button>
                <input type="submit" value="Create" />
            </div>
        </div>
    </div>
</form>

<script type="text/javascript" src="/js/createJs.js"></script>
