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

<div class="query-area flex-auto">
    <form method="post">
        <input class="title-input" type="text" placeholder="Title"/>
    </form>
</div>

<div class="floating-area">
    <div class="floating-box">
        <div>
            <label>Points:
                <input type="text" name="p"/>
            </label>
        </div>
        <div>
            <label>Capacity:
                <input type="text" name="cap"/>
            </label>
        </div>
        <div>
            <label for="category">Category:</label>
            <select name="cat" id="category">
                <option value="volvo">Life Style</option>
                <option value="saab">Food</option>
                <option value="opel">Machine</option>
                <option value="audi">Mobile</option>
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
            <button id="create-button" title="Add question"></button>
            <button>Create</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/createJs.js"></script>


<%--<div class="content-box position-relative">
    <div class="query-area">
        <form method="post">
            <input class="title-input" type="text" placeholder="Title"/>
        </form>
        <div class="query-box position-relative">
            <input class="delete-query-button" type="button" value="x"/>
            <form>
                <input class="query-title-input" type="text" placeholder="Question"/>
                <div>
                <input/> <input type='button' value='x'/><br>
                <div
                <input/> <input type='button' value='x'/><br>
                <input/> <input type='button' value='x'/><br>
                <input/><br>
                <input/><br>
                <input/><br>
                <input/><br>
                <input/><br>
                <input/><br>
                <input/><br>
                <input/><br>
                <input/><br>
            </form>
            <input type='button' value='+'/>
        </div>
    </div>

    <div class="floating-box">
        <input id="create-button" type="button" value="+"/>
    </div>
</div>--%>
