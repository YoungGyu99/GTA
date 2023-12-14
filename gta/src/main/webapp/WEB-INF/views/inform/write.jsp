<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>GTA:inform</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/inform/inform.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/sidebar-darkmode/darkmode.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- header -->
		<%@ include file="/WEB-INF/views/header/header.jsp"%>
		<!-- main -->
		<main>
			<div class="board_wrap">
				<div class="board_title">
					<a href="${pageContext.request.contextPath}/inform">
					<strong>INFORM <i class="fa-solid fa-screwdriver-wrench"></i></strong>
					</a>
					<p>It can convey announcements, reports of facility failures,
						and more</p>
				</div>
				<form action="<c:url value="/inform/write.do" />" method="post">
				<div class="board_write_wrap">
					<div class="board_write">
						<div class="title">
							<dl>
								<dt>TITLE</dt>
								<dd>
									<input type="text" placeholder="Enter a title" name="iTitle" id="title"required>
								</dd>
							</dl>
						</div>
						<div class="info">
							<dl>
								<dt>USERNAME</dt>
								<dd>
									<input type="text" placeholder="Enter a name" name="iName" id="name"required>
								</dd>
							</dl>
							<dl id="categoryBox">
								<dt>CATEGORY</dt>
								<dd>
									<select id="category" name="iRank">
										<option value="공지" selected>공지</option>
										<option value="고장">고장</option>
									</select>
								</dd>
							</dl>
							<dl>
								<dt>PASSWORD</dt>
								<dd>
									<input type="password" placeholder="Enter a password" name="iPwd" id="pwd"required>
								</dd>
							</dl>
						</div>

						<div class="contents">
							<textarea placeholder="Enter contents" name="iContents" id="contents"required></textarea>
						</div>
					</div>
					<div class="bt_wrap">
						<button class="on" type="submit">WRITE</button> 
						<a href="javascript:history.back();">CANCEL</a>
					</div>
				</div>
				</form>
			</div>
		</main>
		<!-- 상단 User_Profile & darkmode -->
		<div class="right">
			<div class="top">
				<button id="menu_bar">
					<span class="material-symbols-sharp">menu</span>
				</button>
				<div class="theme-toggler">
					<span class="material-symbols-sharp active">light_mode</span> <span
						class="material-symbols-sharp">dark_mode</span>
				</div>
				<div class="profile">
					<div class="info">
						<p>
							<b>User</b>
						</p>
						<p><%= bid %></p>
						<small class="text-muted"></small>
					</div>
				</div>
			</div>

		
			<script src="https://kit.fontawesome.com/7dac82c2e1.js"
				crossorigin="anonymous"></script>
				<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>