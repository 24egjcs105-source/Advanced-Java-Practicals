package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");

        // Demo-only credentials for this practical. Real applications should use
        // securely stored password hashes and proper authentication.
        if ("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("<!DOCTYPE html><html><body>");
            response.getWriter().println("<h1>Invalid Login</h1>");
            response.getWriter().println("<p>Please check your username and password.</p>");
            response.getWriter().println("<a href='index.html'>Try again</a>");
            response.getWriter().println("</body></html>");
        }
    }
}
