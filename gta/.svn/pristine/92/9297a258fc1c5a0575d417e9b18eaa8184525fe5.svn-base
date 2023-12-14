<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GTA:inform</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inform/inform.css">
    <link rel ="stylesheet" href="${pageContext.request.contextPath}/css/sidebar-darkmode/darkmode.css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
     <c:if test="${showAlert eq true}">
     	<script>
      		alert('${errorMsg}');
      	</script>
      </c:if>
    <div class="container">
    <!-- header -->
    <%@ include file="/WEB-INF/views/header/header.jsp" %>
    <!-- main -->
    <main>
    <br>
    <div class="board_wrap">
        <div class="board_title">
        	<a href="${pageContext.request.contextPath}/inform">
            <strong>INFORM  <i class="fa-solid fa-screwdriver-wrench"></i></strong>
            </a>
            <p>It can convey announcements, reports of facility failures, and more</p>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    ${inform.iTitle}
                </div>
                <div class="info">
                    <dl>
                        <dt>USERNAME</dt>
                        <dd>${inform.iName}</dd>
                    </dl>
                    <dl>
                        <dt>CATEGORY</dt>
                        <dd>${inform.iRank}</dd>
                    </dl>
                    <dl>
                        <dt>DATE</dt>
                        <dd>${inform.iDate}</dd>
                    </dl>
                    
                </div>
                <div class="contents">
                    ${inform.iContents}<br>
                </div>
            </div>
			<div class="bt_wrap">
			    <a href="${pageContext.request.contextPath}/inform" class="on">LIST</a>
			    <a href="${pageContext.request.contextPath}/inform/rewrite?iNum=${inform.iNum}">REWRITE</a>
			</div>
        </div>
    </div>
</main> 
          <!-- 상단 User_Profile & darkmode -->
          <div class="right">        
            <div class="top">
              <button id="menu_bar">
                <span class="material-symbols-sharp">menu</span>
              </button>
              <div class="theme-toggler">
                <span class="material-symbols-sharp active">light_mode</span>
                <span class="material-symbols-sharp">dark_mode</span>
              </div>
              <div class="profile">
                <div class="info">
                  <p><b>User</b></p>
                  <p><%= bid %></p>
                  <small class="text-muted"></small>
                </div>
            </div>
          </div>
        </body>
			<script src="${pageContext.request.contextPath}/js/script.js"></script>
            <script src="https://kit.fontawesome.com/7dac82c2e1.js"crossorigin="anonymous"></script>
</html>