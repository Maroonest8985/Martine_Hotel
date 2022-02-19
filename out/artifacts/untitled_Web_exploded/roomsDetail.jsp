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

<script>
    $(function(){
        $("#reservation").click(function(){
            $(".menu-fixed").css('z-index : 999 !important;');
            }
        );
    });
    $(document).ready(function(){ // roomsDetail.jsp페이지가 단순 Room의 상세정보 조회시
        var date1 = "${date1}"; // date1값을 기준으로 date1 == null 일 때 예약관련 div를 display: none으로 변경
        if(!date1){
            $("#top_right").css("display", "none");
            $("#top_left").attr("class", "col-md-12");
        }
    });
    $(document).ready(function(){
        var person = "${person}";
        if(!person){
        }else{
            $("#person").val(person).prop("selected", true);
        }
        var day1 = new Date("${date1}");
        var day2 = new Date("${date2}");

        var difference= Math.abs(day2-day1);
        var days = difference/(1000 * 3600 * 24);
        var totalPrice = ${readList.price}*days;
        $("#totalprice").html("<h5>"+totalPrice+"원</h5><input type='hidden' name='price' value='"+totalPrice+"'>");

    });
</script>
<!-- about us css start-->
<section class="hotel_list section_padding single_page_hotel_list" style="padding : 10px 0px; ">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="section_tittle text-center">
                    <h2>${readList.name}</h2>
                    <p>${readList.ex}</p>
                </div>
            </div>
        </div>

        <div style="display: flex; flex-wrap : wrap;">
                <!--===== 레스토랑 사진 슬라이드 =====-->
            <div class="col-md-7" id="top_left">
                <div data-aos="zoom-in" data-aos-duration="3000" class="text-center aos-init aos-animate">
                    <div id="1" class="carousel slide carousel-fade" data-interval="false">
                        <ol class="carousel-indicators">
                            <li data-target="#1" data-slide-to="0" class="active"></li>
                            <li data-target="#1" data-slide-to="1"></li>
                            <li data-target="#1" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="./img/ind/koreafood.jpg" class="d-block w-100" alt="1">
                            </div>
                            <div class="carousel-item">
                                <img src="./img/ind/lounge.jpg" class="d-block w-100" alt="2">
                            </div>
                            <div class="carousel-item">
                                <img src="./img/ind/lounge.jpg" class="d-block w-100" alt="3">
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
                </div>
            </div>
                <div class="col-md-5" id="top_right"style="padding: 5px 5px 5px 5px;">
                    <div style="flex : none;">
                        <section class="booking_part" style="margin-top : 0px;">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="booking_content" style="padding : 0px; box-shadow: none;">
                                            <div class="tab-content" id="myTabContent">
                                                <div class="tab-pane fade show active" id="hotel" role="tabpanel" aria-labelledby="hotel-tab">
                                                    <div class="booking_form">
                                                        <form id="reservationForm" name="reservationForm" action="./reservation.do" method="get">
                                                            <div class="mt-10">
                                                                <h5>예약일자:</h5>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form_colum" style="width: 100%; margin-bottom : 10px;">
                                                                    <input name="date1" id="date1" value="${date1}" class="gj-textbox-md" placeholder="Check in date" readonly>
                                                                </div>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form_colum" style="width: 100%; margin-bottom : 10px;">
                                                                    <input name="date2" id="date2" value="${date2}" class="gj-textbox-md" placeholder="Check in date" readonly>
                                                                </div>
                                                            </div>
                                                            <div class="mt-10">
                                                                <h5>인원수:</h5>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form_colum" style="width: 100%; margin-bottom : 10px;">
                                                                    <select id="person" name="person" class="nc_select" style="padding: 10px;">
                                                                        <option value="">Person</option>
                                                                        <option value="1">One</option>
                                                                        <option value="2">Two</option>
                                                                        <option value="3">Three</option>
                                                                        <option value="4">Four</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form_colum" style="width: 100%; margin-bottom : 10px;">
                                                                    <button id="reservation" type="button"class="btn_1" style="border : none; width : 100%;">예약하기</button>
                                                                    <button id="reservationModal" data-toggle="modal" data-target=".bd-example-modal-lg" type="button" style="display : none;"></button>
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
                        </section>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
            <hr><br>
                <!--===== 레스토랑 사진 슬라이드 =====-->
<div class="container">
                <!--===== 레스토랑 설명 =====-->
                <div style="text-align:center">
						<span style="color:black">
							<h3>레스토랑 소개</h3>
						</span>
                    <font style="font-family: 'Noto Sans KR', sans-serif; font-size:16px">자연 친화적 인테리어와 남산의 녹음이 어우러진 올 데이 공간입니다. 라이브 키친에서 신선한 식재료로 즉석에서 조리한 음식을 맛볼 수 있습니다.</font>
                </div><br>
                <hr><br>
                <!--===== 레스토랑 설명 =====-->

                <!--===== 레스토랑 사용 설명 =====-->
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="single-footer-widget">
                                <span style="color:black"><h3>기본정보</h3></span><br>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="single-footer-widget">
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:20px; font-weight: 500; color:black">운영시간</font><br><br>
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:15px;">
                                    10:00</font>-
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:15px;">
                                    21:00</font><br>
                            </div><br>
                        </div>
                        <div class="col-lg-6">
                            <div class="single-footer-widget">
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:20px; font-weight: 500; color:black">예약인원</font><br><br>
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:15px">성인 및 어린이 최대 4명 동시 예약가능</font><br><br>
                            </div>
                        </div>
                    </div>
                </div>
                <!--===== 객실개요 =====-->
                <br><hr><br>
                <!--===== 특별서비스 =====-->
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="single-footer-widget">
                                <span style="color:black"><h3>추가정보</h3> </span>
                            </div>
                        </div>
                        <ul>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px; color:red">정부의 사회적 거리두기 지침에 따라 영업 시간이 변동될 수 있습니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">예약 시 성인 1명은 필수로 있어야 합니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">최대 4인 까지 예약 및 입장이 가능합니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">3인 이상의 고객은 완전 예약제로 운영됩니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">주류를 판매 하고 있습니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">재료 수급 상황에 따라 메뉴 변동이 있을 수 있습니다.</li>
                        </ul>
                    </div>
                </div>
                <!--===== 특별서비스 =====-->
                <br><hr><br>
                <!--===== 환불정보 =====-->
                <div class="container">
                    <div class="row" id="reple">
                        <div class="col-lg-3">
                            <div class="single-footer-widget">
                                <span style="color:black"><h3>추가규정</h3> </span>
                            </div>
                        </div>
                        <ul>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">PDR : 예약일 기준 1일 이내 취소 시 인당 5만원 산정 부과합니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">3인 이상 예약 : 예약 시간 1시간 전부터 취소 시 인당 5만원 산정 부과합니다.</li>
                            <li style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; margin-top:5px">No-Show : 1회 이상 No-Show 시 사전 안내 후 예약 거절이 될 수 있습니다.</li>
                        </ul>
                    </div>
                </div>
                <!--===== 환불정보 =====-->
                <br><hr><br>
                <br><br><br><br><br><br>
                <div class="row">
                    <div class="col-lg-3" style="padding-bottom:20px">
                        <font style="font-family: 'Noto Sans KR', sans-serif; font-size:20px; padding-left:10px">이용후기 (2)</font><br>
                        <input href="#loginModal" class="genric-btn primary circle arrow" style="float:left; margin-top:10px; width:200px; font-size:16px;" value="로그인 후 가능" data-toggle="modal">				</div>
                    <div class="col-lg-7">

                        <form action="./roomsDetail.do" method="post">
                            <input type="hidden" value="5">
                            <font style="padding-top:9px; padding-bottom:9px; font-family: 'Noto Sans KR', sans-serif; font-size:25px;">경성구</font>
                            <br>
                            <font style="padding-top:9px; padding-bottom:9px; font-family: 'Noto Sans KR', sans-serif; font-size:15px;">작성일 : 2022-01-14</font><br>
                            <div style="padding-top:10px;">
                                <div>
                                    <img style="float : left; max-width : 15px; max-height: 15px;" src="./img/ind/star.png">
                                    <img style="float : left; max-width : 15px; max-height: 15px;" src="./img/ind/star.png">
                                    <img style="float : left; max-width : 15px; max-height: 15px;" src="./img/ind/star.png">
                                    <img style="float : left; max-width : 15px; max-height: 15px;" src="./img/ind/star.png">
                                    <img style="float : left; max-width : 15px; max-height: 15px;" src="./img/ind/star.png">
                                </div>
                                <br><br>
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; padding-left:20px">강인수 피파벌레</font>
                            </div>
                        </form>
                        <hr>
                        <br>
                        <form action="./roomsDetail.do" method="post">
                            <input type="hidden" value="4">
                            <font style="padding-top:9px; padding-bottom:9px; font-family: 'Noto Sans KR', sans-serif; font-size:25px;">강인수</font>
                            <br>
                            <font style="padding-top:9px; padding-bottom:9px; font-family: 'Noto Sans KR', sans-serif; font-size:15px;">작성일 : 2022-01-14</font><br>
                            <div style="padding-top:10px;">
                                <img src="#">
                                <img src="#">
                                <img src="#">
                                <img src="#">
                                <img src="#">
                                <br><br>
                                <font style="font-family: 'Noto Sans KR', sans-serif; font-size:15px; padding-left:20px">경성구 피파의 신</font>
                            </div>
                        </form>
                        <hr>
                        <br>
                    </div>
                </div>
            </div><br><br><br><br><br>
        </section>

<!-- about us css end-->
<!-- modal -->


<div class="modal fade bd-example-modal-lg" tabindex="-1" style="z-index : 10000 !important;" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="min-width: 90%;">
        <form action="reservation.do" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myLargeModal">예약</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="display: flex; flex-direction: row; flex-wrap: wrap;">
                <div class="col-md-6" style="min-width: 200px;">
                    <div class="mt-10">
                        <h5>방 이름</h5>
                    </div>
                    <div class="mt-10" style="border-bottom: 1px solid black;">
                        <h5>${readList.name}</h5>
                    </div>
                    <div class="mt-10">
                        <h5>예약일자</h5>
                    </div>
                    <div class="mt-10" style="display: flex; border-bottom: 1px solid black;">
                        <input type="text" value="${date1}" name="date1" placeholder="date1" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Start Date'" required="" class="single-input" readonly>
                        <h4 style="margin : 10px;">~</h4>
                        <input type="text" value="${date2}" name="date2" placeholder="date2" onfocus="this.placeholder = ''" onblur="this.placeholder = 'End Date'" required="" class="single-input" readonly>
                    </div>
                    <div class="mt-10">
                        <h5>인원수</h5>
                    </div>
                    <div class="mt-10" style="border-bottom: 1px solid black;">
                        <input type="text" value="${person}" name="person" placeholder="Person" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Person'" required="" class="single-input">
                    </div>
                    <div class="mt-10">
                        <h5>예약자명</h5>
                    </div>
                    <div class="mt-10" style="border-bottom: 1px solid black;">
                        <input type="text" value="${memberInfo.name}" name="name" placeholder="Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Name'" required="" class="single-input">
                    </div>
                    <div class="mt-10">
                        <h5>연락처</h5>
                    </div>
                    <div class="mt-10" style="border-bottom: 1px solid black;">
                        <input type="text" value="${memberInfo.tel}" name="tel" placeholder="Tel" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Tel'" required="" class="single-input">
                    </div>
                </div>
                <div class="col-md-6" style="min-width: 200px;">
                    <div class="mt-10">
                        <h5>결제금액</h5>
                    </div>
                    <div id="totalprice"class="mt-10" style="border-bottom: 1px solid black;">
                    </div><div class="mt-10">
                    <h5>카드번호</h5>
                </div>
                    <div class="mt-10" style="border-bottom: 1px solid black; display: flex;">
                        <input type="text" maxlength="4" value="" name="card1" placeholder="" onfocus="this.placeholder = ''" onblur="this.placeholder = ''" required="" class="single-input" numberOnly>-
                        <input type="text" maxlength="4" value="" name="card2" placeholder="" onfocus="this.placeholder = ''" onblur="this.placeholder = ''" required="" class="single-input" numberOnly>-
                        <input type="text" maxlength="4" value="" name="card3" placeholder="" onfocus="this.placeholder = ''" onblur="this.placeholder = ''" required="" class="single-input" numberOnly>-
                        <input type="text" maxlength="4" value="" name="card4" placeholder="" onfocus="this.placeholder = ''" onblur="this.placeholder = ''" required="" class="single-input" numberOnly>
                    </div>
                </div>
            </div>
            <input type="hidden" name="member_no" value="${memberInfo.no}">
            <input type="hidden" name="room_no" value="${readList.no}">
            <div class="modal-footer">
                <button id="reservationModalBtn" type="button" class="genric-btn primary" style="width : 50%">예약</button>
                <button id="reservationModalSubmit" type="submit" style="display : none;"></button>
        </form>
    </div>
        </div>
    </div>
</div>

<!--::industries end::-->

<!-- footer part start-->
<%@ include file="/footer.jsp" %>
<!-- footer part end-->
