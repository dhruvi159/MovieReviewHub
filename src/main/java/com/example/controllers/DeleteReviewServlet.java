package com.example.controllers;

import com.example.dao.ReviewDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete-review")
public class DeleteReviewServlet extends HttpServlet {

    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int reviewId = Integer.parseInt(req.getParameter("review_id"));
        int movieId = Integer.parseInt(req.getParameter("movie_id"));

        reviewDAO.deleteReview(reviewId);

        resp.sendRedirect("moviedetails?id=" + movieId);
    }
}
