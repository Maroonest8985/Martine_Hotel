<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/header.jsp" %>
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
<!-- breadcrumb start-->
    <section class="breadcrumb breadcrumb_bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <div class="breadcrumb_iner_item text-center">
                            <h2>Search Result</h2>
                            <p>home . about us</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<script>
    $(document).ready(function(){
        var person = "${person}";
        if(!person){
        }else{
            $("#person").val(person).prop("selected", true);
        }
    });
</script>
<!-- booking part start-->
<section class="booking_part">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="booking_menu">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="hotel-tab" data-toggle="tab" href="#hotel" role="tab" aria-controls="hotel" aria-selected="true">hotel</a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-lg-12">
                <div class="booking_content">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="hotel" role="tabpanel" aria-labelledby="hotel-tab">
                            <div class="booking_form">
                                <form id="searchForm" name="searchForm" action="./search.do" method="get">
                                    <div class="form-row">
                                        <div class="form_colum">
                                            <input name="date1" id="datepicker_1" placeholder="Check in date" readonly>
                                            <script>
                                            </script>
                                        </div>
                                        <div class="form_colum">
                                            <input name="date2" id="datepicker_2" placeholder="Check in date" readonly>
                                            <script>
                                                var today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
                                                var $datepicker1 = $('#datepicker_1').datepicker({
                                                    value: '${date1}',
                                                    format: 'yyyy-mm-dd',
                                                    minDate: today
                                                });
                                                var $datepicker2 = $('#datepicker_2').datepicker({
                                                    value: '${date2}',
                                                    format: 'yyyy-mm-dd',
                                                    minDate: function () {
                                                            var date1 = new Date($datepicker1.value());
                                                            date1.setDate(date1.getDate() + 1);
                                                            return new Date(date1.getFullYear(), date1.getMonth(), date1.getDate());
                                                        }
                                                });
                                            </script>
                                        </div>
                                        <div class="form_colum">
                                            <select id="person" name="person" class="nc_select">
                                                <option value="">Person</option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                                <option value="4">Four</option>
                                            </select>
                                        </div>
                                        <div class="form_btn">
                                            <button id="doSearch" type="button" class="btn_1" style="border : none;">search</button>
                                            <button id="searchSubmit" type="submit" style="display : none;"></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</section>
<!-- Header part end-->
<!--::industries start::-->

<section class="hotel_list section_padding">
    <div class="container">
        <h3>지금 예약 가능 :</h3>
        <div class="row">
<c:forEach items="${requestScope.searchList}" var="searchList">
            <div class="col-lg-4 col-sm-6">
                <div class="single_ihotel_list">
                    <a href="./roomsDetail.do?no=${searchList.no}&date1=${date1}&date2=${date2}&person=${person}">
                        <img src="img/ind/industries_1.png" alt=""></a>
                    <div class="hover_text">
                        <div class="hotel_social_icon">
                            <ul>
                                <li><a href="#"><i class="ti-facebook"></i></a></li>
                                <li><a href="#"><i class="ti-twitter-alt"></i></a></li>
                                <li><a href="#"><i class="ti-linkedin"></i></a></li>
                            </ul>
                        </div>
                        <div class="share_icon">
                            <i class="ti-share"></i>
                        </div>
                    </div>
                    <div class="hotel_text_iner">
                        <h3> <a href="./roomsDetail.do?no=${searchList.no}&date1=${date1}&date2=${date2}"> ${searchList.name}</a></h3>
                        <div class="place_review">
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <a href="#"><i class="fas fa-star"></i></a>
                            <span>(210 review)</span>
                        </div>
                        <p>${searchList.ex}</p>
                        <h5>From <span>$${searchList.price}</span></h5>
                    </div>
                </div>
            </div>
    </c:forEach>
        </div>
    </div>
</section>
<!--::industries end::-->


    <!-- breadcrumb start-->

<%@ include file="/footer.jsp" %>

</body>

</html>