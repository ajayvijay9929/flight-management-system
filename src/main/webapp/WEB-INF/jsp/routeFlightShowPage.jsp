<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Flight Details</title>
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
            <style>
                body {
                    font-family: Arial, sans-serif;
                    background-image: url('/images/flights.jpg');
                    background-size: cover;
                    background-position: center;
                    background-repeat: no-repeat;
                    height: 100vh;
                    margin: 0;
                    background-color: #f8f9fa;
                }

                .details-container {
                    margin-top: 50px;
                    padding: 30px;
                    background-color: #fff;
                    border-radius: 10px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                }

                .details-title {
                    margin-bottom: 20px;
                }

                .home-link {
                    margin-top: 20px;
                    display: block;
                    text-align: center;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-8 details-container text-center">
                        <h1 class="details-title"><i>Flight Details</i></h1>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Flight Number</th>
                                    <th>Airlines Name</th>
                                    <th>Route Id</th>
                                    <th>Departure</th>
                                    <th>Arrival</th>
                                    <th>Fare</th>
                                    <th>Booking</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="flight" items="${flightList}">
                                    <tr>
                                        <td>${flight.flightNumber}</td>
                                        <td>${flight.carrierName}</td>
                                        <td>${flight.routeId}</td>
                                        <td>${flight.departure}</td>
                                        <td>${flight.arrival}</td>
                                        <!-- need to fix -->
                                        <td>5000</td>
                                        <td><a href="/ticket/${flight.flightNumber}"
                                                class="btn btn-danger bookTicketLink"
                                                flightNumber="${flight.flightNumber}"
                                                carrierName="${flight.carrierName}" data-route-id="${flight.routeId}"
                                                data-departure="${flight.departure}"
                                                data-arrival="${flight.arrival}">Book Ticket</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <a href="/airports" class="home-link btn btn-primary">Back to Home</a>
                    </div>
                </div>
            </div>

            <!-- <script>
                document.addEventListener('DOMContentLoaded', function () {
                    // Select all links with the class 'bookTicketLink'
                    document.querySelectorAll('.bookTicketLink').forEach(function (link) {
                        link.addEventListener('click', function (e) {
                            e.preventDefault(); // Prevent the default link behavior

                            // Extract the 'id' from the href attribute
                            const href = this.getAttribute('href');
                            const id = href.split('/').pop(); // Assuming the 'id' is the last part of the URL

                            console.log(id); // For demonstration, shows the 'id' in the console

                            // You can now use the 'id' for further processing, such as making an AJAX request
                            // or redirecting the user to another page with this 'id' as part of the URL.
                        });
                    });
                });
            </script> -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        </body>

        </html>