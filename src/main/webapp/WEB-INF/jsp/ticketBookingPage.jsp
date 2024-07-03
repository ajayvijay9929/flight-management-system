<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ticket Booking</title>
    <!-- Bootstrap for styling -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-5">
        <h2>Book Your Ticket</h2>
        <form action="/ticket" method="POST">
            <!-- Hidden field for ticket number -->
            <!-- <input type="number" id="ticketNumber" name="ticketNumber" value="${ticket.ticketNumber}"> -->
            <div class="form-group">
                <label for="routeId">Route ID</label>
                <input type="number" class="form-control" id="routeId" name="routeId" required>
            </div>
            <div class="form-group">
                <label for="flightNumber">Flight Number</label>
                <input type="number" class="form-control" id="flightNumber" name="flightNumber" required>
            </div>
            <div class="form-group">
                <label for="carrierName">Carrier Name</label>
                <input type="text" class="form-control" id="carrierName" name="carrierName" required minlength="1"
                    maxlength="100">
            </div>
            <div class="form-group">
                <label for="totalAmount">Total Amount</label>
                <input type="number" step="0.01" class="form-control" id="totalAmount" name="totalAmount" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>