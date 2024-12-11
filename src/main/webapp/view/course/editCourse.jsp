<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty course}">
    <form action="${pageContext.request.contextPath}/updateCourse" method="post">
        <input type="hidden" name="courseId" value="${course.courseId}"/>
        <label for="courseName">课程名称:</label>
        <input type="text" name="courseName" value="${course.courseName}"/><br>
        <label for="courseDuration">课程时长:</label>
        <input type="text" name="courseDuration" value="${course.courseDuration}"/><br>
        <input type="submit" value="更新"/>
    </form>
</c:if>
</body>
</html>
