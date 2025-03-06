<%-- 
    Document   : service
    Created on : Feb 11, 2025, 12:36:07 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banking Services</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <style>
            :root {
                --primary-color: #dc3545;
                --secondary-color: #6c757d;
            }

            body {
                background-color: #f8f9fa;
            }

            .service-header {
                background: linear-gradient(135deg, #dc3545, #c82333);
                color: white;
                padding: 3rem 0;
                margin-bottom: 2rem;
                text-align: center;
            }

            .service-card {
                background: white;
                border: none;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                transition: transform 0.3s, box-shadow 0.3s;
                margin-bottom: 2rem;
                border-radius: 12px;
                overflow: hidden;
                height: 100%;
            }

            .service-card:hover {
                transform: translateY(-5px);
                box-shadow: 0 4px 20px rgba(220,53,69,0.2);
            }

            .service-icon {
                font-size: 3rem;
                margin: 1.5rem 0;
                color: var(--primary-color);
            }

            .service-title {
                color: #202124;
                font-size: 1.5rem;
                font-weight: 600;
                margin-bottom: 1rem;
            }

            .service-type-badge {
                display: inline-block;
                padding: 0.4rem 1rem;
                border-radius: 20px;
                font-size: 0.875rem;
                font-weight: 500;
                margin-bottom: 1rem;
            }

            .service-type-badge.saving {
                background-color: #fce8e6;
                color: #c82333;
            }

            .service-type-badge.loan {
                background-color: #fce8e6;
                color: #c82333;
            }

            .service-type-badge.deposit {
                background-color: #fce8e6;
                color: #c82333;
            }

            .service-type-badge.withdrawal {
                background-color: #fce8e6;
                color: #c82333;
            }

            .service-description {
                color: var(--secondary-color);
                margin-bottom: 1.5rem;
                line-height: 1.6;
            }

            .btn-learn-more {
                background-color: var(--primary-color);
                color: white;
                border: none;
                padding: 0.5rem 1.5rem;
                border-radius: 25px;
                font-weight: 500;
                transition: background-color 0.3s;
            }

            .btn-learn-more:hover {
                background-color: #c82333;
                color: white;
            }

            .service-inactive {
                opacity: 0.7;
            }

            .service-card .card-body {
                padding: 1.5rem;
                display: flex;
                flex-direction: column;
                height: 100%;
            }

            .service-footer {
                margin-top: auto;
                padding-top: 1rem;
            }
            nav {
                text-align: center;
                margin: 20px 0;
            }

            nav ul {
                list-style-type: none;
                padding: 0;
                display: inline-block;
                background: #e74c3c; /* Màu đỏ chủ đạo */
                padding: 12px 25px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(231, 76, 60, 0.4);
            }

            nav ul li {
                display: inline;
                margin: 0 15px;
            }

            nav ul li a {
                text-decoration: none;
                color: white;
                font-size: 18px;
                font-weight: bold;
                padding: 10px 15px;
                transition: 0.3s ease-in-out;
                border-radius: 5px;
                position: relative;
            }

            nav ul li a::after {
                content: "";
                display: block;
                width: 0;
                height: 3px;
                background: white;
                position: absolute;
                left: 50%;
                bottom: -5px;
                transition: width 0.3s ease-in-out, left 0.3s ease-in-out;
            }

            nav ul li a:hover::after {
                width: 100%;
                left: 0;
            }

            nav ul li a:hover {
                background: #c0392b; /* Màu đỏ đậm hơn */
                box-shadow: 0 3px 6px rgba(192, 57, 43, 0.5);
            }



        </style>
    </head>
    <body>

        <!-- Header Section -->
        <div class="service-header">
            <div class="container">
                <h1 class="display-4"><i class="bi bi-bank"></i> Banking Services</h1>
                <p class="lead">Discover our range of financial services</p>
            </div>
        </div>

        <!-- Navigation Bar -->
        <nav style="text-align: center; margin: 20px 0;">
            <ul style="list-style-type: none; padding: 0; display: inline-block;">
                <li style="display: inline; margin: 0 15px;"><a href="home">Home</a></li>
                <li style="display: inline; margin: 0 15px;"><a href="about.jsp">About</a></li>
                <li style="display: inline; margin: 0 15px;"><a href="services.jsp">Services</a></li>
                <li style="display: inline; margin: 0 15px;"><a href="team.jsp">Team</a></li>
                <li style="display: inline; margin: 0 15px;"><a href="contact.jsp">Contact Us</a></li>
                <li style="display: inline; margin: 0 15px;"><a href="news.jsp">News</a></li>
            </ul>
        </nav>

        <!-- Main Content -->
        <div class="container">
            <!-- Services Grid -->
            <div class="row g-4">
                <c:forEach items="${listServices}" var="s">
                    <div class="col-md-4">
                        <div class="service-card ${s.status != 'active' ? 'service-inactive' : ''}">
                            <div class="card-body text-center">
                                <div class="service-icon">
                                    <c:choose>
                                        <c:when test="${s.service_type == 'Saving'}">
                                            <i class="bi bi-piggy-bank"></i>
                                        </c:when>
                                        <c:when test="${s.service_type == 'Loan'}">
                                            <i class="bi bi-cash-coin"></i>
                                        </c:when>
                                        <c:when test="${s.service_type == 'Deposit'}">
                                            <i class="bi bi-safe"></i>
                                        </c:when>
                                        <c:when test="${s.service_type == 'Withdrawal'}">
                                            <i class="bi bi-cash-stack"></i>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <h3 class="service-title">${s.service_name}</h3>
                                <div class="service-type-badge ${s.service_type.toLowerCase()}">
                                    <c:choose>
                                        <c:when test="${s.service_type == 'Saving'}">
                                            Savings
                                        </c:when>
                                        <c:when test="${s.service_type == 'Loan'}">
                                            Loans
                                        </c:when>
                                        <c:when test="${s.service_type == 'Deposit'}">
                                            Deposits
                                        </c:when>
                                        <c:when test="${s.service_type == 'Withdrawal'}">
                                            Withdrawals
                                        </c:when>
                                    </c:choose>
                                </div>
                                <p class="service-description">
                                    ${s.description}
                                </p>
                                <div class="service-footer">
                                    <c:if test="${s.status == 'active'}">
                                        <a href="Service?action=details&id=${s.service_id}" 
                                           class="btn btn-learn-more">
                                            <i class="bi bi-arrow-right-circle"></i> Learn More
                                        </a>
                                    </c:if>
                                    <c:if test="${s.status != 'active'}">
                                        <button class="btn btn-secondary" disabled>
                                            <i class="bi bi-clock"></i> Currently Unavailable
                                        </button>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- No Services Message -->
            <c:if test="${empty listServices}">
                <div class="alert alert-info text-center">
                    <i class="bi bi-info-circle"></i> No services available at the moment.
                </div>
            </c:if>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
