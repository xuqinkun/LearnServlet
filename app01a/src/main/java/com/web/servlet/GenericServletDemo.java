package com.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenericServletDemo",
        urlPatterns = {"/generic"},
        initParams = {
        @WebInitParam(name = "admin", value = "Harry Taciak"),
        @WebInitParam(name = "email", value = "Admin@163.com"),
        })
public class GenericServletDemo extends GenericServlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String admin = config.getInitParameter("admin");
        String email = config.getInitParameter("email");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Admin: " + admin + "</h1>");
        out.println("<h1>Email: " + email + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}