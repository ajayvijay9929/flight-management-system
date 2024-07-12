<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Book Ticket</title>
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
                    background-color: rgba(255, 255, 255, 0.75);
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

            <div align="center">
                <form:form action="/ticket" method="post" modelAttribute="ticketRecord">
                    <form:hidden path="ticketNumber" />
                    <form:hidden path="flightNumber" />
                    <form:hidden path="carrierName" />
                    <input type="hidden" name="fromLocation" value="${route.sourceAirportCode}" />
                    <input type="hidden" name="toLocation" value="${route.destinationAirportCode}" />
                    <input type="hidden" name="routeId" value="${route.routeId}" />
                    <input type="hidden" name="totalAmount" value="${route.fare}" />
                    <h3>
                        <table>
                            <tr>
                                <td><label class="required">Ticket Number : </label>
                                    <form:input path="ticketNumber" disabled="true" />
                                </td>
                                <td><label class="required">Flight Number : </label>
                                    <form:input path="flightNumber" disabled="true" />
                                </td>
                                <td><label class="required">Airlines Name : </label>
                                    <form:input path="carrierName" disabled="true" />
                                </td>
                            </tr>
                            <tr>
                                <td><label class="required">From : </label><input type="text"
                                        value="${route.sourceAirportCode}" disabled="true" /></td>>
                                <td><label class="required">To : </label><input type="text"
                                        value="${route.destinationAirportCode}" disabled="true" /></td>>
                                <td><label class="required">Fare : </label><input type="text" value="${route.fare}"
                                        disabled="true" /></td>>
                            </tr>
                        </table>

                        <br /><br /><br /><br />

                        Enter Passenger Details :
                        <table>
                            <tr>
                                <td>Name : <input type="text" name="name1" value="--" placeholder="John Doe"></td>
                                <td>Date Of Birth : <input type="date" name="dob1" pattern="\d{1,2}-\d{1,2}-\d{4}"
                                        placeholder="DD-MM-YYYY" required></td>
                            </tr>

                            <tr>
                                <td>Name : <input type="text" name="name2" value="--" placeholder="John Doe"></td>
                                <td>Date Of Birth : <input type="date" name="dob2" pattern="\d{1,2}-\d{1,2}-\d{4}"
                                        placeholder="DD-MM-YYYY"></td>
                            </tr>

                            <tr>
                                <td>Name : <input type="text" name="name3" value="--" placeholder="John Doe"></td>
                                <td>Date Of Birth : <input type="date" name="dob3" pattern="\d{1,2}-\d{1,2}-\d{4}"
                                        placeholder="DD-MM-YYYY"></td>
                            </tr>

                            <tr>
                                <td>Name : <input type="text" name="name4" value="--" placeholder="John Doe"></td>
                                <td>Date Of Birth : <input type="date" name="dob4" pattern="\d{1,2}-\d{1,2}-\d{4}"
                                        placeholder="DD-MM-YYYY"></td>
                            </tr>

                            <tr>
                                <td>Name : <input type="text" name="name5" value="--" placeholder="John Doe"></td>
                                <td>Date Of Birth : <input type="date" name="dob5" pattern="\d{1,2}-\d{1,2}-\d{4}"
                                        placeholder="DD-MM-YYYY"></td>
                            </tr>

                            <tr>
                                <td>Name : <input type="text" name="name6" value="--" placeholder="John Doe"></td>
                                <td>Date Of Birth : <input type="date" name="dob6" pattern="\d{1,2}-\d{1,2}-\d{4}"
                                        placeholder="DD-MM-YYYY"></td>
                            </tr>

                        </table>
                    </h3>

                    <button type="submit">Submit</button>

                </form:form>
            </div>
        </body>

        </html>