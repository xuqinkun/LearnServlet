package com.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet",
        urlPatterns = {"/hello"},
        initParams = {
        @WebInitParam(name = "admin", value = "Harry Taciak"),
        @WebInitParam(name = "email", value = "Admin@163.com"),
        })
public class HelloServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String admin = config.getInitParameter("admin");
        String email = config.getInitParameter("email");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>admin: " + admin + "</h1>");
        out.println("<h1>email: " + email + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}