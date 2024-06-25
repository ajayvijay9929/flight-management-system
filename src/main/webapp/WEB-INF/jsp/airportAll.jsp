<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Directive to set the page language, content type, and encoding -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!-- Importing JSTL core library for use in the JSP -->

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8"> <!-- Setting the character encoding for the HTML document -->
            <title>Insert title here</title> <!-- Placeholder for the page title -->
            <style>
                body {
                    font-family: Arial, sans-serif;
                    /* Setting the font family for the body */
                    background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg');
                    /* Setting a background image */
                    background-size: cover;
                    /* Ensuring the background image covers the entire page */
                    background-position: center;
                    /* Centering the background image */
                    background-repeat: no-repeat;
                    /* Preventing the background image from repeating */
                    height: 100vh;
                    /* Setting the body height to be 100% of the viewport height */
                    margin: 0;
                    /* Removing the default margin */
                }
            </style>
        </head>

        <body>
            <div align="center"> <!-- Centering the content within a div -->
                <h1>
                    <u><i>All Airports</i></u> <!-- Heading with underline and italic styling -->
                </h1>
                <table border="1"> <!-- Creating a table with a border -->
                    <tr>
                        <th>Airport Code</th> <!-- Table header for airport codes -->
                        <th>Airport Location</th> <!-- Table header for airport locations -->
                    </tr>
                    <c:forEach items="${airportList}" var="airport">
                        <!-- Looping through each airport in the airportList -->
                        <tr>
                            <td>${airport.airportCode}</td> <!-- Displaying the airport code -->
                            <td>${airport.airportLocation}</td> <!-- Displaying the airport location -->

                        </tr>
                    </c:forEach> <!-- End of forEach loop -->
                </table>
                <br><br><br>
                <a href="i">Back to Home</a>
                <!-- Link to navigate back to the home page, though the href attribute seems to be a placeholder -->
            </div>
        </body>

        </html>