<%--
  Created by IntelliJ IDEA.
  User: Alaye
  Date: 2024/12/10
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新学生</title>
</head>
<body>
<h2>添加新学生</h2>
<form action="${pageContext.request.contextPath}/addStudent" method="POST">
    <label for="studentName">姓名:</label>
    <input type="text" id="studentName" name="studentName" required/>

    <label for="age">年龄:</label>
    <input type="number" id="age" name="age" required/>

    <label for="gender">性别:</label>
    <select id="gender" name="gender">
        <option value="男">男</option>
        <option value="女">女</option>
    </select>

    <button type="submit">提交</button>
</form>
</body>
</html>
