package com.example.controllers;

import com.example.dao.ReviewDAO;
import com.example.models.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateReview")
public class UpdateReviewServlet extends HttpServlet {

    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // === READ PARAMETERS SAFELY ===
            String reviewIdStr = req.getParameter("review_id");
            String movieIdStr  = req.getParameter("movie_id");
            String ratingStr   = req.getParameter("rating");
            String comment     = req.getParameter("comment");

            // Validation: prevent NumberFormatException
            if (reviewIdStr == null || reviewIdStr.trim().isEmpty() ||
                movieIdStr == null || movieIdStr.trim().isEmpty() ||
                ratingStr  == null || ratingStr.trim().isEmpty()) {

                resp.sendRedirect(req.getContextPath() + "/error.jsp?msg=Invalid Input");
                return;
            }

            int reviewId = Integer.parseInt(reviewIdStr);
            int movieId  = Integer.parseInt(movieIdStr);
            int rating   = Integer.parseInt(ratingStr);

            // === CREATE REVIEW OBJECT ===
            Review review = new Review();
            review.setId(reviewId);
            review.setRating(rating);
            review.setComment(comment);

            // === UPDATE DATABASE ===
            reviewDAO.editReview(review);

            // === REDIRECT BACK TO MOVIE PAGE ===
            resp.sendRedirect(req.getContextPath() + "/moviedetails?id=" + movieId);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/error.jsp?msg=Something+went+wrong");
        }
    }
}
