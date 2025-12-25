package com.example.controllers;

import com.example.dao.UserDAO;
import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;




@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        req.getSession().invalidate();
        resp.sendRedirect("/MovieReviewApp/movies");
    }
}
