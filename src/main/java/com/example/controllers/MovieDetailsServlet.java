package com.example.controllers;

import com.example.dao.MovieDAO;
import com.example.dao.ReviewDAO;
import com.example.models.Movie;
import com.example.models.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;



@WebServlet("/moviedetails")
public class MovieDetailsServlet extends HttpServlet {

    private MovieDAO movieDAO = new MovieDAO();
    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int movieId = Integer.parseInt(req.getParameter("id"));

        Movie movie = movieDAO.getMovieById(movieId);           
        List<Review> reviews = reviewDAO.getReviewsByMovieId(movieId);  
        
        if (reviews == null) {
            reviews = new ArrayList<>();
        }

        
        req.setAttribute("movie", movie);
        req.setAttribute("reviews", reviews);

        req.getRequestDispatcher("/moviedetails.jsp").forward(req, resp);
    }
}
