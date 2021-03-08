<%--
  Created by IntelliJ IDEA.
  User: LeeJeongJae
  Date: 2021-03-08
  Time: 오전 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" onsubmit="checkValid(event)">
        <div>
            <input id="username" name="username" placeholder="username"/>
        </div>
        <div>
            <input id="point" name="point" placeholder="point"/>
        </div>
        <button>Give</button>
    </form>
</body>
</html>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>

<script>
    function checkValid(e){
        e.preventDefault();

        $.ajax({
            url: "checkValidity",
            type: "get", //send it through get method
            data: {
                username: document.getElementById('username').value,
                point: document.getElementById('point').value,
            },
            success: function(response) {
                if(response.result_point && response.result_user) {
                    document.querySelector('form').submit();
                    //window.close();
                }
                else if(!response.result_user)
                    alert("없는 username");
                else
                    alert("point 부족");
            },
            error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    }
</script>