<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-29
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="display-flex flex-wrapper content-box">
    <c:forEach var="item" items="${list}">
        <button class="survey-box">
            <div>
                ${item.time}
            </div>
            <div>
                ${item.category}
            </div>
            <div>
                ${item.title}
            </div>
            <div>
                ${item.point}
            </div>
            <div>
                ${item.capacity}
            </div>
        </button>
    </c:forEach>
</div>