package my.servlet;

import my.dao.DAOFactory;
import my.dao.StudentDAO;

import my.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/studentList", "/editStudent", "/updateStudent", "/deleteStudent"})
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.endsWith("/studentList")) {
            // 显示学生列表
            try {
                StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
                List<Student> students = studentDAO.queryAll();
                request.setAttribute("students", students);
                request.getRequestDispatcher("/studentList.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "数据加载失败");
            }
        } else if (path.endsWith("/editStudent")) {
            // 获取学生信息并显示在编辑页面
            try {
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
                Student student = studentDAO.queryById(studentId); // 假设有 queryById 方法
                request.setAttribute("student", student);
                request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "加载学生信息失败");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/updateStudent")) {
            // 更新学生信息
            try {
                request.setCharacterEncoding("UTF-8"); // 防止中文乱码
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                String studentName = request.getParameter("studentName");
                int age = Integer.parseInt(request.getParameter("age"));
                String gender = request.getParameter("gender");

                Student student = new Student();
                student.setStudentId(studentId);
                student.setStudentName(studentName);
                student.setAge(age);
                student.setGender(gender);

                StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
                studentDAO.update(student);

                response.sendRedirect("studentList");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新操作失败");
            }
        } else if (request.getRequestURI().endsWith("/deleteStudent")) {
            try {
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
                studentDAO.delete(studentId);
                response.sendRedirect("studentList");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "删除操作失败");
            }
        }
    }
}