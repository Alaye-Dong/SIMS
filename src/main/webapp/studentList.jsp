        <%@ page import="java.sql.*, java.util.*" %>
        <%@ page import="my.dao.StudentDAO" %>
        <%@ page import="my.dao.DAOFactory" %>
        <%@ page import="my.vo.Student" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h2>学生列表</h2>

<%
    StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
    List<Student> students = studentDAO.queryAll();


        request.setAttribute("students", students);

    if (students != null && !students.isEmpty()) {
        for (Student student : students) {
%>
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
    <tr>
        <td><%=student.getStudentId()%></td>
        <td><%=student.getStudentName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getGender()%></td>
    </tr>
    </tbody>
</table>
<%
    }
} else {
%>
<p>暂无学生数据</p>
<%
    }
%>
</table>
</body>
</html>