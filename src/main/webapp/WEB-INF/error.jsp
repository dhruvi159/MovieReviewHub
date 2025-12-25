<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">

<%@ include file="components/navbar.jsp" %>

<div class="container mt-5">

    <div class="card bg-danger text-light shadow p-4">
        <h3 class="mb-3">⚠ Something went wrong</h3>

        <p>
            <strong>
                ${param.msg != null ? param.msg : "Unexpected error occurred!"}
            </strong>
        </p>

        <a href="javascript:history.back()" class="btn btn-light mt-3">
            ⬅ Go Back
        </a>
    </div>

</div>

</body>
</html>
