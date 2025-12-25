<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Review</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">
<%@ include file="components/navbar.jsp" %>

<div class="container mt-5">

    <h2>Edit Your Review</h2>

    <form action="${pageContext.request.contextPath}/updateReview" method="post">
        
        <!-- Hidden values -->
        <input type="hidden" name="review_id" value="${review.id}">
        <input type="hidden" name="movie_id" value="${review.movieId}">

        <!-- Rating -->
        <div class="mb-3">
            <label>New Rating (1–5)</label>
            <select name="rating" class="form-select" required>
                <option value="5" <c:if test="${review.rating == 5}">selected</c:if>>⭐ 5</option>
                <option value="4" <c:if test="${review.rating == 4}">selected</c:if>>⭐ 4</option>
                <option value="3" <c:if test="${review.rating == 3}">selected</c:if>>⭐ 3</option>
                <option value="2" <c:if test="${review.rating == 2}">selected</c:if>>⭐ 2</option>
                <option value="1" <c:if test="${review.rating == 1}">selected</c:if>>⭐ 1</option>
            </select>
        </div>

        <!-- Comment -->
        <div class="mb-3">
            <label>Updated Comment</label>
            <textarea name="comment" class="form-control" rows="3" required>${review.comment}</textarea>
        </div>

        <button class="btn btn-success mt-3">Update Review</button>
    </form>
</div>

</body>
</html>
