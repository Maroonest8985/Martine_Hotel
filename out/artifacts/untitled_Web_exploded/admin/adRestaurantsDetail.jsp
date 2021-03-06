<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header-admin.jsp" %>

<!---------------------------------- header ----------------------------------->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Restaurants</h1>
    <p class="mb-4">์๋น ์กฐํ<a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Restaurants</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="alert" style="padding-left:50px; padding-right:50px">
                    <br>
                    <form id="adRestaurantsDetail" action="adRestaurantsDetail.do" method="post">

                        <div class="form-floating">
                            <label for="name">Name</label>
                            <input class="form-control" name="name" id="name" type="text" value="${restaurantsList.name}" placeholder="name" data-sb-validations="required" readonly />
                            <div class="invalid-feedback" data-sb-feedback="name:required">An email is required.</div>
                            <div class="invalid-feedback" data-sb-feedback="name">Email is not valid.</div>
                        </div>
                        <div class="form-floating">
                            <label for="ex">Ex</label>
                            <input class="form-control" name="ex" id="ex" type="text" value="${restaurantsList.ex}" placeholder="ex gogo" data-sb-validations="required" readonly />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">ex</div>
                        </div>
                        <div class="form-floating">
                            <label for="price">Price</label>
                            <input class="form-control" name="price" id="price" type="text" value="${restaurantsList.price}" placeholder="price gogo" data-sb-validations="required" readonly/>
                            <div class="invalid-feedback" data-sb-feedback="phone:required">price</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic1">Pic1</label>
                            <input class="form-control" name="pic1" id="pic1" type="text" value="${restaurantsList.pic1}" placeholder="Null" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic1</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic2">Pic2</label>
                            <input class="form-control" name="pic2" id="pic2" type="text" value="${restaurantsList.pic2}" placeholder="Null" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic2</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic3">Pic3</label>
                            <input class="form-control" name="pic3" id="pic3" type="text" value="${restaurantsList.pic3}" placeholder="Null" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic3</div>
                        </div>
                        <div class="form-floating">
                            <img src="../${restaurantsList.pic1}"> <!--์๋ฒ์์ ์ด๋ฏธ์ง ๋ฐ์์ค๊ธฐ-->
                            <img src="../${restaurantsList.pic2}"> <!--์๋ฒ์์ ์ด๋ฏธ์ง ๋ฐ์์ค๊ธฐ-->
                            <img src="../${restaurantsList.pic3}"> <!--์๋ฒ์์ ์ด๋ฏธ์ง ๋ฐ์์ค๊ธฐ-->
                        </div>
                        <br />
                        <!-- Submit success message-->
                        <!---->
                        <!-- This is what your users will see when the form-->
                        <!-- has successfully submitted-->

                        <button class="btn btn-primary text-uppercase" type="button" onclick="location.href='restaurantsUpdateForm.do?no=${restaurantsList.no}';">์์?</button>
                        <button class="btn btn-primary text-uppercase" type="button" onclick="location.href='restaurantsDelete.do?no=${restaurantsList.no}';">์ญ์?</button>
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