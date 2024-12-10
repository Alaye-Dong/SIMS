package my.servlet;

import my.dao.DAOFactory;
import my.dao.inter.UserDAOInter;
import my.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");

        // 创建用户对象
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        // 获取DAO实例并插入用户数据
        UserDAOInter userDAOInter = DAOFactory.getUserDAOInstance();
        try {
            userDAOInter.insert(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 注册成功后重定向到登录页面
        response.sendRedirect("login.jsp");
    }
}