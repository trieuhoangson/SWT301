

<%@ page import=" java.util.List, model.Professional" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Orbitor,business,company,agency,modern,bootstrap4,tech,software">
        <meta name="author" content="themefisher.com">

        <title>Novena- Health & Care Medical template</title>

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico" />

        <!-- bootstrap.min css -->
        <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
        <!-- Icon Font Css -->
        <link rel="stylesheet" href="plugins/icofont/icofont.min.css">
        <!-- Slick Slider  CSS -->
        <link rel="stylesheet" href="plugins/slick-carousel/slick/slick.css">
        <link rel="stylesheet" href="plugins/slick-carousel/slick/slick-theme.css">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/select2.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <!-- Main Stylesheet -->
        <link rel="stylesheet" href="css/style.css">
        <style>
            /* Ẩn checkbox gốc */
            .filter-checkbox {
                display: none;
            }

            .filter-buttons {
                display: flex;
                gap: 10px; /* Khoảng cách giữa các nút */
            }

            /* Ẩn checkbox gốc */
            .filter-checkbox {
                display: none;
            }

            /* Tạo button từ label */
            .filter-buttons label {
                background-color: #f0f0f0;
                border: 1px solid #ccc;
                border-radius: 8px;
                padding: 10px 15px;
                font-size: 16px;
                font-weight: bold;
                color: #333;
                cursor: pointer;
                transition: all 0.3s ease;
                display: inline-block;
                text-align: center;
            }

            /* Khi checkbox được chọn, đổi màu label */
            .filter-checkbox:checked + label {
                background-color: #007bff;
                color: white;
                border-color: #007bff;
            }

            /* Hiệu ứng hover */
            .filter-buttons label:hover {
                background-color: #e0e0e0;
            }
            /* Đảm bảo các nút radio có kích thước cố định */
            /* Tùy chỉnh checkbox vuông vắn */
            .filter-options input[type="checkbox"] {
                appearance: none; /* Ẩn checkbox mặc định */
                width: 18px;
                height: 18px;
                border: 2px solid #004a99; /* Viền xanh đậm */
                border-radius: 4px; /* Giữ vuông hoặc bo góc nhẹ */
                cursor: pointer;
                display: inline-block;
                position: relative;
                vertical-align: middle;
                background-color: white;
                transition: all 0.3s ease;
            }

            /* Khi được chọn */
            .filter-options input[type="checkbox"]:checked {
                background-color: #004a99;
                border-color: #004a99;
            }

            /* Dấu check (✔) */
            .filter-options input[type="checkbox"]::after {
                content: "✔";
                font-size: 14px;
                color: white;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                display: none;
            }
            .filter-buttons {
                display: flex;
                gap: 10px; /* Khoảng cách giữa các nút */
            }



            /* Tạo button từ label */
            .filter-buttons label {
                background-color: #f0f0f0;
                border: 1px solid #ccc;
                border-radius: 8px;
                padding: 10px 15px;
                font-size: 16px;
                font-weight: bold;
                color: #333;
                cursor: pointer;
                transition: all 0.3s ease;
                display: inline-block;
                text-align: center;
            }

            /* Khi checkbox được chọn, đổi màu label */
            .filter-checkbox:checked + label {
                background-color: #007bff;
                color: white;
                border-color: #007bff;
            }

            /* Hiệu ứng hover */
            .filter-buttons label:hover {
                background-color: #e0e0e0;
            }

            .filter-options input[type="checkbox"]:checked::after {
                display: block;
            }

            /* Định dạng tổng quan */
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
            }

            /* Header */
            .page-header {
                background-color: #004a99; /* Xanh đậm */
                color: white;
                padding: 15px 20px;
                text-align: center;
                font-size: 24px;
                font-weight: bold;
            }

            /* Container chính */
            .content {
                max-width: 1200px;
                margin: auto;
                padding: 20px;
            }

            /* Thanh tìm kiếm và bộ lọc */
            .row {
                display: flex;
                flex-wrap: wrap;
                margin-bottom: 15px;
                justify-content: space-between;
                align-items: center;
            }

            .filter-options {
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                align-items: center;
            }

            .filter-options label {
                font-size: 14px;
                font-weight: bold;
            }

            .filter-options input[type="checkbox"] {
                margin-right: 5px;
            }

            /* Ô nhập tìm kiếm */
            #searchName {
                width: 100%;
                max-width: 400px;
                padding: 8px 10px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            /* Ảnh bác sĩ lớn hơn */
            .doctor-img {
                width: 100%;
                height: 160px; /* Tăng chiều cao lên */
                overflow: hidden;
            }

            .doctor-img img {
                width: 100%;
                height: 100%;
                object-fit: cover; /* Giữ ảnh không méo */
                border-bottom: 2px solid #004a99;
            }

            /* Giảm kích thước thông tin bác sĩ */
            .profile-widget {
                padding: 10px;
                font-size: 13px; /* Nhỏ hơn */
            }

            .doctor-name {
                font-size: 16px; /* Nhỏ hơn */
                font-weight: bold;
                color: #004a99;
                margin: 5px 0;
            }

            .doc-prof {
                font-size: 12px; /* Nhỏ hơn */
                font-style: italic;
                color: #666;
            }

            .user-country {
                font-size: 11px; /* Nhỏ hơn */
                color: #777;
                margin-top: 3px;
                word-wrap: break-word; /* Ngăn chữ tràn ra */
            }

            /* Giới hạn chiều cao nội dung để không làm thẻ bị phình to */
            .doctor-item {
                width: 250px;
                height: 370px; /* Định chiều cao cố định */
                display: flex;
                flex-direction: column;
                justify-content: space-between;
                overflow: hidden;
            }


            /* Nút hành động */
            .dropdown.profile-action {
                position: relative;
                text-align: right;
                margin-bottom: 5px;
            }

            .action-icon {
                color: #004a99;
                font-size: 18px;
                cursor: pointer;
            }

            /* Menu hành động */
            .dropdown-menu {
                position: absolute;
                top: 30px;
                right: 0;
                background: white;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
                display: none;
            }

            .dropdown-menu a {
                display: block;
                padding: 8px 15px;
                color: black;
                text-decoration: none;
                transition: background 0.3s ease;
            }

            .dropdown-menu a:hover {
                background: #f1f1f1;
            }

            /* Hiển thị menu khi click */
            .profile-action:hover .dropdown-menu {
                display: block;
            }

            /* Nút hành động */
            button {
                padding: 8px 12px;
                border-radius: 5px;
                border: none;
                font-size: 14px;
                cursor: pointer;
            }

            button.schedule {
                background: #004a99;
                color: white;
            }

            button.view-detail {
                background: #28a745;
                color: white;
            }


        </style>
    </head>

    <body id="top">

        <header>
            <div class="header-top-bar">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-6">
                            <ul class="top-bar-info list-inline-item pl-0 mb-0">
                                <li class="list-inline-item"><a href="mailto:support@gmail.com"><i class="icofont-support-faq mr-2"></i>support@novena.com</a></li>
                                <li class="list-inline-item"><i class="icofont-location-pin mr-2"></i>Address Ta-134/A, New York, USA </li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <div class="text-lg-right top-right-bar mt-2 mt-lg-0">
                                <a href="tel:+23-345-67890" >
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
                    <a class="navbar-brand" href="index_1.html">
                        <img src="images/logo.png" alt="" class="img-fluid">
                    </a>

                    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarmain" aria-controls="navbarmain" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icofont-navigation-menu"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarmain">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="index_1.html">Home</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="about.html">About</a></li>
                            <li class="nav-item"><a class="nav-link" href="service.html">Services</a></li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="department.html" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Department <i class="icofont-thin-down"></i></a>
                                <ul class="dropdown-menu" aria-labelledby="dropdown02">
                                    <li><a class="dropdown-item" href="department.html">Departments</a></li>
                                    <li><a class="dropdown-item" href="department-single.html">Department Single</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="doctor.html" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Doctors <i class="icofont-thin-down"></i></a>
                                <ul class="dropdown-menu" aria-labelledby="dropdown03">
                                    <li><a class="dropdown-item" href="doctor.html">Doctors</a></li>
                                    <li><a class="dropdown-item" href="doctor-single.html">Doctor Single</a></li>
                                    <li><a class="dropdown-item" href="appoinment.html">Appoinment</a></li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="blog-sidebar.html" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Blog <i class="icofont-thin-down"></i></a>
                                <ul class="dropdown-menu" aria-labelledby="dropdown05">
                                    <li><a class="dropdown-item" href="blog-sidebar.html">Blog with Sidebar</a></li>

                                    <li><a class="dropdown-item" href="blog-single.html">Blog Single</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>



        <section class="page-title bg-1">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block text-center">
                            <span class="text-white">All Doctors</span>
                            <h1 class="text-capitalize mb-5 text-lg">Specalized doctors</h1>

                            <!-- <ul class="list-inline breadcumb-nav">
                              <li class="list-inline-item"><a href="index.html" class="text-white">Home</a></li>
                              <li class="list-inline-item"><span class="text-white">/</span></li>
                              <li class="list-inline-item"><a href="#" class="text-white-50">All Doctors</a></li>
                            </ul> -->
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <!-- portfolio -->
        <div class="page-wrapper">
            <div class="content">


                <!-- Search & Filter -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <input type="text" id="searchName" class="form-control" placeholder="Search by name...">
                    </div>
                    <div class="col-md-6">
                        <div class="filter-options filter-buttons">

                            <c:forEach var="specialization" items="${sessionScope.specializations}">
                                <label class="mr-3">
                                    <input  type="checkbox" display="none" class="filter-specialization filter-checkbox" value="${specialization}"> 
                                    ${specialization}
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <!-- Doctor Grid -->
                <div class="row doctor-grid" id="doctorList">
                    <c:forEach var="professional" items="${sessionScope.professionals}">
                        <div class="col-md-4 col-sm-4 col-lg-3 doctor-item" data-name="${professional.getName().toLowerCase()}" data-specialization="${professional.getSpecialization()}">
                            <div class="profile-widget">
                                <div class="doctor-img">
                                    <a class="" href="DetailDoctorServlet?id=${professional.getStaffID()}">
                                        <img alt="" src="${professional.getProfilePicture()}">
                                    </a>
                                </div>
                                <c:if test="${sessionScope.role eq 'admin'}">
                                    <div class="dropdown profile-action">
                                        <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown">
                                            <i class="fa fa-ellipsis-v"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="EditProfessionalServlet?id=${professional.getStaffID()}">
                                                <i class="fa fa-pencil m-r-5"></i> Edit
                                            </a>
                                            <a class="dropdown-item" href="DeleteProfessionalServlet?id=${professional.getStaffID()}" 
                                               onclick="return confirm('Are you sure you want to delete this professional?');">
                                                <i class="fa fa-trash-o m-r-5"></i> Delete
                                            </a>
                                        </div>
                                    </div>
                                </c:if>
                                <h4 class="doctor-name text-ellipsis">
                                    <a href="profile.html">${professional.getName()}</a>
                                </h4>
                                <div class="doc-prof">${professional.getSpecialization()}</div>
                                <div class="user-country">
                                    <i class="fa fa-map-marker"></i>
                                    ${professional.getAddress()}, ${professional.getBiography()}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>


            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const searchInput = document.getElementById("searchName");
                const specializationFilters = document.querySelectorAll(".filter-specialization");
                const doctorItems = document.querySelectorAll(".doctor-item");

                function filterDoctors() {
                    const searchText = searchInput.value.toLowerCase();
                    const selectedSpecializations = Array.from(specializationFilters)
                            .filter(checkbox => checkbox.checked)
                            .map(checkbox => checkbox.value);

                    doctorItems.forEach(item => {
                        const name = item.getAttribute("data-name");
                        const specialization = item.getAttribute("data-specialization");

                        const matchesName = name.includes(searchText);
                        const matchesSpecialization = selectedSpecializations.length === 0 || selectedSpecializations.includes(specialization);

                        item.style.display = (matchesName && matchesSpecialization) ? "block" : "none";
                    });
                }

                searchInput.addEventListener("input", filterDoctors);
                specializationFilters.forEach(checkbox => checkbox.addEventListener("change", filterDoctors));
            });
            function getCookie(name) {
                let cookies = document.cookie.split(';');
                for (let i = 0; i < cookies.length; i++) {
                    let cookie = cookies[i].trim();
                    if (cookie.startsWith(name + "=")) {
                        return cookie.substring(name.length + 1);
                    }
                }
                return "";
            }

            // Lấy giá trị role từ cookie
            let role = getCookie("role");

            // Nếu không phải admin, ẩn các phần admin-only
            if (role !== "admin") {
                document.querySelectorAll(".admin-only").forEach(el => el.style.display = "none");
            }

        </script>
        <!-- /portfolio -->
        <section class="section cta-page">
            <div class="container">
                <div class="row">
                    <div class="col-lg-7">
                        <div class="cta-content">
                            <div class="divider mb-4"></div>
                            <h2 class="mb-5 text-lg">We are pleased to offer you the <span class="title-color">chance to have the healthy</span></h2>
                            <a href="appoinment.html" class="btn btn-main-2 btn-round-full">Get appoinment<i class="icofont-simple-right  ml-2"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- footer Start -->
        <footer class="footer section gray-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 mr-auto col-sm-6">
                        <div class="widget mb-5 mb-lg-0">
                            <div class="logo mb-4">
                                <img src="images/logo.png" alt="" class="img-fluid">
                            </div>
                            <p>Tempora dolorem voluptatum nam vero assumenda voluptate, facilis ad eos obcaecati tenetur veritatis eveniet distinctio possimus.</p>

                            <ul class="list-inline footer-socials mt-4">
                                <li class="list-inline-item"><a href="https://www.facebook.com/themefisher"><i class="icofont-facebook"></i></a></li>
                                <li class="list-inline-item"><a href="https://twitter.com/themefisher"><i class="icofont-twitter"></i></a></li>
                                <li class="list-inline-item"><a href="https://www.pinterest.com/themefisher/"><i class="icofont-linkedin"></i></a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="widget mb-5 mb-lg-0">
                            <h4 class="text-capitalize mb-3">Department</h4>
                            <div class="divider mb-4"></div>

                            <ul class="list-unstyled footer-menu lh-35">
                                <li><a href="#">Surgery </a></li>
                                <li><a href="#">Wome's Health</a></li>
                                <li><a href="#">Radiology</a></li>
                                <li><a href="#">Cardioc</a></li>
                                <li><a href="#">Medicine</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="widget mb-5 mb-lg-0">
                            <h4 class="text-capitalize mb-3">Support</h4>
                            <div class="divider mb-4"></div>

                            <ul class="list-unstyled footer-menu lh-35">
                                <li><a href="#">Terms & Conditions</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Company Support </a></li>
                                <li><a href="#">FAQuestions</a></li>
                                <li><a href="#">Company Licence</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="widget widget-contact mb-5 mb-lg-0">
                            <h4 class="text-capitalize mb-3">Get in Touch</h4>
                            <div class="divider mb-4"></div>

                            <div class="footer-contact-block mb-4">
                                <div class="icon d-flex align-items-center">
                                    <i class="icofont-email mr-3"></i>
                                    <span class="h6 mb-0">Support Available for 24/7</span>
                                </div>
                                <h4 class="mt-2"><a href="tel:+23-345-67890">Support@email.com</a></h4>
                            </div>

                            <div class="footer-contact-block">
                                <div class="icon d-flex align-items-center">
                                    <i class="icofont-support mr-3"></i>
                                    <span class="h6 mb-0">Mon to Fri : 08:30 - 18:00</span>
                                </div>
                                <h4 class="mt-2"><a href="tel:+23-345-67890">+23-456-6588</a></h4>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="footer-btm py-4 mt-5">
                    <div class="row align-items-center justify-content-between">
                        <div class="col-lg-6">
                            <div class="copyright">
                                &copy; Copyright Reserved to <span class="text-color">Novena</span> by <a href="https://themefisher.com/" target="_blank">Themefisher</a>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="subscribe-form text-lg-right mt-5 mt-lg-0">
                                <form action="#" class="subscribe">
                                    <input type="text" class="form-control" placeholder="Your Email address">
                                    <a href="#" class="btn btn-main-2 btn-round-full">Subscribe</a>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-4">
                            <a class="backtop js-scroll-trigger" href="#top">
                                <i class="icofont-long-arrow-up"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>


        <!-- 
        Essential Scripts
        =====================================-->


        <!-- Main jQuery -->
        <script src="plugins/jquery/jquery.js"></script>
        <!-- Bootstrap 4.3.2 -->
        <script src="plugins/bootstrap/js/popper.js"></script>
        <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="plugins/counterup/jquery.easing.js"></script>
        <!-- Slick Slider -->
        <script src="plugins/slick-carousel/slick/slick.min.js"></script>
        <!-- Counterup -->
        <script src="plugins/counterup/jquery.waypoints.min.js"></script>

        <script src="plugins/shuffle/shuffle.min.js"></script>
        <script src="plugins/counterup/jquery.counterup.min.js"></script>
        <!-- Google Map -->
        <script src="plugins/google-map/map.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAkeLMlsiwzp6b3Gnaxd86lvakimwGA6UA&callback=initMap"></script>    

        <script src="js/script.js"></script>
        <script src="js/contact.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="assets/js/jquery-3.2.1.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>
        <script src="assets/js/select2.min.js"></script>
        <script src="assets/js/moment.min.js"></script>
        <script src="assets/js/bootstrap-datetimepicker.min.js"></script>
        <script src="assets/js/app.js"></script>
    </body>
</html>
