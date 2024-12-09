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

@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
            List<Student> students = studentDAO.queryAll();
            System.out.println(students);
            // 将学生列表传递给 JSP 页面
//            HttpSession session = request.getSession();
//            session.setAttribute("students", students);

            request.setAttribute("students", students);

            request.getRequestDispatcher("/studentList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "数据加载失败");
        }
    }
}