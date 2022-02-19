<%@ include file="header-admin.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!---------------------------------- header ----------------------------------->
${errMsg}
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Members</h1>
    <p class="mb-4">회원 조회<a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">

        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>Id</th>
                        <th>Pwd</th>
                        <th>Rank</th>
                        <th>전화번호</th>
                        <th>Email</th>

                    </tr>
                    </thead>

                    <c:forEach items="${requestScope.memberList}" var="member">
                        <tbody>
                        <tr>
                            <td>${member.no}</td>
                            <td><a href="memberDetail.do?no=${member.no}">${member.name}</a></td>
                            <td>${member.id}</td>
                            <td>${member.pwd}</td>
                            <c:choose>
                                <c:when test="${member.rank == 1}">
                                    <td>회원</td>
                                </c:when>
                                <c:when test="${member.rank == 0}">
                                    <td>비회원</td>
                                </c:when>
                                <c:otherwise>
                                        <td>관리자</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${member.tel}</td>
                            <td>${member.email}</td>

                        </tr>

                        </tbody>
                    </c:forEach>
                </table>
                <!-- Pager-->
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">

                        <c:if test="${pagination.beginPageNo > pagination.perPagination }" >
                            <li class="page-item">
                                <a class="page-link" href="memberList.do?pn=${pagination.beginPageNo - 1}" tabindex="-1" aria-disabled="true">Prev</a>
                            </li>
                        </c:if>

                        <c:forEach var="pageNo" begin="${pagination.beginPageNo}" end="${pagination.endPageNo}">
                            <c:choose>
                                <c:when test="${pageNo == pagination.curPageNo}">
                                    <li class="page-item active"><a class="page-link" href="memberList.do?pn=${pageNo}">${pageNo}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link" href="memberList.do?pn=${pageNo}">${pageNo}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${pagination.endPageNo < pagination.totalPages }" >
                            <li class="page-item">
                                <a class="page-link" href="memberList.do?pn=${pagination.endPageNo + 1}" tabindex="-1" aria-disabled="true">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="footer-admin.jsp" %>
</html>