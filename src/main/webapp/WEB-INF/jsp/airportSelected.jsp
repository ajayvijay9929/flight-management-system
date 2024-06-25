<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- JSP directive for setting page language, content type, and encoding -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Import JSTL core library for use in JSP -->
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!-- Import Spring form tag library for form handling -->
            <!DOCTYPE html> <!-- HTML5 document type declaration -->
            <html>

            <head>
                <meta charset="UTF-8"> <!-- Specifies the character encoding for the HTML document -->
                <title>Insert title here</title> <!-- Placeholder for the page title -->
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
                <div align="center"> <!-- Centers the content within a div -->
                    <h2> <!-- Heading level 2 for form title -->
                        <form action="/airport-select" method="post">
                            <!-- Form for selecting an airport code, posts to /airport-select -->
                            Select Airport Code : <input list="allCodes" name="airport-code" id="airport-code" />
                            <!-- Input field with a datalist for airport codes -->
                            <datalist id="allCodes"> <!-- Datalist element containing options for airport codes -->
                                <c:forEach items="${codeList}" var="aircode">
                                    <!-- Iterates over codeList, assigning each item to aircode -->
                                    <option value="${aircode}" />
                                    <!-- Option element for each airport code, value set dynamically -->
                                </c:forEach>
                            </datalist>
                            <br /><br /> <!-- Line breaks for spacing -->
                            <button type="submit">Submit</button> <!-- Submit button for the form -->
                    </h2>
                    <a href="i">Back to Home</a>
                    <!-- Link to navigate back to the home page, href value is a placeholder -->
                </div>
                </form>
                <!-- Closing form tag should be inside the div but is outside, which is incorrect HTML structure -->
            </body>

            </html>