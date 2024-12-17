<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String error = (String) session.getAttribute("error");
    if (error != null) {
        // 显示错误信息
        out.println("<div style='color: red;'>" + error + "</div>");
        // 清除错误信息
        session.removeAttribute("error");
    }
%>
<form action="login" method="post">
    <input type="text" name="user_name" placeholder="用户名" required>
    <input type="password" name="password" placeholder="密码" required>
    <button type="submit">登录</button>
</form>
</body>
</html>
