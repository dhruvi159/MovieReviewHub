<%@ page session="true" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">

<%@ include file="components/navbar.jsp" %>

<div class="container mt-5">

    <h2>Your Profile</h2>
    <hr class="border-light">

    <%
        String email = (String) session.getAttribute("email");
    %>

    <% if (userId == null) { %>
        <div class="alert alert-warning">
            You must be logged in to view your profile.
        </div>
    <% } else { %>

        <div class="card bg-secondary p-4">
            <p><strong>User ID:</strong> <%= userId %></p>
            <p><strong>User name:</strong> <%= username %></p>
            <p><strong>Email:</strong> <%= email %></p>

            <a href="movies" class="btn btn-danger mt-3">Back to Movies</a>
        </div>

    <% } %>

</div>

</body>
</html>
