<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Mini Finance - Settings</title>

        <!-- CSS FILES -->      
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Unbounded:wght@300;400;700&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/tooplate-mini-finance.css" rel="stylesheet">

    </head>
    <body>
        <header class="navbar sticky-top flex-md-nowrap bg-danger">
            <div class="col-md-3 col-lg-3 me-0 px-3 fs-6">
                <a class="navbar-brand text-white" href="">
                    <i class="bi-box"></i>
                    Mini Finance
                </a>
            </div>

            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <form class="custom-form header-form ms-lg-3 ms-md-3 me-lg-auto me-md-auto order-2 order-lg-0 order-md-0" action="" method="get" role="form">
                <input class="form-control bg-white text-dark" name="search" type="text" placeholder="Search" aria-label="Search">
            </form>

            <div class="navbar-nav me-lg-2">
                <div class="nav-item text-nowrap d-flex align-items-center">
                    <div class="dropdown ps-3">
                        <a class="nav-link dropdown-toggle text-center text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" id="navbarLightDropdownMenuLink">
                            <i class="bi-bell"></i>
                            <span class="position-absolute start-100 translate-middle p-1 bg-white border border-danger rounded-circle">
                                <span class="visually-hidden">New alerts</span>
                            </span>
                        </a>

                        <ul class="dropdown-menu dropdown-menu-lg-end notifications-block-wrap bg-white text-danger shadow" aria-labelledby="navbarLightDropdownMenuLink">
                            <small class="text-danger">Notifications</small>

                            <li class="notifications-block border-bottom border-danger pb-2 mb-2">
                                <a class="dropdown-item d-flex align-items-center text-danger" href="#">
                                    <div class="notifications-icon-wrap bg-danger text-white">
                                        <i class="notifications-icon bi-check-circle-fill"></i>
                                    </div>
                                    <div>
                                        <span>Your account has been created successfully.</span>
                                        <p>12 days ago</p>
                                    </div>
                                </a>
                            </li>

                            <li class="notifications-block border-bottom border-danger pb-2 mb-2">
                                <a class="dropdown-item d-flex align-items-center text-danger" href="#">
                                    <div class="notifications-icon-wrap bg-danger text-white">
                                        <i class="notifications-icon bi-folder"></i>
                                    </div>
                                    <div>
                                        <span>Please check. We have sent a Daily report.</span>
                                        <p>10 days ago</p>
                                    </div>
                                </a>
                            </li>

                            <li class="notifications-block">
                                <a class="dropdown-item d-flex align-items-center text-danger" href="#">
                                    <div class="notifications-icon-wrap bg-danger text-white">
                                        <i class="notifications-icon bi-question-circle"></i>
                                    </div>
                                    <div>
                                        <span>Account verification failed.</span>
                                        <p>1 hour ago</p>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="dropdown px-3">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="images/medium-shot-happy-man-smiling.jpg" class="profile-image img-fluid" alt="">
                </a>
                <ul class="dropdown-menu bg-white shadow">
                    <li>
                        <div class="dropdown-menu-profile-thumb d-flex">
                            <img src="images/medium-shot-happy-man-smiling.jpg" class="profile-image img-fluid me-3" alt="">

                            <div class="d-flex flex-column">
                                <small>${sessionScope.account.full_name}</small>
                                <small>${sessionScope.account.email}</small>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a class="dropdown-item" href="profile.html">
                            <i class="bi-person me-2"></i>
                            Profile
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="setting.html">
                            <i class="bi-gear me-2"></i>
                            Settings
                        </a>
                    </li>
                    <li class="border-top mt-3 pt-2 mx-4">
                        <a class="dropdown-item ms-0 me-0" href="logout">
                            <i class="bi-box-arrow-left me-2"></i>
                            Logout
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-3 d-md-block sidebar collapse">
            <div class="position-sticky py-4 px-3 sidebar-sticky">
                <ul class="nav flex-column h-100">
                    <c:if test="${sessionScope.account.role_id==1}">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="staff_management">
                            <i class="bi-house-fill me-2"></i>
                            Management
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.account.role_id==2}">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="customerList">
                            <i class="bi-house-fill me-2"></i>
                            Management
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.account.role_id==4}">
                        <li class="nav-item">
                        <a class="nav-link" href="list-insurance-contracts">
                            <i class="bi-house-fill me-2"></i>
                            List Insurance Contracts
                        </a>
                    </li>
                    </c:if>
                    
                    <c:if test="${sessionScope.account.role_id==4}">
                        <li class="nav-item">
                        <a class="nav-link" href="list-debt-customers">
                            <i class="bi-wallet me-2"></i>
                            List Debt Customer
                        </a>
                    </li>
                    </c:if>
                    
                    <c:if test="${sessionScope.account.role_id==4}">
                        <li class="nav-item">
                        <a class="nav-link" href="list-transactions">
                            <i class="bi-person me-2"></i>
                            List Transactions
                        </a>
                    </li>
                    </c:if>
                    
                    <c:if test="${sessionScope.account.role_id==4}">
                        <li class="nav-item">
                        <a class="nav-link" href="list-insurance-transactions">
                            <i class="bi-person me-2"></i>
                            List Insurance Transactions
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.account.role_id==4}">
                    <li class="nav-item">
                        <a class="nav-link" href="amountStatistics">
                            <i class="bi-person me-2"></i>
                            Amount Statistics
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.account.role_id==4}">
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerList_AServlet">
                            <i class="bi-person me-2"></i>
                            Accountant
                        </a>
                    </li>                   
                    </c:if>
                    <c:if test="${sessionScope.account.role_id==4}">
                    <li class="nav-item">
                        <a class="nav-link" href="calculate">
                            <i class="bi-person me-2"></i>
                            Loan and Savings Interest Calculator
                        </a>
                    </li>                   
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="index.html">
                            <i class="bi-house-fill me-2"></i>
                            Overview
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="wallet.html">
                            <i class="bi-wallet me-2"></i>
                            My Wallet
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="profile.html">
                            <i class="bi-person me-2"></i>
                            Profile
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="setting.html">
                            <i class="bi-gear me-2"></i>
                            Settings
                        </a>
                    </li>
                    <li class="nav-item border-top mt-auto pt-2">
                        <a class="nav-link" href="logout">
                            <i class="bi-box-arrow-left me-2"></i>
                            Logout
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="main-wrapper col-md-9 ms-sm-auto py-4 col-lg-9 px-md-4 border-start">
            <div class="title-group mb-3">
                <h1 class="h2 mb-0 text-danger">Settings</h1>
            </div>

            <div class="row my-4">
                <div class="col-lg-7 col-12">
                    <div class="custom-block bg-white">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link active" href="changeInfor" id="profile-tab" role="tab" aria-controls="profile-tab-pane" aria-selected="true">Profile</a>
                            </li>
                            <li class="nav-item" role="presentation">
                                <a class="nav-link" href="changepass" id="password-tab" role="tab" aria-controls="password-tab-pane" aria-selected="false">Password</a>
                            </li>
                            <li class="nav-item" role="presentation">
                                <a class="nav-link" href="changenotification" id="notification-tab" role="tab" aria-controls="notification-tab-pane" aria-selected="false">Notification</a>
                            </li>
                        </ul>

                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
                                <h6 class="mb-4 text-danger"><a href="changepass">User Profile</a></h6>

                                <form class="custom-form profile-form" action="changeInfor" method="post" >
                                    <input class="form-control" type="text" name="profile-name" placeholder="Name">
                                    <input class="form-control" type="email" name="profile-email" placeholder="Email">
                                    <input class="form-control" type="number" name="profile-phone" placeholder="Phone"> 
                                    <input class="form-control" type="text" name="profile-address" placeholder="Address">
                                    <input class="form-control" type="text" name="dob" placeholder="Date of birth (yyyy-MM-dd)">

                                    <div class="input-group mb-1">
                                        <img src="" class="profile-image img-fluid" alt="">
                                        <input type="file" class="form-control" name="profile-image">
                                    </div>
                                    <c:if test="${not empty errorMessage}">
                                        <div style="color: red; font-weight: bold;">
                                            ${errorMessage}
                                        </div>
                                    </c:if>
                                    <div class="d-flex">
                                        <button type="button " class="form-control me-3 text-bg-danger">
                                            Reset
                                        </button>

                                        <button type="submit" class="form-control me-3 text-bg-danger">
                                            Update
                                        </button>
                                    </div> 
                                </form>
                            </div>



                            <div class="tab-pane fade" id="notification-tab-pane" role="tabpanel" aria-labelledby="notification-tab" tabindex="0">
                                <h6 class="mb-4 text-danger">Notification</h6>

                                <form class="custom-form notification-form" action="#" method="post" role="form">

                                    <div class="form-check form-switch d-flex mb-3 ps-0">
                                        <label class="form-check-label" for="flexSwitchCheckCheckedOne">Account activity</label>

                                        <input class="form-check-input ms-auto" type="checkbox" name="form-check-input" role="switch" id="flexSwitchCheckCheckedOne" checked>
                                    </div>

                                    <div class="form-check form-switch d-flex mb-3 ps-0">
                                        <label class="form-check-label" for="flexSwitchCheckCheckedTwo">Payment updated</label>

                                        <input class="form-check-input ms-auto" type="checkbox" name="form-check-input" role="switch" id="flexSwitchCheckCheckedTwo" checked>
                                    </div>

                                    <div class="d-flex mt-4">
                                        <button type="button" class="form-control me-3 text-bg-danger">
                                            Reset
                                        </button>

                                        <button type="submit" class="form-control ms-2 text-bg-danger">
                                            Update Password
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-5 col-12">
                    <div class="custom-block custom-block-contact">
                        <h6 class="mb-4">Still can?t find what you looking for?</h6>

                        <p>
                            <strong>Call us:</strong>
                            <a href="tel: 305-240-9671" class="ms-2">
                                (60) 
                                305-240-9671
                            </a>
                        </p>

                        <a href="#" class="btn custom-btn custom-btn-bg-white mt-3">
                            Chat with us
                        </a>
                    </div>
                </div>
            </div>

            <footer class="site-footer">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12 col-12">
                            <p class="copyright-text">Copyright � Mini Finance 2048 
                                - Design: <a rel="sponsored" href="https://www.tooplate.com" target="_blank">Tooplate</a></p>
                        </div>

                    </div>
                </div>
            </footer>
        </main>

    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/custom.js"></script>

</body>
</html>