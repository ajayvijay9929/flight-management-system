<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Directive to set the page language, content type, and encoding -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!-- Import Spring form tag library for form handling -->

        <!DOCTYPE html> <!-- HTML5 document type declaration -->
        <html>

        <head>
            <meta charset="UTF-8"> <!-- Character encoding declaration -->
            <title>Insert title here</title> <!-- Placeholder for the page title -->
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
                <h3> <!-- Heading level 3 for form title -->
                    <form:form action="/route" method="post" modelAttribute="routeRecord">
                        <!-- Spring form for route entry, specifying action, method, and model attribute -->
                        <form:hidden path="routeId" /> <!-- Hidden form field to store route ID -->
                        <table> <!-- Table layout for form inputs -->
                            <tr> <!-- Table row for source city input -->
                                <td> <!-- Table cell for label -->
                                    Enter Source City: </td> <!-- Label for source city input -->
                                <td>
                                    <form:input path="sourceAirportCode" />
                                </td> <!-- Spring form input for source city -->
                            </tr>
                            <tr> <!-- Table row for destination city input -->
                                <td> <!-- Table cell for label -->
                                    Enter Destination City: </td> <!-- Label for destination city input -->
                                <td>
                                    <form:input path="destinationAirportCode" />
                                </td> <!-- Spring form input for destination city -->
                            </tr>
                        </table>
                        <button type="submit">Submit</button> <!-- Submit button for the form -->
                        <button type="reset">Reset</button> <!-- Reset button to clear the form -->
                    </form:form>
                </h3>
                <a href="i">Back to Home</a> <!-- Link to navigate back to the home page -->
            </div>
        </body>

        </html>