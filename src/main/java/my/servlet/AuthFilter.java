package my.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 不需要鉴权的页面
        String[] noAuthPages = {httpRequest.getContextPath() + "/index.jsp", httpRequest.getContextPath() + "/index", httpRequest.getContextPath() + "/login.jsp", httpRequest.getContextPath() + "/login", httpRequest.getContextPath() + "/register.jsp", httpRequest.getContextPath() + "/register"};

        // 获取当前请求的路径
        String requestURI = httpRequest.getRequestURI();

        if (Arrays.asList(noAuthPages).contains(requestURI)) {
            chain.doFilter(request, response); // 如果是无需鉴权的页面，直接放行
            return;
        }
        if (httpRequest.getSession().getAttribute("user") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp"); // 否则需要鉴权，重定向到登录页面
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
