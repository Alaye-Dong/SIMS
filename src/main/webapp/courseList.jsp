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
            <td>
                <button type="button"
                        onclick="window.location.href='${pageContext.request.contextPath}/editCourse?courseId=${course.courseId}'">
                    编辑
                </button>
                <form action="${pageContext.request.contextPath}/deleteCourse" method="POST"
                      onsubmit="return confirm('确定要删除吗？')">
                    <input type="hidden" name="courseId" value="${course.courseId}"/>
                    <button type="submit">删除</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/addCourse.jsp'">
    添加
</button>
<button onclick="window.location.href='home.jsp'">返回主页</button>
</body>
</html>