<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-01-31
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside>
    <div class="aside-inner-div">
        <div>
            <img>

            </img>${member.username}
        </div>
        <div>
            my point: ${member.point}
            <button id="give-button" type="button">give</button>
        </div>

        <div style="margin-top: 80px">
                <a href = '/${member.username}/surveys'> My surveys</a>
        </div>

        <div>
            <a href = '/${member.username}/new'> New survey</a>
        </div>

        <div>
            <a href = '/explore'> Recommend</a>
        </div>

        <div>
            <a href = '/${member.username}/myPage'> My Page </a>
        </div>
    </div>
</aside>
