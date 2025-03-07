<%-- 
    Document   : headerHome
    Created on : Feb 24, 2025, 3:37:57 PM
    Author     : Hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <header>

        <div class="header-top-bar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6">
                        <ul class="top-bar-info list-inline-item pl-0 mb-0">
                            <li class="list-inline-item"><a href="mailto:support@gmail.com"><i
                                        class="icofont-support-faq mr-2"></i>support@novena.com</a></li>
                            <li class="list-inline-item"><i class="icofont-location-pin mr-2"></i>Address Ta-134/A, New
                                York, USA </li>
                        </ul>
                    </div>
                    <div class="col-lg-6">
                        <div class="text-lg-right top-right-bar mt-2 mt-lg-0">
                            <a href="tel:+23-345-67890">
                                <span>Call Now : </span>
                                <span class="h4">823-4565-13456</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <nav class="navbar navbar-expand-lg navigation" id="navbar">
            <div class="container">
                <a class="navbar-brand" href="index_1.jsp">
                    <img src="assets2/images/logo.png" alt="" class="img-fluid">
                </a>

                <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarmain"
                        aria-controls="navbarmain" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icofont-navigation-menu"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarmain">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index_1.jsp">Home</a>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="loadservice">Services</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="department.html" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Department <i class="icofont-thin-down"></i></a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown02">
                                <li><a class="dropdown-item" href="department.jsp">Departments</a></li>
                                <li><a class="dropdown-item" href="department-single.jsp">Department Single</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="doctor.jsp" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Doctors <i class="icofont-thin-down"></i></a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown03">
                                <li><a class="dropdown-item" href="doctor.jsp">Doctors</a></li>
                                <li><a class="dropdown-item" href="doctor-single.jsp">Doctor Single</a></li>
                                <li><a class="dropdown-item" href="appointment">Appointment</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">News<i class="icofont-thin-down"></i></a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown05">
                                <li><a class="dropdown-item" href="allNews">All News</a></li>
                                    <%--<c:forEach var="cate" items="${listCate}">--%> 
                                    <!--<li><a class="dropdown-item" href="allNews?categoryID=${cate.category_id}">${cate.name}</a></li>-->
                                    <%--</c:forEach>--%>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="dropdown show">
                <c:if test="${sessionScope.customerAccount == null && sessionScope.staffAccount == null}">
                    <a class="btn btn-secondary dropdown" href="login.jsp" role="button" id="dropdownMenuLink"
                       data-toggle="" aria-haspopup="true" aria-expanded="false">
                        Login
                    </a>
                </c:if>

                <c:if test="${sessionScope.customerAccount != null}">
                    <a class="btn btn-secondary dropdown" href="" role="button" id="dropdownMenuLink"
                       data-toggle="" aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.customerAccount.fullName}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="profile.jsp">Profile</a>
                        <!-- <a class="dropdown-item" href="#"></a> -->
                        <a class="dropdown-item" href="logout">Logout</a>
                    </div>
                </c:if>

                <c:if test="${sessionScope.staffAccount != null}">
                    <a class="btn btn-secondary dropdown" href="" role="button" id="dropdownMenuLink"
                       data-toggle="" aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.staffAccount.fullName}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="profile.jsp">Profile</a>
                        <!-- <a class="dropdown-item" href="#"></a> -->
                        <a class="dropdown-item" href=logout>Logout</a>
                    </div>
                </c:if>

            </div>
        </nav>
    </header>
</html>
