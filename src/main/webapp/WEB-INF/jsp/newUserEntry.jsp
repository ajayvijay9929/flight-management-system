<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- JSP directive specifying page language, content type, and encoding -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Import JSTL core library for use in JSP -->
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!-- Import Spring form tag library for form handling -->

            <!DOCTYPE html> <!-- HTML5 document type declaration -->
            <html lang="en"> <!-- Specifies the language of the document as English -->

            <head>
                <meta charset="UTF-8"> <!-- Character encoding for the HTML document -->
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <!-- Responsive design meta tag -->
                <title>New User Register</title> <!-- Title of the page -->
                <!-- Include Bootstrap CSS for styling -->
                <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                <!-- Custom CSS styles -->
                <style>
                    body {
                        font-family: 'Arial', sans-serif;
                        /* Sets the font style for the page */
                        background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg');
                        /* Background image for the page */
                        background-size: cover;
                        /* Ensures the background covers the whole page */
                        background-position: center;
                        /* Centers the background image */
                        background-repeat: no-repeat;
                        /* Prevents the background image from repeating */
                    }

                    .card {
                        margin-top: 10%;
                        /* Margin from the top of the page */
                        background: rgba(255, 255, 255, 0.8);
                        /* Semi-transparent background for the card */
                    }

                    .form-label {
                        font-weight: bold;
                        /* Makes form labels bold */
                        font-size: 18px;
                        /* Sets the font size for form labels */
                    }
                </style>
                <script type="text/javascript">
                    function passwordCheck() {
                        var pass1 = document.getElementById("pass1").value; // Gets the value of the first password input
                        var pass2 = document.getElementById("pass2").value; // Gets the value of the second password input

                        if (pass1.length < 6) {
                            alert("Password Must Be minimum 6 characters long"); // Alert if password is less than 6 characters
                        } else if (pass1 === pass2) {
                            document.getElementById("registrationForm").submit(); // Submits the form if passwords match
                        } else {
                            alert("Passwords Not Matched"); // Alert if passwords do not match
                        }
                    }
                </script>
            </head>

            <body>
                <div class="container"> <!-- Bootstrap container for layout -->
                    <div class="row justify-content-center"> <!-- Centers the card horizontally -->
                        <div class="col-md-6"> <!-- Sets the width of the card to half of the window -->
                            <div class="card shadow-lg"> <!-- Card with large shadow for emphasis -->
                                <div class="card-body"> <!-- Container for card content -->
                                    <h2 class="text-center mb-4 font-weight-bold">Sign up now</h2>
                                    <!-- Sign up heading -->
                                    <form:form id="registrationForm" action="/register" method="post"
                                        modelAttribute="userRecord"> <!-- Spring form for registration -->
                                        <div class="form-group"> <!-- Form group for user ID -->
                                            <label for="username" class="form-label">Enter New User Id:</label>
                                            <!-- Label for user ID -->
                                            <form:input path="username" id="username" class="form-control" />
                                            <!-- Input for user ID -->
                                        </div>
                                        <div class="form-group"> <!-- Form group for user type -->
                                            <label for="type" class="form-label">Select User's Type:</label>
                                            <!-- Label for user type -->
                                            <form:input list="types" id="type" path="type" class="form-control" />
                                            <!-- Input for user type with datalist -->
                                            <datalist id="types"> <!-- Datalist for user types -->
                                                <option value="Customer"> <!-- Option for customer -->
                                                <option value="Admin"> <!-- Option for admin -->
                                            </datalist>
                                        </div>
                                        <div class="form-group"> <!-- Form group for password -->
                                            <label for="pass1" class="form-label">Enter New Password:</label>
                                            <!-- Label for password -->
                                            <form:input type="password" id="pass1" path="password"
                                                class="form-control" /> <!-- Input for password -->
                                        </div>
                                        <div class="form-group"> <!-- Form group for password confirmation -->
                                            <label for="pass2" class="form-label">Re-type Password:</label>
                                            <!-- Label for password confirmation -->
                                            <input type="password" id="pass2" class="form-control" />
                                            <!-- Input for password confirmation -->
                                        </div>
                                        <button type="button" class="btn btn-primary btn-block"
                                            onclick="passwordCheck()">Submit</button>
                                        <!-- Button to trigger password check -->
                                        <button type="reset" class="btn btn-secondary btn-block">Reset</button>
                                        <!-- Button to reset the form -->
                                    </form:form>
                                    <h5 class="text-center mt-3 font-weight-bold">
                                        Already have an account? <a href="/loginpage">Login</a>
                                        <!-- Link to login page -->
                                    </h5>
                                </div>
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