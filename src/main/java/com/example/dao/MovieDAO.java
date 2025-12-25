package com.example.dao;

import com.example.models.Movie;
import com.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    // -------------------------------
    // 1) GET ALL MOVIES
    // -------------------------------
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            if (conn == null) {
                System.out.println("DB connection is NULL");
                return list;
            }

            String sql = "SELECT * FROM movies";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getInt("movie_id"));
                m.setTitle(rs.getString("title"));
                m.setRelease_year(rs.getInt("release_year"));
                m.setGenre(rs.getString("genre"));
                m.setPosterUrl(rs.getString("poster_url"));
                list.add(m);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // --------------------------------------
    // 2) GET A SINGLE MOVIE BY ID
    // --------------------------------------
    public Movie getMovieById(int id) {

        Movie movie = null;

        try {
            Connection conn = DBConnection.getConnection();
            if (conn == null) {
                System.out.println("DB connection is NULL");
                return null;
            }

            String sql = "SELECT * FROM movies WHERE movie_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("movie_id"));
                movie.setTitle(rs.getString("title"));
                movie.setRelease_year(rs.getInt("release_year"));
                movie.setGenre(rs.getString("genre"));
                movie.setPosterUrl(rs.getString("poster_url"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movie;
    }
}