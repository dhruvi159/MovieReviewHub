package com.example.controllers;

import com.example.dao.UserDAO;
import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User u = new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);

        boolean success = userDAO.registerUser(u);

        if (success)
            resp.sendRedirect("login.jsp?success=1");
        else
            resp.sendRedirect("register.jsp?error=1");
    }
}
