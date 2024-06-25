<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- JSP directive specifying page language, content type, and encoding -->
    <!DOCTYPE html> <!-- Declares the document type and version of HTML -->
    <html>

    <head>
        <meta charset="UTF-8"> <!-- Specifies the character encoding for the HTML document -->
        <title>Insert title here</title> <!-- Placeholder for the page title -->
    </head>

    <body>

        <div align="center"> <!-- Centers the content within the div -->
            <h2 style="color:red"> <!-- Heading with red color indicating an error or warning message -->

                Wrong credentials... <!-- Displays an error message for wrong credentials -->

            </h2>
        </div>
        <jsp:include page="loginPage.jsp"></jsp:include>
        <!-- Includes the content of loginPage.jsp within this page, typically a login form -->

    </body>

    </html>