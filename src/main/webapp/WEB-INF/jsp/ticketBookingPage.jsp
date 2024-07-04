<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ticket Booking</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-5">
        <h2 class="mb-4">Book Your Ticket</h2>
        <form id="bookingForm" action="/ticket" method="POST">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Flight Number</label>
                        <input type="text" class="form-control" id="flightNumber" name="flightNumberDisplay" required
                            disabled>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Carrier Name</label>
                        <input type="text" class="form-control" id="carrierName" name="carrierNameDisplay" required
                            disabled>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Total Amount</label>
                        <input type="text" class="form-control" id="totalAmount" name="totalAmountDisplay" required
                            disabled>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>From</label>
                        <input type="text" class="form-control" id="fromLocation" name="fromLocationDisplay" required
                            disabled>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>To</label>
                        <input type="text" class="form-control" id="toLocation" name="toLocationDisplay" required
                            disabled>
                    </div>
                </div>
            </div>
            <!-- Hidden inputs for submitting data -->
            <input type="hidden" id="flightNumberHidden" name="flightNumber">
            <input type="hidden" id="carrierNameHidden" name="carrierName">
            <input type="hidden" id="totalAmountHidden" name="totalAmount">
            <input type="hidden" id="fromLocationHidden" name="fromLocation">
            <input type="hidden" id="toLocationHidden" name="toLocation">
            <!-- Passenger details section -->
            <div id="passengerDetails" class="mt-4">
                <h4>Passenger Details</h4>
                <!-- Placeholder for passenger fields -->
            </div>
            <button type="button" id="addPassenger" class="btn btn-info mt-3">Add Passenger</button>
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </form>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            let passengerCount = 0;

            function addPassenger() {
                passengerCount++;
                const passengerDiv = document.createElement('div');
                passengerDiv.classList.add('passenger-section');
                passengerDiv.innerHTML = `
                    <div class="form-group">
                        <label>Name:</label>
                        <input type="text" name="passengerName${passengerCount}" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>DOB:</label>
                        <input type="date" name="passengerDob${passengerCount}" class="form-control" required>
                    </div>
                    <button type="button" class="btn btn-danger removePassenger">Remove</button>
                `;
                document.getElementById('passengerDetails').appendChild(passengerDiv);

                // Remove passenger event
                passengerDiv.querySelector('.removePassenger').addEventListener('click', function () {
                    passengerDiv.remove();
                    passengerCount--;
                });
            }

            document.getElementById('addPassenger').addEventListener('click', function () {
                if (passengerCount < 6) {
                    addPassenger();
                }
            });

            document.getElementById('bookingForm').addEventListener('submit', function (e) {
                if (passengerCount === 0) {
                    alert('Please add at least one passenger.');
                    e.preventDefault(); // Prevent form submission
                }
            });

            // Initially add one passenger field
            addPassenger();

            // Simulate fetching and populating flight details
            function populateFlightDetails() {
                // Example data, replace with actual data fetching logic
                const flightDetails = {
                    flightNumber: 6546,
                    carrierName: 'Airways',
                    totalAmount: 5000.00,
                    fromLocation: 'City A',
                    toLocation: 'City B'
                };

                document.getElementById('flightNumber').value = flightDetails.flightNumber;
                document.getElementById('carrierName').value = flightDetails.carrierName;
                document.getElementById('totalAmount').value = flightDetails.totalAmount;
                document.getElementById('fromLocation').value = flightDetails.fromLocation;
                document.getElementById('toLocation').value = flightDetails.toLocation;

                // Populate hidden input fields with the same values
                document.getElementById('flightNumberHidden').value = flightDetails.flightNumber;
                document.getElementById('carrierNameHidden').value = flightDetails.carrierName;
                document.getElementById('totalAmountHidden').value = flightDetails.totalAmount;
                document.getElementById('fromLocationHidden').value = flightDetails.fromLocation;
                document.getElementById('toLocationHidden').value = flightDetails.toLocation;
            }

            populateFlightDetails();
        });
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>