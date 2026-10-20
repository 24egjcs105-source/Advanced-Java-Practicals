package com.servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<!DOCTYPE html><html><body>");
        response.getWriter().println("<h1>Hello Students!</h1>");
        response.getWriter().println("<h2>Welcome to Servlet Programming</h2>");
        response.getWriter().println("<p><a href='index.html'>Back to login</a></p>");
        response.getWriter().println("</body></html>");
    }
}
