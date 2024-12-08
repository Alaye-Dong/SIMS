package my.servlet;

import my.dao.DAOFactory;
import my.dao.UserDAO;
import my.vo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");

        // 创建用户对象
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        boolean isValid = false;

        UserDAO userDAO = DAOFactory.getUserDAOInstance();
        try {
            isValid =  userDAO.check(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (isValid) {
            response.sendRedirect("home.jsp");
        }
        else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
