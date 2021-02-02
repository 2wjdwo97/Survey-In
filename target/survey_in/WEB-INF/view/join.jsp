<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <haed>
        <link href="/css/style_signup.css?a" rel="stylesheet" type="text/css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=PT+Sans:wght@400;700&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">

        <title>Sign up to Survey In</title>
    </haed>
    <body>
        <div class="join-form position-relative">
            <div class="form-header position-relative">
                Sign Up
            </div>
            <form class="position-relative form-input" method="post">
                <div>
                    <input class="input-area" type="text" name="id" placeholder="Username" />
                </div>
                <div>
                    <input id="pw" class="input-area" type="password" name="pw" placeholder="Password"/>
                </div>
                <div class="input-area">
                    <input id="pw-confirm" type="password" name="pwc" placeholder="Confirm Your Password"/>
                    <img class="hidden confirm-icon" src="/images/confirmed.jpg"/>
                </div>
                <div>
                    <input class="input-area" id="first-name" type="text" name="fn" placeholder="First Name"/>
                    <input class="input-area" id="last-name" type="text" name="ln" placeholder="Last Name"/>
                </div>
                <div>
                    <input class="input-area" type="email" name="email" placeholder="Email Address"/>
                </div>
                <div>
                    <input class="input-area" type="text" name="bd" placeholder="Birthday" onfocus="(this.type='date')" onblur="(this.type='text')"/>
                </div>
                <div>
                    <label>
                    <input class="radio" type="radio" name="gender" checked=true value="fem"/>
                    Female</label>
                    <label>
                    <input class="radio" type="radio" name="gender" value="male"/>
                    Male</label>
                </div>
                <div>
                    <input class="input-area" type="text" name="job" placeholder="Job""/>
                </div>
                <div>
                    <input class="input-area" id="signup" type="submit" value="Sign Up"/>
                </div>
            </form>
        </div>
        <div class="position-relative login">
            Already have an account? <a href="/login">Login here.</a>
        </div>


        <script type="text/javascript" src="/js/joinJs.js?a"></script>
    </body>
</html>