package my.servlet;

import my.dao.DAOFactory;
import my.dao.inter.StudentDAOInter;

import my.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/studentList", "/editStudent", "/updateStudent", "/deleteStudent", "/insertStudent"})
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.endsWith("/studentList")) {
            try {
                // 获取查询条件和当前页码
                String studentName = request.getParameter("studentName");
                int page = 1;
                if (request.getParameter("page") != null) {
                    page = Integer.parseInt(request.getParameter("page"));
                }

                // 每页显示的学生数量
                int pageSize = 10;
                int start = (page - 1) * pageSize;

                StudentDAOInter studentDAOInter = DAOFactory.getStudentDAOInstance();
                List<Student> students = null;

                if (studentName != null && !studentName.isEmpty()) {
                    // 根据学生姓名查询
                    students = studentDAOInter.queryByName(studentName);
                } else {
                    // 查询所有学生
                    students = studentDAOInter.queryAll(start, pageSize);
                }

                // 获取总记录数
                int totalStudents = studentDAOInter.getTotalCount();
                int totalPages = (int) Math.ceil((double) totalStudents / pageSize);

                // 设置请求属性
                request.setAttribute("students", students);
                request.setAttribute("currentPage", page);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("studentName", studentName);  // 保持查询条件

                // 转发到 JSP 页面
                request.getRequestDispatcher("/studentList.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "数据加载失败");
            }
        } else if (path.endsWith("/editStudent")) {
            // 获取学生信息并显示在编辑页面
            try {
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                StudentDAOInter studentDAOInter = DAOFactory.getStudentDAOInstance();
                Student student = studentDAOInter.queryById(studentId); // 假设有 queryById 方法
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

                StudentDAOInter studentDAOInter = DAOFactory.getStudentDAOInstance();
                studentDAOInter.update(student);

                response.sendRedirect("studentList");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新操作失败");
            }
        } else if (request.getRequestURI().endsWith("/deleteStudent")) {
            try {
                int studentId = Integer.parseInt(request.getParameter("studentId"));
                StudentDAOInter studentDAOInter = DAOFactory.getStudentDAOInstance();
                studentDAOInter.delete(studentId);
                response.sendRedirect("studentList");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "删除操作失败");
            }
        } else if (request.getRequestURI().endsWith("/insertStudent")) {
            try {
                // 设置请求编码，防止中文乱码
                request.setCharacterEncoding("UTF-8");

                // 获取表单数据
                String studentName = request.getParameter("studentName");
                int age = Integer.parseInt(request.getParameter("age"));
                String gender = request.getParameter("gender");

                // 创建学生对象
                Student student = new Student();
                student.setStudentName(studentName);
                student.setAge(age);
                student.setGender(gender);

                // 调用 DAO 层进行插入
                StudentDAOInter studentDAOInter = DAOFactory.getStudentDAOInstance();
                studentDAOInter.insert(student);

                // 插入完成后重定向到学生列表
                response.sendRedirect("studentList");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "插入操作失败");
            }
        }
    }
}