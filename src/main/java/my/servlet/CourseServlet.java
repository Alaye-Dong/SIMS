package my.servlet;

import my.dao.impl.CourseDAOImpl;
import my.vo.Course;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/courseList")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 获取所有课程信息
            CourseDAOImpl courseDAO = new CourseDAOImpl();
            List<Course> courses = courseDAO.queryAll();

            // 将课程列表传递给 JSP 页面
            request.setAttribute("courses", courses);

            // 转发请求到 JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/courseList.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("查询课程信息失败: " + e.getMessage());
        }
    }
}