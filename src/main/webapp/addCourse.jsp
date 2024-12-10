<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加新课程</h1>
<form action="${pageContext.request.contextPath}/addCourse" method="POST">
    <label for="courseName">课程名称:</label>
    <input type="text" id="courseName" name="courseName" required><br><br>

    <label for="courseDuration">课程时长:</label>
    <input type="text" id="courseDuration" name="courseDuration" required><br><br>

    <input type="submit" value="添加课程">
</form>
</body>
</html>