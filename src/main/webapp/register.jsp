<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<%--TODO 重复用户名注册验证--%>
<%--TODO 各种成功和失败的提示 --%>
<form action="register" method="post">
    <input type="text" name="user_name" placeholder="User Name" required>
    <input type="password" name="password" placeholder="Password" required>
    <button type="submit">Register</button>
</form>
</body>
</html>
