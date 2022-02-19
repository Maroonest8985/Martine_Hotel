<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header-admin.jsp" %>

<!---------------------------------- header ----------------------------------->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Restaurants</h1>
    <p class="mb-4">식당 조회<a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Restaurants</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="alert" style="padding-left:50px; padding-right:50px">
                    <br>
                    <form id="restaurantsUpdate" action="restaurantsUpdate.do" method="post" enctype="multipart/form-data">
                        <input type="hidden" class="form-control" name="no" id="no" type="text" value="${restaurantsList.no}" placeholder="name" data-sb-validations="required"  />
                        <div class="form-floating">
                            <label for="name">Name</label>
                            <input class="form-control" name="name" id="name" type="text" value="${restaurantsList.name}" placeholder="name" data-sb-validations="required"  />
                            <div class="invalid-feedback" data-sb-feedback="name:required">An email is required.</div>
                            <div class="invalid-feedback" data-sb-feedback="name">Email is not valid.</div>
                        </div>
                        <div class="form-floating">
                            <label for="ex">Ex</label>
                            <input class="form-control" name="ex" id="ex" type="text" value="${restaurantsList.ex}" placeholder="ex gogo" data-sb-validations="required"  />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">ex</div>
                        </div>
                        <div class="form-floating">
                            <label for="price">Price</label>
                            <input class="form-control" name="price" id="price" type="text" value="${restaurantsList.price}" placeholder="price gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">price</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic1">Pic1</label>
                            <input class="form-control" name="pic1" id="pic1" type="file" value="${restaurantsList.pic1}" placeholder="pic1 gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic1</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic2">Pic2</label>
                            <input class="form-control" name="pic2" id="pic2" type="file" value="${restaurantsList.pic2}" placeholder="pic2 gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic2</div>
                        </div>
                        <div class="form-floating">
                            <label for="pic3">Pic3</label>
                            <input class="form-control" name="pic3" id="pic3" type="file" value="${restaurantsList.pic3}" placeholder="pic3 gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pic3</div>
                        </div>
                        <br />
                        <!-- Submit success message-->
                        <!---->
                        <!-- This is what your users will see when the form-->
                        <!-- has successfully submitted-->
                        <div class="d-none" id="submitSuccessMessage">
                            <div class="text-center mb-3">
                                <div class="fw-bolder">Form submission successful!</div>
                                To activate this form, sign up at
                                <br />
                                <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                            </div>
                        </div>
                        <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                        <button class="btn btn-primary text-uppercase" id="submitButton" type="submit">수정확인</button>

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