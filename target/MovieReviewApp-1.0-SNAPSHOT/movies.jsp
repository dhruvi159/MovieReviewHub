<%@ page import="java.util.List" %>
<%@ page import="com.example.models.Movie" %>

<%
    List<Movie> list = (List<Movie>) request.getAttribute("movies");
%>

<% if (list != null && !list.isEmpty()) { %>

    <% for (Movie m : list) { %>

        <div style="margin-bottom:20px;">
            <h3><%= m.getTitle() %></h3>
        </div>

    <% } %>

<% } else { %>

    <p>No movies found.</p>

<% } %>
