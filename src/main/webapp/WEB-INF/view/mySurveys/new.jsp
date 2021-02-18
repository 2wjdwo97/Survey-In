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

<form class="display-flex flex-auto content-box" method="post" onsubmit="return checkValid(event)">
    <div class="query-area flex-auto">
        <div style="margin-bottom: 40px">
            <input class="title-input" type="text" placeholder="Title" name="title"/>
        </div>
    </div>

    <div class="floating-area flex-auto">
        <div class="floating-box">
            <div class="floating-box-inner">
                <div class="floating-box-header">
                    <div>Survey Options</div>
                </div>
                <div class="floating-option-area">
                    <div>
                        <label>Points
                            <div>
                                <input class="option-input" type="text" name="point"/>
                            </div>
                        </label>
                    </div>
                    <div>
                        <label>Capacity
                            <div>
                                <input class="option-input" type="text" name="capacity"/>
                            </div>
                        </label>
                    </div>
                    <div>
                        <label for="category">Category</label>
                        <div>
                            <select class="option-input" name="category" id="category">
                                <option value="life">Life Style</option>
                                <option value="food">Food</option>
                                <option value="machine">Machine</option>
                                <option value="mobile">Mobile</option>
                            </select>
                        </div>
                    </div>
<%--                    <div>
                        <div>Options</div>

                        <label>
                            <input class="radio" type="radio" name="option" checked=true value="all"/>
                            All</label>
                        <label>
                            <input class="radio" type="radio" name="option" value="men"/>
                            Men Only</label>
                        <label>
                            <input class="radio" type="radio" name="option" value="women"/>
                            Women Only</label>
                    </div>--%>
                </div>
            </div>
            <div class="floating-box-follow display-flex">
                <div class="floating-box-header-mark">
                </div>
                <div>
                    <button id="create-question" class="create-button" title="Add question" type="button"></button>
                    <input id="submit-survey-button" type="submit" value="Submit"/>
                </div>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript" src="/js/createJs.js"></script>
