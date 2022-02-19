<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Martine</title>
  <link rel="icon" href="img/favicon.png">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css?after">
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
  <link rel="stylesheet" href="css/style.css?after">
</head>

<body>
<!--::header part start::-->
<header class="main_menu">
  <div class="sub_menu">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-sm-12 col-md-6">
          <div class="sub_menu_right_content">
            <span>Top destinations</span>
            <c:choose>
            <c:when test="${sessionScope.logined == null}">
            <a href="" id="loginBtn" data-toggle="modal" data-target="#exampleModalCenter">Login</a>
            <a href="" data-toggle="modal" data-target="#exampleModalLong">회원가입</a>
            </c:when>
            <c:otherwise>
            <c:if test="${logined eq 'admin'}">
            <a href="admin">Admin</a>
            </c:if>
            <a href="./logout.do">로그아웃</a>
            </c:otherwise>
            </c:choose>
          </div>
        </div>
        <div class="col-lg-1 col-sm-1 col-md-1"></div>
        <c:choose>
          <c:when test="${sessionScope.logined == null}">
        <div id="nologin" class="col-lg-5 col-sm-12 col-md-5" style="display: flex; justify-content: flex-end;">
          <form style="display: contents;" method="post" action="./reok.do">
          <a style="min-width: 50px;">예약조회</a>
                <input style="max-height : 25px; margin-left: 10px;width : 80px;" type="text" name="rename" placeholder="Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Name'" required="" class="single-input">
                <input style="max-height : 25px; margin-left: 10px;width : 150px;" type="text" name="retel" placeholder="Tel" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Tel'" required="" class="single-input" numberOnly>
                <button type="submit" class="genric-btn primary small" style="height: 25px; margin-left : 10px;">예약조회</button>
          </form>
        </div>
          </c:when>
          <c:otherwise>
            <div id="logined" class="col-lg-5 col-sm-12 col-md-5" style="display: flex; justify-content: flex-end;">
              <a href="./reok.do" class="genric-btn primary small" style="height: 25px; margin-left : 10px;">예약조회</a>
            </div>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
  <div class="main_menu_iner">
    <div class="container">
      <div class="row align-items-center ">
        <div class="col-lg-12">
          <nav class="navbar navbar-expand-lg navbar-light justify-content-between">
            <a class="navbar-brand" href="home"> <img src="img/logo.png" alt="logo"> </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse main-menu-item justify-content-center"
                 id="navbarSupportedContent">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="home">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="rooms">Rooms</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="restaurants">Restaurants</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="blog" id="navbarDropdown"
                     role="button" data-toggle="dropdown" aria-haspopup="true"
                     aria-expanded="false">
                    Blog
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="blog">Blog</a>
                    <a class="dropdown-item" href="single-blog.html">Single blog</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="blog" id="navbarDropdown_1"
                     role="button" data-toggle="dropdown" aria-haspopup="true"
                     aria-expanded="false">
                    pages
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                    <a class="dropdown-item" href="top_place.html">top place</a>
                    <a class="dropdown-item" href="tour_details.html">tour details</a>
                    <a class="dropdown-item" href="elements.html">Elements</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="contact">Contact</a>
                </li>
              </ul>
            </div>
            <a href="./search.do" class="btn_1 d-none d-lg-block">book now</a>
          </nav>
        </div>
      </div>
    </div>
  </div>
</header>
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

<!-- Header part end-->
<script type="text/javascript">


  $(function() { // index에서 검색시 값 확인 펑션
    $("#search").click(function() {
      var date1 = $("#datepicker_1").val();
      var date2 = $("#datepicker_2").val();
      var person = $("#person").val();
      var islogined = "${sessionScope.logined}";
      if((!date1) || (!date2) || (!person)){ // 셋중 하나 널이면
        alert('날짜와 인원수를 입력해주세요.');
      }else if(!islogined){
        var confirm1 = confirm("로그인 하시겠습니까? 아니오를 누르시면 비회원으로 진행됩니다.");
        if(confirm1){
          $("#loginBtn").trigger('click');
        }else{
          $("#searchSubmit").trigger('click');
        }
      }else{
        $("#searchSubmit").trigger('click');
      }
    });
  });

  $(function() { // search.do에서 검색시 값 확인 펑션
    $("#doSearch").click(function() {
      var date1 = $("#datepicker_1").val();
      var date2 = $("#datepicker_2").val();
      var person = $("#person").val();
      if((!date1) || (!date2) || (!person)){ // 셋중 하나 널이면
        alert('날짜와 인원수를 입력해주세요.');
      }else{
        $("#searchSubmit").trigger('click');
      }
    });
  });

  $(function() { // 예약시 값 확인 펑션
    $("#reservation").click(function() {
      var person = $("#person").val();
      if(!person){ // 인원수 널이면
        alert('인원수를 입력해주세요.');
      }else{
        $("#reservationModal").trigger('click');
      }
    });
  });

  $(function() { // 예약시 값 확인 펑션
    $("#reservationModalBtn").click(function() {
      var person = $("#person").val();
      if(!person){ // 인원수 널이면
        alert('인원수를 입력해주세요.');
      }else{
        $("#reservationModalSubmit").trigger('click');
      }
    });
  });

  $(document).ready(function(){ // numberOnly속성을 만들어 숫자만 입력 가능
    $("input:text[numberOnly]").on("keyup", function() {
      $(this).val($(this).val().replace(/[^0-9]/g,""));
    });
  });
  //아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
  $(function() {
    var isRegistrationOk = 0;
    //idck 버튼을 클릭했을 때
    $("#idCheck").click(function() {
      var userid = $("#userid").val(); // input userid부분의 값
      if(userid.length > 1) {
        $.ajax({
          type: 'POST',
          data: {userid: userid},// checkid.do?userid=userid 형식
          url: "./checkid.do",
          success: function (result) { // 성공하면 function 실행, result는 MemberDAOImpl의 checkMember() 리턴값
            if (result == 0) {
              $("#checkIdResult").html("<p style='font-size : 12px;'>사용중인 아이디입니다.</p>");
              isRegistrationOk = 0;
            } else {
              $("#checkIdResult").html("<p style='font-size : 12px;'>사용 가능한 아이디입니다.</p>");
              $("#isValidationOk").html("");
              isRegistrationOk = 1;
            }
          }
        });
      }else{
        $("#checkIdResult").html("<p style='font-size : 12px;'>아이디를 입력해 주세요.</p>");
      }
    });
    $("#register").click(function(){
      if(isRegistrationOk == 0){
        $("#isValidationOk").html("<p style='font-size : 12px;'>아이디 중복확인을 해주세요</p>");
      }else{
        $("#isValidationOk").html("");
        $("#registerForm").find('[type="submit"]').trigger('click');
      }
    });
  });
</script>



<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">로그인</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form class="member" action="./login.do" method="post">
      <div class="modal-body">
        <div class="mt-10">
          <input type="text" name="id" placeholder="ID" onfocus="this.placeholder = ''" onblur="this.placeholder = 'ID'" required="" class="single-input">
        </div>
        <div class="mt-10">
          <input type="password" name="pwd" placeholder="PWD" onfocus="this.placeholder = ''" onblur="this.placeholder = 'PWD'" required="" class="single-input">
        </div>
      </div>
      <div class="modal-footer">
        <a href = "#" class="genric-btn primary-border" style="width : 50%" data-dismiss="modal">닫기</a>
        <button id="register1" type="submit" onclick="" class="genric-btn primary" style="width : 50%">로그인</button>
      </div>
        </form>
      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">회원가입</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <div class="modal-body">
          <form id="registerForm" action="./registration.do" method="post">
          <div class="col-lg-8 col-md-8">
              <div class="mt-10">
                  <input id="userid" type="text" name="id" placeholder="ID" onfocus="this.placeholder = ''" onblur="this.placeholder = 'ID'" required="required" class="single-input">
              </div>
            <div class="mt-10" style="display: flex;">
            <button id="idCheck" type="button" class="genric-btn primary-border radius">중복체크</button><div style="margin-left : 10px;" id="checkIdResult"></div>
            </div>
            <div class="mt-10">
                <input type="text" name="pwd" placeholder="PWD" onfocus="this.placeholder = ''" onblur="this.placeholder = 'PWD'" required="required" class="single-input">
              </div>
              <div class="mt-10">
               <input type="text" name="name" placeholder="NAME" onfocus="this.placeholder = ''" onblur="this.placeholder = 'NAME'" required="required" class="single-input">
              </div>
              <div class="mt-10">
               <input type="email" name="email" placeholder="EMAIL" onfocus="this.placeholder = ''" onblur="this.placeholder = 'EMAIL'" required="required" class="single-input">
              </div>
              <div class="mt-10">
               <input type="text" name="tel" placeholder="TEL" onfocus="this.placeholder = ''" onblur="this.placeholder = 'TEL'" required="required" class="single-input" numberOnly>
              </div>
            <div class="mt-10" id="isValidationOk">

            </div>
            <br><br>
          </div>
          <div class="modal-footer">
        <a href = "#" class="genric-btn primary-border" style="width : 50%" data-dismiss="modal">닫기</a>
        <button id="register" type="button" onclick="" class="genric-btn primary" style="width : 50%">가입</button>
            <button id="registerSubmit" type="submit" style="display : none;"></button>
          </form>
        </div>
    </div>
  </div>
</div>
</div>