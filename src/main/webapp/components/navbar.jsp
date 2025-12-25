<%@ page session="true" %>

<%
    Integer userId = (Integer) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
%>


<style>
    .navbar-custom {
        background-color: #141414;;
        padding: 12px 20px;
    }

    .nav-right a {
        margin-left: 20px;
        color: #ccc;
        text-decoration: none;
        font-size: 16px;
    }

    .nav-right a:hover {
        color: #fff;
    }

    .logout-link {
        color: #ff4d4d !important;
        font-weight: bold;
    }

    .welcome-text {
        color: #ccc;
        margin-right: 10px;
        font-size: 16px;
    }

    .username-highlight {
        color: #fff;
        font-weight: bold;
    }
    .navbar-brand {
    	color: #E50914;
    	letter-spacing: 1px;
}
</style>

<nav class="navbar navbar-custom d-flex justify-content-between align-items-center">
 <a class="navbar-brand fw-bold fs-4" href="home.jsp">Movie Review Hub</a>
 

    <!-- Right side -->
    <div class="nav-right d-flex align-items-center">

        <% if (userId == null) { %>

            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>

        <% } else { %>

            <span class="welcome-text">
                Welcome, <span class="username-highlight"><%= username %></span>
            </span>

            <a href="profile.jsp">Profile</a>

            <a href="logout" class="logout-link">Logout</a>

        <% } %>

    </div>

</nav>
