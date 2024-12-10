<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>课程列表</title>
</head>
<body>
<h2>课程列表</h2>
<form action="${pageContext.request.contextPath}/courseList" method="GET">
    <label for="courseName">课程名称:</label>
    <input type="text" id="courseName" name="courseName" value="${not empty courseName ? courseName : ''}"/>
    <button type="submit">查询</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>课程ID</th>
        <th>课程名称</th>
        <th>课程时长</th>
        <th>操作</th>
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
<!-- 分页控件 -->
<div>
    <c:if test="${currentPage > 1}">
        <a href="?page=1">首页</a>
        <a href="courseList?page=${currentPage - 1}">上一页</a>
    </c:if>
    <span>第 ${currentPage} 页 / 共 ${totalPages} 页</span>
    <c:if test="${currentPage < totalPages}">
        <a href="courseList?page=${currentPage + 1}">下一页</a>
        <a href="?page=${totalPages}">末页</a>
    </c:if>
</div>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/addCourse.jsp'">
    添加
</button>
<button onclick="window.location.href='home.jsp'">返回主页</button>
</body>
</html>