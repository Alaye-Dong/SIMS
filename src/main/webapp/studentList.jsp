<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h2>学生列表</h2>
<table border="1">
    <thead>
    <tr>
        <th>学生ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
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
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>