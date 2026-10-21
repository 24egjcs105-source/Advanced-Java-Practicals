package com.ecommerce.servlet;

import com.ecommerce.util.ProductStore;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;

@WebServlet(urlPatterns={"","/"})
public class HomeServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", ProductStore.all());
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}