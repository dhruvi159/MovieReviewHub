package com.example.controllers;

import com.example.dao.ReviewDAO;
import com.example.models.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/add-review")
public class WriteReviewServlet extends HttpServlet {

    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int movieId = Integer.parseInt(req.getParameter("movie_id"));
        int rating = Integer.parseInt(req.getParameter("rating"));
        String comment = req.getParameter("comment");

        // Must have a logged-in user
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            // If not logged in → send to login page
            resp.sendRedirect("login.jsp?msg=login_required");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        String username = (String) session.getAttribute("username");

        // build review object
        Review r = new Review();
        r.setMovieId(movieId);
        r.setUserId(userId);
        r.setUsername(username);
        r.setRating(rating);
        r.setComment(comment);

        // save to DB
        reviewDAO.addReview(r);

        // redirect back to movie details page
        resp.sendRedirect(req.getContextPath() + "/moviedetails?id=" + movieId);
    }
}
