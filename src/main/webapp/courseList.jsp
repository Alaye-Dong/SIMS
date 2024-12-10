<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>课程列表</title>
</head>
<body>
<h1>所有课程</h1>
<table border="1">
    <thead>
    <tr>
        <th>课程ID</th>
        <th>课程名称</th>
        <th>课程时长</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.courseDuration}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button onclick="window.location.href='home.jsp'">返回主页</button>
</body>
</html>