package com.example.controllers;

import com.example.dao.UserDAO;
import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userDAO.login(email, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email", user.getEmail()); 

            resp.sendRedirect("movies");
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
