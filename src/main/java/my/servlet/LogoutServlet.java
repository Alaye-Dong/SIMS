package my.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 注销用户，销毁 session
        request.getSession().invalidate();

        // 重定向到登录页或主页
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}