<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- JSP directive specifying the page language, content type, and encoding -->
    <!DOCTYPE html> <!-- HTML5 document type declaration -->
    <html>

    <head>
        <meta charset="UTF-8"> <!-- Specifies the character encoding for the HTML document -->
        <title>Airport Details</title> <!-- Sets the title of the web page -->
        <style>
            body {
                font-family: Arial, sans-serif;
                /* Sets the font family for the body */
                background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg');
                /* Sets the background image */
                background-size: cover;
                /* Ensures the background image covers the entire page */
                background-position: center;
                /* Centers the background image */
                background-repeat: no-repeat;
                /* Prevents the background image from repeating */
                height: 100vh;
                /* Sets the height of the body to 100% of the viewport height */
                margin: 0;
                /* Removes the default margin */
            }
        </style>

    </head>

    <body>
        <div align="center"> <!-- Centers the content within the div -->
            <i>
                <h1>Airport Details</h1>
            </i> <!-- Displays the page heading in italic -->
            <table> <!-- Starts a table -->
                <tr> <!-- Table row -->
                    <h1> <!-- Incorrect use of <h1> tag inside a <tr>, likely intended for styling purposes -->
                        <td>Airport Code:</td> <!-- Table cell for the label "Airport Code:" -->
                        <td>${airport.airportCode}</td>
                        <!-- Table cell displaying the airport code, dynamically filled with server-side data -->
                </tr> <!-- Ends the table row -->
                <tr> <!-- Table row -->
                    <td>Airport Location:</td> <!-- Table cell for the label "Airport Location:" -->
                    <td>${airport.airportLocation}</td>
                    <!-- Table cell displaying the airport location, dynamically filled with server-side data -->
                </tr>
                </h1> <!-- Incorrect closing of <h1> tag, not valid HTML -->
            </table> <!-- Ends the table -->
            <br /><br /> <!-- Adds two line breaks for spacing -->
            <a href="i">Back to Home</a>
            <!-- Provides a link to navigate back to the home page, though the href attribute's value is a placeholder -->
    </body>

    </html>