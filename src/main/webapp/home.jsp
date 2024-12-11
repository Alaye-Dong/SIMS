<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%-- 鉴权，检查是否有用户信息 --%>
<%--<%--%>
<%--    String user = (String) session.getAttribute("user");--%>
<%--    if (user == null) {--%>
<%--        response.sendRedirect("login.jsp");--%>
<%--    }--%>
<%--%>--%>
<h1>Welcome</h1>

<%--正确跳转获取数据页面的方式--%>
<a href="${pageContext.request.contextPath}/studentList">学生管理</a>
<a href="${pageContext.request.contextPath}/courseList">课程管理</a>
<%--错误的方式，会获取不到数据显示空白--%>
<%--<a href="studentList.jsp">StudentList.jsp</a>--%>
<a href="${pageContext.request.contextPath}/logout">退出登录</a>
</body>
</html>
