<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title></title>
</head>
<body id="page-top">

<!-- Contact Section-->
<section class="page-section" id="contact">
    <div class="container" style="margin-top: 100px;">
        <!-- Contact Section Form-->
        <div class="row justify-content-center" style="margin-bottom: 50px;">
            <div class="col-lg-8 col-xl-7">
                <!-- title input-->
                <div class="mb-3">
                    <label for="title">제목</label>
                    <h6 id="title">${inform.iTitle}</h6>
                </div>
                <div class="mb-3">
                    <label for="name">작성자</label>
                    <h6 id="name">${inform.iName}</h6>
                </div>
                <div class="mb-3">
                    <label for="date">작성일</label>
                    <h6 id="date">${inform.iDate}</h6>
                </div>
                <!-- content input-->
                <div class="mb-3">
                    <textarea class="form-control bg-white" style="height: 20rem" readonly>${inform.iContents}</textarea>
                </div>
            </div>

            <div class="col-lg-8 col-xl-7 d-flex justify-content-end">
                <form action="<c:url value='/inform/rewrite' />" method="post">
                    <input type="hidden" name="iNum" value="${inform.iNum}">
                    <!-- Password input for validation -->
                    <div class="mb-3">
                        <label for="password">비밀번호</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-warning me-2">수정</button>
                </form>

                <form action="<c:url value='/inform/delete.do' />" method="post">
                    <input type="hidden" name="iNum" value="${inform.iNum}">
                    <!-- Password input for validation -->
                    <div class="mb-3">
                        <label for="password">비밀번호</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-danger me-2">삭제</button>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
