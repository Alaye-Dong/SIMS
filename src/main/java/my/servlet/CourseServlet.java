package my.servlet;

import my.dao.impl.CourseDAOImpl;
import my.vo.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/courseList", "/deleteCourse", "/editCourse", "/updateCourse", "/addCourse"})
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.endsWith("/courseList")) {
            try {
                // 获取当前页码和每页显示的记录数
                int page = 1;
                int pageSize = 10;  // 每页显示条记录
                String pageParam = request.getParameter("page");
                if (pageParam != null && !pageParam.isEmpty()) {
                    page = Integer.parseInt(pageParam);
                }

                // 获取查询条件和当前页码
                String courseName = request.getParameter("courseName");


                CourseDAOImpl courseDAO = new CourseDAOImpl();
                List<Course> courses;

                if (courseName != null && !courseName.isEmpty()) {
                    // 根据学生姓名查询
                    courses = courseDAO.queryByName(courseName);
                } else {
                    // 查询所有学生
                    courses = courseDAO.queryAll((page - 1) * pageSize, pageSize);
                }

                // 查询总记录数，用于计算总页数
                int totalRecords = courseDAO.getCourseCount();
                int totalPages = (int) Math.ceil(totalRecords / (double) pageSize);

                // 将分页数据传递给 JSP 页面
                request.setAttribute("courses", courses);
                request.setAttribute("currentPage", page);
                request.setAttribute("totalPages", totalPages);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/courseList.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("查询课程信息失败: " + e.getMessage());
            }
        } else if (path.endsWith("/editCourse")) {
            // 显示课程信息编辑页面
            try {
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                CourseDAOImpl courseDAO = new CourseDAOImpl();
                Course course = courseDAO.queryById(courseId); // 假设有 queryById 方法
                request.setAttribute("course", course);
                request.getRequestDispatcher("/editCourse.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "加载课程信息失败");
            }
        }
    }

    // 处理添加课程
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.endsWith("/updateCourse")) {
            try {
                request.setCharacterEncoding("UTF-8"); // 防止中文乱码
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                String courseName = request.getParameter("courseName");
                String courseDuration = request.getParameter("courseDuration");

                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(courseName);
                course.setCourseDuration(courseDuration);

                CourseDAOImpl courseDAO = new CourseDAOImpl();
                courseDAO.updateCourse(course);

                response.sendRedirect("courseList");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新课程失败");
            }
        } else if (path.endsWith("/addCourse")) {
            try {
                request.setCharacterEncoding("UTF-8");
                String courseName = request.getParameter("courseName");
                String courseDuration = request.getParameter("courseDuration");

                Course course = new Course();
                course.setCourseName(courseName);
                course.setCourseDuration(courseDuration);

                CourseDAOImpl courseDAO = new CourseDAOImpl();
                courseDAO.addCourse(course);

                response.sendRedirect("courseList");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("添加课程失败: " + e.getMessage());
            }
        } else if (path.endsWith("/deleteCourse")) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            try {
                CourseDAOImpl courseDAO = new CourseDAOImpl();
                int i = courseDAO.deleteCourse(courseId);
                response.sendRedirect("courseList");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("删除课程失败: " + e.getMessage());
            }
        }
    }
}