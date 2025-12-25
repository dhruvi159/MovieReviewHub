package com.example.controllers;

import com.example.dao.ReviewDAO;
import com.example.models.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editReview")
public class editReviewServlet extends HttpServlet {

    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int reviewId = Integer.parseInt(req.getParameter("review_id"));

        Review review = reviewDAO.getReviewById(reviewId);

        if (review == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Review not found");
            return;
        }

        req.setAttribute("review", review);

        req.getRequestDispatcher("/editreview.jsp").forward(req, resp);
    }
}
