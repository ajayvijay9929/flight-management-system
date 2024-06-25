<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!-- Page directive setting the language, content type, and encoding -->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Importing JSTL core library -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <!-- Importing Spring form tag library for form handling -->
      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="UTF-8"> <!-- Setting character encoding for the document -->
        <title>Insert title here</title> <!-- Placeholder title for the page -->
        <style>
          body {
            font-family: Arial, sans-serif;
            /* Setting the font for the page */
            background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg');
            /* Background image for the page */
            background-size: cover;
            /* Ensuring the background image covers the entire page */
            background-position: center;
            /* Centering the background image */
            background-repeat: no-repeat;
            /* Preventing the background image from repeating */
            height: 100vh;
            /* Setting the height of the body to 100% of the viewport height */
            margin: 0;
            /* Removing the default margin */
          }
        </style>
      </head>

      <body>
        <div align="center"> <!-- Centering the content inside the div -->
          <h3>
            <form:form id="airportForm" action="/airport" method="post" modelAttribute="airport_data">
              <!-- Spring form for submitting airport data -->
              <table> <!-- Using a table for form layout -->
                <tr>
                  <td>
                    Enter Airport City: </td> <!-- Label for airport city input -->
                  <td>
                    <form:input path="airportLocation" />
                  </td> <!-- Input field for airport city -->
                </tr>
                </br></br> <!-- Breaks for spacing, not typically recommended inside <table> -->
                <tr>
                  <td>
                    Enter Airport Code: </td> <!-- Label for airport code input -->
                  <td>
                    <form:input path="airportCode" />
                  </td> <!-- Input field for airport code -->
                </tr>
              </table>
              <button type="submit">Submit</button> <!-- Submit button for the form -->
              <button type="reset">Reset</button> <!-- Reset button to clear the form -->
            </form:form>
          </h3>
          <a href="i">Back to Home</a> <!-- Link to go back to the home page, href value seems to be a placeholder -->
        </div>
      </body>

      </html>