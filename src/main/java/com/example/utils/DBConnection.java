package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/moviereviewhub"
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=UTC";

            return DriverManager.getConnection(url, "root", "dhruvi159");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
