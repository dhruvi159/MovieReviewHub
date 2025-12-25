package com.example.controllers;

import com.example.dao.MovieDAO;

import com.example.models.Movie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/movies")
public class MoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MovieDAO dao = new MovieDAO();

        List<Movie> movieList = dao.getAllMovies();
        System.out.println("Servlet received movies: " + movieList.size());
        System.out.println("MoviesServlet called...");
        System.out.println("Movies list = " + movieList);
        System.out.println("Movies count = " + (movieList != null ? movieList.size() : "NULL"));
        System.out.println("DAO returned: " + movieList);
        req.setAttribute("movies", movieList);

        req.getRequestDispatcher("/movies.jsp").forward(req, resp);
    }
}

