<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Flight Management System</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-image: url('/images/flights.jpg');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                height: 100vh;
                margin: 0;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                color: #fff;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
            }

            .navbar {
                display: flex;
                justify-content: center;
                background-color: rgba(17, 0, 253, 0.9);
                /* background-color: rgba(70, 2, 251, 0.9); */
                padding: 10px 0;
                width: 100%;
                position: fixed;
                top: 0;
                z-index: 1000;
            }

            .navbar a {
                color: white;
                padding: 14px 20px;
                text-decoration: none;
                text-align: center;
                font-size: 16px;
                transition: background 0.3s ease;
            }

            .navbar a:hover {
                background-color: rgba(255, 255, 255, 0.3);
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #fff;
                min-width: 160px;
                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
                z-index: 1;
                border-radius: 4px;
                overflow: hidden;
            }

            .dropdown-content a {
                color: #333;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                text-align: left;
                transition: background 0.3s ease;
            }

            .dropdown-content a:hover {
                background-color: #f1f1f1;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .title {
                text-align: center;
                margin-top: 100px;
                font-size: 200px;
                font-weight: bold;
                color: rgba(48, 209, 234, 0.9);
            }
        </style>
    </head>

    <body>

        <div class="navbar">
            <div class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Airport</a>
                <div class="dropdown-content">
                    <a href="/airports">Airport Reports</a>
                </div>
            </div>

            <div class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Route</a>
                <div class="dropdown-content">
                    <a href="/routes">Routes Report</a>
                </div>
            </div>

            <div class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Flight</a>
                <div class="dropdown-content">
                    <a href="/flights">All Flights</a>
                </div>
            </div>

            <div class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Flight Booking</a>
                <div class="dropdown-content">
                    <a href="/searchflight">Flight Search</a>
                </div>
            </div>

            <div>
                <a href="/loginpage">Logout</a>
            </div>
        </div>

        <div class="title">
            AeroBlasters
        </div>

    </body>

    </html>