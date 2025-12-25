<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    com.example.models.Movie movie =
            (com.example.models.Movie) request.getAttribute("movie");

    // Get reviews correctly
    java.util.List<com.example.models.Review> reviews =
            (java.util.List<com.example.models.Review>) request.getAttribute("reviews");

    if (reviews == null) {
        reviews = new java.util.ArrayList<>();
    }
%>

<html>
<head>
    <title><%= movie.getTitle() %> - Details</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">

<%@ include file="components/navbar.jsp" %>

<div class="container mt-5">

    <!-- Movie Info -->
    <div class="row">
        <div class="col-md-4">
            <img src="<%= movie.getPosterUrl() %>" class="img-fluid rounded">
        </div>

        <div class="col-md-8">
            <h1><%= movie.getTitle() %></h1>
            <p><strong>Year:</strong> <%= movie.getRelease_year() %></p>
            <p><strong>Genre:</strong> <%= movie.getGenre() %></p>
        </div>
    </div>

    <hr class="mt-4 mb-4 border-light">

    <!-- Reviews Section -->
    <h3>Reviews</h3>

    <% if (reviews.size() == 0) { %>
        <p>No reviews yet. Be the first!</p>
    <% } %>

    <!-- Display reviews -->
    <% 
        for (com.example.models.Review r : reviews) { 
    %>
        <div class="card bg-secondary mb-3">
            <div class="card-body">
                <h5><%= r.getUsername() %> ⭐ <%= r.getRating() %>/5</h5>
                <p><%= r.getComment() %></p>
                <%
				    Integer loggedUserId = (Integer) session.getAttribute("userId");
				    if (loggedUserId != null && loggedUserId == r.getUserId()) {
				%>

			    <!-- Edit Button -->
			    <a href="editreview.jsp?review_id=<%= r.getId() %>&movie_id=<%= movie.getId() %>"
			       class="btn btn-warning btn-sm me-2">Edit</a>

			    <!-- Delete Button -->
			    <a href="delete-review?review_id=<%= r.getId() %>&movie_id=<%= movie.getId() %>"
			       class="btn btn-danger btn-sm"
			       onclick="return confirm('Delete this review?');">
			        Delete
			    </a>

<% } %>
            </div>
        </div>
    <% } %>

    <hr class="mt-4 mb-4 border-light">

    <!-- Add Review Form -->
    <h3>Add your review</h3>

    <form action="add-review" method="post">
        <input type="hidden" name="movie_id" value="<%= movie.getId() %>">

        <div class="mb-3">
            <label>Rating (1–5)</label>
            <select name="rating" class="form-control" required>
                <option value="5">⭐ 5</option>
                <option value="4">⭐ 4</option>
                <option value="3">⭐ 3</option>
                <option value="2">⭐ 2</option>
                <option value="1">⭐ 1</option>
            </select>
        </div>

        <div class="mb-3">
            <label>Your Review</label>
            <textarea name="comment" class="form-control" required></textarea>
        </div>

        <button class="btn btn-danger">Submit Review</button>
    </form>

</div>

</body>
</html>
