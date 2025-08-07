package com.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "HttpServlet",
        urlPatterns = {"/http"},
        initParams = {
                @WebInitParam(name = "admin", value = "Harry Taciak"),
                @WebInitParam(name = "email", value = "Admin@163.com"),
        })
public class HttpServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contentType = req.getContentType();
        if (contentType.startsWith("application/json")) {
            BufferedReader reader = req.getReader();
            StringBuilder jsonBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBody.append(line);
            }
            ObjectMapper mapper = new ObjectMapper(); // Jackson
            try {
                Map<String, String> data = mapper.readValue(jsonBody.toString(), Map.class);
                String name = data.get("name");
                String email = data.get("email");

                System.out.println("Name (JSON): " + name);
                System.out.println("Email (JSON): " + email);

                resp.getWriter().println("name:" + name + " email:" + email);
            } catch (JsonProcessingException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("Invalid JSON");
            }

        } else if (contentType.startsWith("application/x-www-form-urlencoded")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            resp.getWriter().println("Hello " + username);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
