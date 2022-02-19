<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header-admin.jsp" %>

<!---------------------------------- header ----------------------------------->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Member</h1>
    <p class="mb-4">회원 조회<a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Member</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="alert" style="padding-left:50px; padding-right:50px">
                    <br>
                    <form id="memberUpdate" action="memberUpdate.do" method="get">
                        <input type="hidden" class="form-control" name="no" id="no" type="text" value="${memberList.no}" placeholder="name" data-sb-validations="required"  />
                        <div class="form-floating">
                            <label for="name">Name</label>
                            <input class="form-control" name="name" id="name" type="text" value="${memberList.name}" placeholder="name" data-sb-validations="required"  />
                            <div class="invalid-feedback" data-sb-feedback="name:required">An email is required.</div>
                            <div class="invalid-feedback" data-sb-feedback="name">Email is not valid.</div>
                        </div>
                        <div class="form-floating">
                            <label for="id">Id</label>
                            <input class="form-control" name="id" id="id" type="text" value="${memberList.id}" placeholder="id gogo" data-sb-validations="required"  />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">id</div>
                        </div>
                        <div class="form-floating">
                            <label for="pwd">Pwd</label>
                            <input class="form-control" name="pwd" id="pwd" type="text" value="${memberList.pwd}" placeholder="pwd gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">pwd</div>
                        </div>
                        <div class="form-floating">
                            <label for="rank">Rank</label>
                            <input class="form-control" name="rank" id="rank" type="text" value="${memberList.rank}" placeholder="rank gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">rank</div>
                        </div>
                        <div class="form-floating">
                            <label for="tel">Tel</label>
                            <input class="form-control" name="tel" id="tel" type="text" value="${memberList.tel}" placeholder="tel gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">tel</div>
                        </div>
                        <div class="form-floating">
                            <label for="email">Email</label>
                            <input class="form-control" name="email" id="email" type="text" value="${memberList.email}" placeholder="email gogo" data-sb-validations="required" />
                            <div class="invalid-feedback" data-sb-feedback="phone:required">email</div>
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