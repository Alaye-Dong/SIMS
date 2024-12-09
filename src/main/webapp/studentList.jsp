<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h2>添加新学生</h2>
<form action="${pageContext.request.contextPath}/insertStudent" method="POST">
    <label for="studentName">姓名:</label>
    <input type="text" id="studentName" name="studentName" required/><br/>

    <label for="age">年龄:</label>
    <input type="number" id="age" name="age" required/><br/>

    <label for="gender">性别:</label>
    <select id="gender" name="gender">
        <option value="男">男</option>
        <option value="女">女</option>
    </select><br/>

    <button type="submit">提交</button>
</form>

<h2>学生列表</h2>
<table border="1">
    <thead>
    <tr>
        <th>学生ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.age}</td>
            <td>${student.gender}</td>
            <td>
                <a href="${pageContext.request.contextPath}/editStudent?studentId=${student.studentId}">编辑</a>
                <form action="${pageContext.request.contextPath}/deleteStudent" method="POST"
                      onsubmit="return confirm('确定要删除吗？')">
                    <input type="hidden" name="studentId" value="${student.studentId}"/>
                    <button type="submit">删除</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>