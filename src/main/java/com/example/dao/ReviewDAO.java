package com.example.dao;

import com.example.models.Review;
import com.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    public Review getReviewById(int reviewId) {
        Review r = null;

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM reviews WHERE review_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reviewId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Review();
                r.setId(rs.getInt("review_id"));
                r.setMovieId(rs.getInt("movie_id"));
                r.setUserId(rs.getInt("user_id"));
                r.setUsername(rs.getString("username"));
                r.setRating(rs.getInt("rating"));
                r.setComment(rs.getString("comment"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }


    public List<Review> getReviewsByMovieId(int movieId) {
        List<Review> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM reviews WHERE movie_id = ? ORDER BY review_id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, movieId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review r = new Review();

                r.setId(rs.getInt("review_id"));
                r.setMovieId(rs.getInt("movie_id"));
                r.setUserId(rs.getInt("user_id"));
                r.setUsername(rs.getString("username"));
                r.setRating(rs.getInt("rating"));
                r.setComment(rs.getString("comment"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public void editReview(Review r) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE reviews SET rating = ?, comment = ? WHERE review_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, r.getRating());
            ps.setString(2, r.getComment());
            ps.setInt(3, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addReview(Review r) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO reviews (movie_id, user_id, rating, comment, username) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, r.getMovieId());
            ps.setInt(2, r.getUserId());
            ps.setInt(3, r.getRating());
            ps.setString(4, r.getComment());
            ps.setString(5, r.getUsername());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void deleteReview(int reviewId) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "DELETE FROM reviews WHERE review_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reviewId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
