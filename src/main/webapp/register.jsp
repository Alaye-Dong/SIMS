<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%--TODO 重复用户名注册验证--%>
<%--TODO 各种成功和失败的提示 --%>
<form action="register" method="post">
    <input type="text" name="user_name" placeholder="用户名" required>
    <input type="password" name="password" placeholder="密码" required>
    <button type="submit">注册</button>
</form>
</body>
</html>
