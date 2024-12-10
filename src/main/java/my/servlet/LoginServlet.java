package my.servlet;

import my.dao.DAOFactory;
import my.dao.inter.UserDAOInter;
import my.vo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

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

        UserDAOInter userDAOInter = DAOFactory.getUserDAOInstance();
        try {
            isValid = userDAOInter.check(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!isValid) {
            // 设置错误信息并重定向
            request.getSession().setAttribute("error", "用户名或密码错误");
            response.sendRedirect("login.jsp");
        } else {
            // 登录成功，重定向到主页或其他页面
            response.sendRedirect("home.jsp");
        }
    }
}
