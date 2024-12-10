<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome</h1>

<%--正确跳转获取数据页面的方式--%>
<a href="${pageContext.request.contextPath}/studentList">StudentList</a>
<a href="${pageContext.request.contextPath}/courseList">CourseList</a>
<%--错误的方式，会获取不到数据显示空白--%>
<%--<a href="studentList.jsp">StudentList.jsp</a>--%>

</body>
</html>
