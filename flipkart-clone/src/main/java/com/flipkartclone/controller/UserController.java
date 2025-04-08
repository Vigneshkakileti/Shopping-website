package com.flipkartclone.controller;

import com.flipkartclone.model.User;
import com.flipkartclone.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("register".equals(action)) {
                User user = new User();
                user.setName(request.getParameter("name"));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                userService.register(user);
                response.sendRedirect("login.jsp");
            } else if ("login".equals(action)) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                User user = userService.login(email, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    response.sendRedirect("products.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=true");
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}