<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑学生信息</title>
</head>
<body>
<h2>编辑学生信息</h2>

<c:if test="${not empty student}">
    <form action="${pageContext.request.contextPath}/updateStudent" method="post">
        <input type="hidden" name="studentId" value="${student.studentId}"/>
        <label for="studentName">姓名:</label>
        <input type="text" name="studentName" value="${student.studentName}"/><br>
        <label for="age">年龄:</label>
        <input type="number" name="age" value="${student.age}"/><br>
        <label for="gender">性别:</label>
        <select id="gender" name="gender">
            <option value="男" ${student.gender == '男' ? 'selected' : ''}>男</option>
            <option value="女" ${student.gender == '女' ? 'selected' : ''}>女</option>
        </select><br/>
        <input type="submit" value="更新"/>
    </form>
</c:if>

</body>
</html>