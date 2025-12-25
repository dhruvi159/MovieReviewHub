package com.example.dao;

import com.example.models.User;
import com.example.utils.DBConnection;

import java.sql.*;

public class UserDAO {

    // REGISTER USER
    public boolean registerUser(User user) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword()); 

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LOGIN USER
    public User login(String email, String password) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
