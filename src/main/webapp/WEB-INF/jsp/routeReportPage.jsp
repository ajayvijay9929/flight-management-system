<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Directive to set the page language, content type, and encoding -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Import JSTL core library for use in JSP -->

        <!DOCTYPE html> <!-- HTML5 document type declaration -->
        <html>

        <head>
            <meta charset="UTF-8"> <!-- Character encoding declaration -->
            <title>Route Reports</title> <!-- Placeholder for the page title -->
            <style>
                body {
                    font-family: Arial, sans-serif;
                    /* Sets the font family for the body */
                    background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg');
                    /* Background image for the page */
                    background-size: cover;
                    /* Ensures the background image covers the entire page */
                    background-position: center;
                    /* Centers the background image */
                    background-repeat: no-repeat;
                    /* Prevents the background image from repeating */
                    height: 100vh;
                    /* Sets the height of the body to 100% of the viewport height */
                    margin: 0;
                    /* Removes the default margin from the body */
                }
            </style>
        </head>

        <body>

            <div align="center"> <!-- Centers the content inside the div -->
                <h1>
                    <u><i>All Route</i></u> <!-- Heading with underline and italic styling -->
                </h1>
                <table border="2"> <!-- Table with a border -->
                    <tr> <!-- Table row for headers -->
                        <th>Route Id</th> <!-- Table header for route ID -->
                        <th>Source Airport Code</th> <!-- Table header for source airport code -->
                        <th>Destination Airport Code</th> <!-- Table header for destination airport code -->
                        <th>Fare</th>
                    </tr>
                    <c:forEach items="${routeList}" var="route"> <!-- Loop over each route in the routeList -->
                        <tr> <!-- Table row for each route -->
                            <td>${route.routeId}</td> <!-- Display route ID -->
                            <td>${route.sourceAirportCode}</td> <!-- Display source airport code -->
                            <td>${route.destinationAirportCode}</td> <!-- Display destination airport code -->
                            <td>${route.fare}</td> <!-- Display fare -->
                        </tr>
                    </c:forEach>
                </table>
                <br><br><br>
                <a href="i">Back to Home</a> <!-- Link to navigate back to the home page -->
            </div>
        </body>

        </html>