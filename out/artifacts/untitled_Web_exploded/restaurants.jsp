<%@ include file="/header.jsp" %>

<!-- about us css start-->
<section class="hotel_list section_padding single_page_hotel_list">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="section_tittle text-center">
                    <h2>Restaurants</h2>
                    <p>전 세계 다양한 푸드 마켓을 현대적으로 재해석한 인터내셔널 프리미엄 뷔페 레스토랑입니다.
                        자연에서 영감을 얻은 신선한 요리와 홈 스타일 디저트 등 최고의 맛을 선사하며 프라이빗 다이닝 룸을 갖추고 있어 특별한 기념일이나 모임 장소로도 적합합니다.</p>
                </div>
            </div>
        </div>
        <section class="accomodation_area section_gap">
            <div class="container">
                <div class="row">
<c:forEach items="${requestScope.restaurantsList}" var="restaurant">
                    <div class="col-lg-6">
                        <div id="1" class="carousel slide" data-interval="false">
                            <ol class="carousel-indicators">
                                <li data-target="#1" data-slide-to="0" class="active"></li>
                                <li data-target="#1" data-slide-to="1"></li>
                                <li data-target="#1" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="./img/ind/koreaRestaurants.jpg" class="d-block w-100" height="350" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img src="./img/ind/lounge.jpg" class="d-block w-100" height="350" alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img src="./img/ind/lounge.jpg" class="d-block w-100" height="350" alt="Third slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#1" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#1" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <div style="border:1px solid rgb(179, 131, 0); padding:15px; margin-bottom:60px">
                            <font style="font-family: 'Noto Sans KR', sans-serif; font-size:20px;">${restaurant.name}</font><br><br>
                            <div style="overflow : hidden;">
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:15px;">가격 : ${restaurant.price}</font>
                                <a href="./restaurantsDetail.do?no=${restaurant.no}" style="width:150px" class="btn_1 d-none d-lg-block  float-right">상세정보</a>
                            </div>

                        </div>
                    </div>
</c:forEach>
                </div>
            </div>
        </section>
    </div>
</section>
<!-- about us css end-->


<!--::industries end::-->

<!-- footer part start-->
<%@ include file="/footer.jsp" %>
<!-- footer part end-->

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