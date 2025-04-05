package com.flipkart.clone;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ShopServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Welcome to Flipkart Mini Clone!</h2>");
        out.println("<p>Browse Products | View Cart | Checkout</p>");
    }
}
