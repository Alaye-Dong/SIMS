<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1>欢迎</h1>

<%--正确跳转获取数据页面的方式--%>
<a href="${pageContext.request.contextPath}/studentList">学生管理</a>
<a href="${pageContext.request.contextPath}/courseList">课程管理</a>
<%--错误的方式，会获取不到数据显示空白--%>
<%--<a href="studentList.jsp">StudentList.jsp</a>--%>

</body>
</html>
