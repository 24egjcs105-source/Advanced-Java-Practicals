package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/index.html");
            return;
        }

        String username = (String) session.getAttribute("username");
        response.getWriter().println("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
        response.getWriter().println("<title>Student Home</title></head><body>");
        response.getWriter().println("<h1>Student Home</h1>");
        response.getWriter().println("<h2>Welcome " + escapeHtml(username) + "</h2>");
        response.getWriter().println("<p>You are logged in using HttpSession.</p>");
        response.getWriter().println("<a href='" + request.getContextPath() + "/logout'>Logout</a>");
        response.getWriter().println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
