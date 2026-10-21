package com.ecommerce.servlet;

import com.ecommerce.model.*;
import com.ecommerce.util.ProductStore;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    private Map<Integer,CartItem> cart(HttpSession session) {
        Map<Integer,CartItem> cart=(Map<Integer,CartItem>)session.getAttribute("cart");
        if(cart==null){ cart=new LinkedHashMap<>(); session.setAttribute("cart",cart); }
        return cart;
    }
    @Override protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Map<Integer,CartItem> cart=cart(req.getSession());
        String action=req.getParameter("action");
        try {
            int id=Integer.parseInt(req.getParameter("id"));
            if("add".equals(action)) {
                Product p=ProductStore.find(id);
                if(p!=null) { if(cart.containsKey(id)) cart.get(id).increase(); else cart.put(id,new CartItem(p)); }
            } else if("remove".equals(action)) cart.remove(id);
            else if("decrease".equals(action) && cart.containsKey(id)) cart.get(id).decrease();
        } catch(Exception ignored) {}
        resp.sendRedirect(req.getContextPath()+"/cart");
    }
    @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        Map<Integer,CartItem> cart=cart(req.getSession());
        double total=cart.values().stream().mapToDouble(CartItem::getSubtotal).sum();
        req.setAttribute("cartItems",cart.values()); req.setAttribute("total",total);
        req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req,resp);
    }
}