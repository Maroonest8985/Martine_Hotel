<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header-admin.jsp" %>

<!---------------------------------- header ----------------------------------->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Rooms</h1>
    <p class="mb-4">방 조회<a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Rooms</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="alert" style="padding-left:50px; padding-right:50px">
                    <br>
                    <form id="adRoomDetail" action="adRoomDetail.do" method="post">

                        <div class="form-floating">
                            <label for="name">Name</label>
                            <input class="form-control" name="name" id="name" type="text" value="${roomList.name}" placeholder="name" data-sb-validations="required" readonly />
                            <div class="invalid-feedback" data-sb-feedback="name:required">An email is required.</div>
                            <div class="invalid-feedback" data-sb-feedback="name">Email is not valid.</div>
                        </div>
                        <div class="form-floating">
                            <label for="ex">Ex</label>
                            <input class="form-control" name="ex" id="ex" type="text" value="${roomList.ex}" placeholder="ex gogo" data-sb-validations="required" readonly />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">ex</div>
                        </div>
                        <div class="form-floating">
                            <label for="price">Price</label>
                            <input class="form-control" name="price" id="price" type="text" value="${roomList.price}" placeholder="price gogo" data-sb-validations="required" readonly/>
                            <div class="invalid-feedback" data-sb-feedback="phone:required">price</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic1">Pic1</label>
                            <input class="form-control" name="pic1" id="pic1" type="text" value="${roomList.pic1}" placeholder="Null" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic1</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic2">Pic2</label>
                            <input class="form-control" name="pic2" id="pic2" type="text" value="${roomList.pic2}" placeholder="Null" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic2</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic1">Pic3</label>
                            <input class="form-control" name="pic3" id="pic3" type="text" value="${roomList.pic3}" placeholder="Null" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic3</div>
                        </div>
                        <div class="form-floating">
                            <img src="../${roomList.pic1}"> <!--서버에서 이미지 받아오기-->
                            <img src="../${roomList.pic2}"> <!--서버에서 이미지 받아오기-->
                            <img src="../${roomList.pic3}"> <!--서버에서 이미지 받아오기-->
                        </div>
                        <br />
                        <!-- Submit success message-->
                        <!---->
                        <!-- This is what your users will see when the form-->
                        <!-- has successfully submitted-->

                        <button class="btn btn-primary text-uppercase" type="button" onclick="location.href='roomUpdateForm.do?no=${roomList.no}';">수정</button>
                        <button class="btn btn-primary text-uppercase" type="button" onclick="location.href='roomDelete.do?no=${roomList.no}';">삭제</button>
                    </form>
                </div><table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            </table>
            </div>

        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="footer-admin.jsp" %>
</html>