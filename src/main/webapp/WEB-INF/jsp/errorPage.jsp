<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h2>Oops! Something went wrong.</h2>
        <p>We're sorry, but something went wrong. Please try again later.</p>
        <a th:href="@{/}" class="btn btn-primary">Go Home</a>
    </div>
</body>

</html>