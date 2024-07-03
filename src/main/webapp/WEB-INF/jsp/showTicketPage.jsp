<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ticket Confirmation</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container mt-5">
            <h2 class="mb-4">Ticket Confirmation</h2>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Booking Details</h5>
                    <p class="card-text"><strong>Ticket Number:</strong> ${ticket.ticketNumber}</p>
                    <p class="card-text"><strong>Carrier Name:</strong> ${ticket.carrierName}</p>
                    <p class="card-text"><strong>Flight Number:</strong> ${ticket.flightNumber}</p>
                    <p class="card-text"><strong>Route Id:</strong> ${ticket.routeId}</p>
                    <p class="card-text"><strong>Total Amount:</strong> ${ticket.totalAmount}</p>
                </div>
            </div>
            <a href="/ticket" class="btn btn-primary mt-4">Book More Tickets</a>
        </div>

        <!-- Bootstrap JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>