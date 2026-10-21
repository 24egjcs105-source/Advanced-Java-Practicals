package com.ecommerce.servlet;

import com.ecommerce.model.CartItem;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        Map<Integer,CartItem> cart=(Map<Integer,CartItem>)req.getSession().getAttribute("cart");
        if(cart==null || cart.isEmpty()){ resp.sendRedirect(req.getContextPath()+"/cart"); return; }
        req.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(req,resp);
    }
    @SuppressWarnings("unchecked")
    @Override protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name"), email=req.getParameter("email"), address=req.getParameter("address");
        if(name==null || name.isBlank() || email==null || email.isBlank() || address==null || address.isBlank()){
            req.setAttribute("error","Please fill in every field."); doGet(req,resp); return;
        }
        Map<Integer,CartItem> cart=(Map<Integer,CartItem>)req.getSession().getAttribute("cart");
        if(cart==null || cart.isEmpty()){ resp.sendRedirect(req.getContextPath()+"/cart"); return; }
        double total=cart.values().stream().mapToDouble(CartItem::getSubtotal).sum();
        req.getSession().removeAttribute("cart");
        req.setAttribute("name",name); req.setAttribute("email",email); req.setAttribute("address",address); req.setAttribute("total",total);
        req.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(req,resp);
    }
}