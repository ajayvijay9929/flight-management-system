<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- JSP directive for page settings: language, content type, and encoding -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Import JSTL core library -->
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!-- Import Spring form tag library -->

            <!DOCTYPE html> <!-- HTML5 document type declaration -->
            <html lang="en"> <!-- Specifies the language of the page -->

            <head>
                <meta charset="UTF-8"> <!-- Character set declaration -->
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <!-- Responsive design meta tag -->
                <title>Flight Reservation System</title> <!-- Title of the page -->
                <!-- Include Bootstrap CSS for styling -->
                <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                <!-- Custom CSS styles -->
                <style>
                    body {
                        background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg');
                        /* Background image */
                        background-size: cover;
                        /* Cover the entire page with the background */
                        background-position: center;
                        /* Center the background image */
                        background-repeat: no-repeat;
                        /* Do not repeat the background image */
                        height: 100vh;
                        /* Full height of the viewport */
                        margin: 0;
                        /* Remove default margin */
                    }

                    .login-box {
                        border: 20px solid transparent;
                        /* Transparent border for the login box */
                        padding: 20px;
                        /* Padding inside the login box */
                        border-radius: 10px;
                        /* Rounded corners for the login box */
                        box-shadow: 0 0 30px rgba(0, 0, 0, 0.8);
                        /* Shadow effect for the login box */
                        margin-top: 150px;
                        /* Margin from the top of the page */
                        background-color: rgba(255, 255, 255, 0.75);
                        /* Semi-transparent white background */
                    }

                    .login-box h3 {
                        margin-bottom: 20px;
                        /* Margin below the heading */
                    }

                    .form-label1 {
                        font-weight: bold;
                        /* Bold font for form labels */
                        font-size: 20px;
                        /* Font size for form labels */
                    }
                </style>
            </head>

            <body>
                <c:url value="/login" var="login" />
                <!-- Generates a URL for the login action and stores it in a variable -->

                <div class="container"> <!-- Bootstrap container for centering the login box -->
                    <div class="row justify-content-center"> <!-- Center the login box horizontally -->
                        <div class="col-md-6"> <!-- Bootstrap column size -->
                            <div class="login-box shadow-lg"> <!-- Login box with large shadow -->
                                <h2 class="text-center">Login</h2> <!-- Centered login heading -->
                                <form:form action="${login}" method="post">
                                    <!-- Spring form tag with action and method -->
                                    <div class="form-group"> <!-- Bootstrap form group for styling -->
                                        <label for="username" class="form-label1">Enter User Id:</label>
                                        <!-- Label for username -->
                                        <input type="text" class="form-control" id="username" name="username"
                                            placeholder="Enter username" /> <!-- Username input field -->
                                    </div>
                                    <div class="form-group"> <!-- Bootstrap form group for styling -->
                                        <label for="password" class="form-label1">Enter Password:</label>
                                        <!-- Label for password -->
                                        <input type="password" class="form-control" id="password" name="password"
                                            placeholder="Enter password" /> <!-- Password input field -->
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                                    <!-- Submit button -->
                                </form:form>
                                <h5 class="text-center mt-3"> <!-- Centered text for sign-up link -->
                                    Don't have an account? <a href="/register">Sign up</a>
                                    <!-- Link to the registration page -->
                                </h5>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Bootstrap JS and dependencies for interactive components -->
                <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            </body>

            </html>