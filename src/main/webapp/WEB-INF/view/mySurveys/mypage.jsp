<%--
  Created by IntelliJ IDEA.
  User: xmapple
  Date: 2021/03/17
  Time: 11:38 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="/css/style_mypage.css" rel="stylesheet" type="text/css">
    <link href="/css/framework.css" rel="stylesheet" type="text/css">
</head>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">


<div class = "explore_main-container" id="mypagemain">
    <h2 class="font-x3">My Page</h2>
    <hr>
    <div class="display-flex flex-direction-column infobox padding-20">
        <div>
            <img>
            </img>${member.username} image name
        </div>
        <div class ="font-xs padding-10" id="username">
            Username : ${member.username}
        </div>
        <div class = "font-xs padding-10" id="takennum">
            Surveys I Participated : 11 (should change later)
        </div>
        <div class = "font-xs padding-10" id="mypoint">
            My Points : ${member.point}
        </div>
    </div>

    <form class="display-flex flex-auto flex-direction-column padding-20" id="pw-change-form" method="post">
        <div class="font-x2" style= "font-family: 'Roboto', sans-serif; "> new password</div>
        <div class="pwchange flex-direction-column">
            <div class="font-xs"> new password </div>
            <input class="display-flex margin-15 newpw" id="newpw1" type="password" placeholder="new password" name="newpw1"/>
            <div class="error-container" id="newpw1-error-con"></div>
            <div class="font-xs"> double check </div>
            <input class="display-flex margin-15 newpw" id="newpw2" type="password" placeholder="double check" name="newpw2"/>
            <div class="error-container" id="newpw2-error-con"></div>

            <input class="submit-button" id="changepwbtn" type="submit" value="Submit"/>
            <div class="error-container" id="t-error-con"></div>

        </div>
    </form>
</div>

<script type="text/javascript" src="/js/mypageJs.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script>

    $( "#pw-change-form" ).validate({
        rules: {
            newpw1: "required",
            newpw2: {
                equalTo: "#newpw1"
            }
        },
        messages:{},
        errorPlacement: function(error, element) {
            console.log("el: ",  element)
            console.log("err: ",  error)
            let placement = $("#newpw2-error-con");
            if (placement) {
                $(placement).append(error)
            } else {
                error.insertAfter(element);
            }
        },
        invalidHandler: function(event, validator) {
            // 'this' refers to the form
            let errors = validator.numberOfInvalids();
            if (errors) {
                let message = errors == 1
                    ? 'You missed 1 field.'
                    : 'You missed ' + errors + ' fields.';
                $("#t-error-con").html(message);
                $("#t-error-con").show();
            } else {
                $("#t-error-con").hide();
            }
        }
    });

$(document).ready(function() {
    $("#back").click(function(){
        window.history.back();
    });

    $("#newpw2").keyup(function(e) {
        $("#t-error-con").hide();
    });
    $("#newpw1").keyup(function(e) {
        $("#t-error-con").hide();
    });
})
</script>