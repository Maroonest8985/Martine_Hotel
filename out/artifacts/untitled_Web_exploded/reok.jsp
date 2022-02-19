<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/header.jsp" %>
<%@ page import="com.example.demo.repository.DAOImplMysql" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.demo.repository.DAO" %>
<%@ page import="java.io.PrintWriter" %>

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Martine</title>
    <link rel="icon" href="img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- themify CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="css/flaticon.css">
    <!-- fontawesome CSS -->
    <link rel="stylesheet" href="fontawesome/css/all.min.css">
    <!-- magnific CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/gijgo.min.css">
    <!-- niceselect CSS -->
    <link rel="stylesheet" href="css/nice-select.css">
    <!-- slick CSS -->
    <link rel="stylesheet" href="css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body>


<!--event_part start-->
<section class="event_part section_padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                        <div class="row justify-content-end">
                            <c:forEach items="${reservationList}" var="reservationList">
                            <div class="col-lg-6 col-md-6">
                                <div class="event_slider_content">
                                    <h5>Upcoming Event</h5>
                                    <h2>${reservationList.name}</h2>
                                    <p>tel : ${reservationList.tel}
                                    </p>
                                <p>date: <span>${reservationList.startday}</span> </p>
                                <p>date: <span>${reservationList.endday}</span> </p>
                                    <p>Cost: <span>Start from $820</span> </p>
                                    <p>Organizer: <span> Martine Agency</span> </p>
                                    <div class="rating">
                                        <span>Rating:</span>
                                        <div class="place_review">
                                            <a href="#"><i class="fas fa-star"></i></a>
                                            <a href="#"><i class="fas fa-star"></i></a>
                                            <a href="#"><i class="fas fa-star"></i></a>
                                            <a href="#"><i class="fas fa-star"></i></a>
                                            <a href="#"><i class="fas fa-star"></i></a>
                                        </div>
                                    </div>
                                         <a href="#" class="btn_1">Plan Details</a>
                                     </div>
                                </div>
                            </c:forEach>
              </div>
            </div>
        </div>
    </div>
</section>
<!--event_part end-->
<%@ include file="/footer.jsp" %>

<!-- jquery plugins here-->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- magnific js -->
<script src="js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="js/owl.carousel.min.js"></script>
<!-- masonry js -->
<script src="js/masonry.pkgd.js"></script>
<!-- masonry js -->
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/gijgo.min.js"></script>
<!-- contact js -->
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mail-script.js"></script>
<script src="js/contact.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>
</body>

</html>