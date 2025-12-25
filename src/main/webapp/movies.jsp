<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Movies</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #141414;
            color: white;
            font-family: Arial, sans-serif;
        }

        .page-title {
            font-weight: 600;
            margin-top: 30px;
            margin-bottom: 20px;
        }

        /* Card Styling */
        .movie-card {
            background-color: #111;
            border-radius: 10px;
            overflow: hidden;
            transition: transform 0.3s;
            height: 100%;
        }

        .movie-card:hover {
            transform: scale(1.05);
        }

        /* FIXED POSTER SIZING */
        .movie-poster {
            width: 100%;
            height: 350px;       /* fixed height */
            object-fit: cover;   /* prevents stretching */
            display: block;
        }

        .movie-title-text {
            color: white;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            padding: 10px 0;
        }

        .container {
            max-width: 1300px;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<%@ include file="/components/navbar.jsp" %>

<div class="container">

    <!-- Page Heading -->
    <h2 class="page-title">Featured Movies</h2>

    <!-- Movie Grid -->
    <div class="row">

        <%
            java.util.List<com.example.models.Movie> movies =
                (java.util.List<com.example.models.Movie>) request.getAttribute("movies");

            for (com.example.models.Movie movie : movies) {
        %>

        <!-- Each Movie Card -->
        <div class="col-md-3 col-sm-6 mb-4 d-flex">
            <a href="moviedetails?id=<%= movie.getId() %>" class="w-100" style="text-decoration:none; color:white;">
                <div class="movie-card shadow-lg">

                    <% if (movie.getPosterUrl() != null && !movie.getPosterUrl().isEmpty()) { %>
                        <img src="<%= movie.getPosterUrl() %>" class="movie-poster" alt="Poster">
                    <% } else { %>
                        <img src="https://via.placeholder.com/200x300?text=No+Image"
                             class="movie-poster" alt="No Poster">
                    <% } %>

                    <div class="movie-title-text"><%= movie.getTitle() %></div>
                </div>
            </a>
        </div>

        <% } %>

    </div>
</div>

</body>
</html>
