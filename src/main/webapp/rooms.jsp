<%@ include file="/header.jsp" %>

<!-- breadcrumb start-->
<section class="breadcrumb breadcrumb_bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <div class="breadcrumb_iner_item text-center">
                        <h2>Our Rooms</h2>
                        <p>home . about us</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!--::industries start::-->

<section class="hotel_list section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="section_tittle text-center">
                    <h2>Comfortable Room</h2>
                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.</p>
                </div>
            </div>
        </div>
        <div class="row">
<c:forEach items="${requestScope.roomList}" var="room">
        <div class="col-lg-4 col-sm-6">
                <div class="single_ihotel_list">
                    <a href="./roomsDetail.do?no=${room.no}">
                    <img src="img/ind/industries_1.png" alt="">
                    </a>
                    <div class="hover_text">
                    </div>
                    <div class="hotel_text_iner">
                        <h3> <a href="./roomsDetail.do?no=${room.no}">${room.name}</a></h3>
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <span>(rating)</span>
                        </div>
                        <p>London, United Kingdom</p>
                        <h5>From <span>${room.price}원/1박</span></h5>
                    </div>
                </div>
            </div>

</c:forEach>
        </div>
    </div>
</section>
<!--::industries end::-->

<!--top place end-->
<!-- breadcrumb start-->

<!-- about us css start-->
<!--<section class="about_us section_padding">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <div class="about_img">
                    <img src="img/about_img.png" alt="#">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="about_text">
                    <h5>Who we are</h5>
                    <h2>We love to discover around the world</h2>
                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged night yielding land creeping that seed appear were bearing.</p>
                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged night yielding land creeping that seed appear were bearing.</p>
                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged night yielding land creeping that seed appear were bearing.</p>
                </div>
            </div>
        </div>
    </div>
</section>
about us css end-->

<!--top place start-->
<!--<section class="event_part section_padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="event_slider owl-carousel" >
                    <div class="single_event_slider">
                        <div class="row justify-content-end">
                            <div class="col-lg-6 col-md-6">
                                <div class="event_slider_content">
                                    <h5>Upcoming Event</h5>
                                    <h2>Maldeve - Asia</h2>
                                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.
                                    </p>
                                    <p>date: <span>12 Aug 2019</span> </p>
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
                        </div>
                    </div>
                    <div class="single_event_slider">
                        <div class="row justify-content-end">
                            <div class="ol-lg-6 col-md-6">
                                <div class="event_slider_content">
                                    <h5>Upcoming Event</h5>
                                    <h2>Maldeve - Asia</h2>
                                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.
                                    </p>
                                    <p>date: <span>12 Aug 2019</span> </p>
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
                        </div>
                    </div>
                    <div class="single_event_slider">
                        <div class="row justify-content-end">
                            <div class="ol-lg-6 col-md-6">
                                <div class="event_slider_content">
                                    <h5>Upcoming Event</h5>
                                    <h2>Maldeve - Asia</h2>
                                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.
                                    </p>
                                    <p>date: <span>12 Aug 2019</span> </p>
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
top place end-->

<!--::industries start::-->
<!--<section class="best_services section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="section_tittle text-center">
                    <h2>We offered best services</h2>
                    <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-sm-6">
                <div class="single_ihotel_list">
                    <img src="img/services_1.png" alt="">
                    <h3> <a href="#"> Transportation</a></h3>
                    <p>All transportation cost we bear</p>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="single_ihotel_list">
                    <img src="img/services_2.png" alt="">
                    <h3> <a href="#"> Guidence</a></h3>
                    <p>We offer the best guidence for you</p>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="single_ihotel_list">
                    <img src="img/services_3.png" alt="">
                    <h3> <a href="#"> Accomodation</a></h3>
                    <p>Luxarious and comfortable</p>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="single_ihotel_list">
                    <img src="img/services_4.png" alt="">
                    <h3> <a href="#"> Discover world</a></h3>
                    <p>Best tour plan for your next tour</p>
                </div>
            </div>
        </div>
    </div>
</section>
::industries end::-->

<!--top place start-->
<!--<section class="client_review section_padding">
    <div class="container">
        <div class="row ">
            <div class="col-xl-6">
                <div class="section_tittle">
                    <h2>What they said</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="client_review_slider owl-carousel">
                    <div class="single_review_slider">
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                        </div>
                        <p>Waters make fish every without firmament saw had. Morning air subdue. Our Air very one whales grass is fish whales winged night yielding land creeping that seed </p>
                        <h5> - Allen Miller</h5>
                    </div>
                    <div class="single_review_slider">
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                        </div>
                        <p>Waters make fish every without firmament saw had. Morning air subdue. Our Air very one whales grass is fish whales winged night yielding land creeping that seed </p>
                        <h5> - Allen Miller</h5>
                    </div>
                    <div class="single_review_slider">
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                        </div>
                        <p>Waters make fish every without firmament saw had. Morning air subdue. Our Air very one whales grass is fish whales winged night yielding land creeping that seed </p>
                        <h5> - Allen Miller</h5>
                    </div>
                    <div class="single_review_slider">
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                        </div>
                        <p>Waters make fish every without firmament saw had. Morning air subdue. Our Air very one whales grass is fish whales winged night yielding land creeping that seed </p>
                        <h5> - Allen Miller</h5>
                    </div>
                    <div class="single_review_slider">
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                        </div>
                        <p>Waters make fish every without firmament saw had. Morning air subdue. Our Air very one whales grass is fish whales winged night yielding land creeping that seed </p>
                        <h5> - Allen Miller</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
top place end-->

<!--::gallery part start::-->
!--<section class="our_gallery section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="section_tittle text-center">
                    <h2>Our gallery</h2>
                    <p>WWaters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="card-columns">
                    <div class="card">
                        <a href="img/gallery/gallery_1.png" class="gallery_img">
                            <img src="img/gallery/gallery_1.png" class="card-img-top" alt="">
                        </a>
                    </div>
                    <div class="card">
                        <a href="img/gallery/gallery_3.png" class="gallery_img">
                            <img src="img/gallery/gallery_3.png" class="card-img-top" alt="">
                        </a>
                    </div>
                    <div class="card">
                        <a href="img/gallery/gallery_2.png" class="gallery_img">
                            <img src="img/gallery/gallery_2.png" class="card-img-top" alt="">
                        </a>
                    </div>
                    <div class="card">
                        <a href="img/gallery/gallery_4.png" class="gallery_img">
                            <img src="img/gallery/gallery_4.png" class="card-img-top" alt="">
                        </a>
                    </div>
                    <div class="card">
                        <a href="img/gallery/gallery_5.png" class="gallery_img">
                            <img src="img/gallery/gallery_5.png" class="card-img-top" alt="">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--::gallery part end::-->

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