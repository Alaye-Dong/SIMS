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

<h2>查询学生</h2>
<form action="${pageContext.request.contextPath}/studentList" method="GET">
    <label for="studentName">姓名:</label>
    <input type="text" id="studentName" name="studentName" value="${not empty studentName ? studentName : ''}"/>
    <button type="submit">查询</button>
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

<div>
    <c:if test="${currentPage > 1}">
        <a href="?page=1">首页</a>
        <a href="?page=${currentPage - 1}">上一页</a>
    </c:if>
    <span>第 ${currentPage} 页 / 共 ${totalPages} 页</span>
    <c:if test="${currentPage < totalPages}">
        <a href="?page=${currentPage + 1}">下一页</a>
        <a href="?page=${totalPages}">末页</a>
    </c:if>
</div>
</body>
</html>