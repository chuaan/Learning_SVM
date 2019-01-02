<%--
  Created by IntelliJ IDEA.
  User: wangzhou
  Date: 2018-12-27
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form class="form-signin" action="login.htm" method="post">
    <h2 class="form-signin-heading">请登录</h2>
    #if ( $!message )
    <div class="alert alert-danger" style="text-align: center;"><strong>${message}</strong></div>
    #end
    <input name="username" type="text" class="form-control" value="$!{username}" placeholder="手机号码" autofocus>
    <input name="password" type="password" class="form-control" placeholder="密码">
    <button class="btn btn-lg btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> 登陆</button>
</form>
</body>
</html>
