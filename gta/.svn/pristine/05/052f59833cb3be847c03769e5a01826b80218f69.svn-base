<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>GTA:inform</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/inform/inform.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/sidebar-darkmode/darkmode.css">
  
	<script const data = ${informListJson};>
   </script>
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

				<!-- board search area -->
				<div id="board-search">
					<div class="search-window">

						<div class="search-wrap">
							<select id="select" name="category" class="selectCategory">
								<option value="전체" selected>전체</option>
								<option value="공지">공지</option>
								<option value="고장">고장</option>
							</select> <input id="search" type="text" name=""
								placeholder="Please enter your search term." value="">
							<button type="button" class="btn btn-serch"
								onclick="searchInform()">SEARCH</button>
						</div>

					</div>
				</div>

				<div class="board_list_wrap">
					<div class="board_list">
						<div class="top">
							<div class="num">NUMBER</div>
							<div class="name">USERNAME</div>
							<div class="category">CATEGORY</div>
							<div class="title">TITLE</div>
							<div class="date">DATE</div>
						</div>
						
						<ul id="informListContainer">
						</ul>
					</div>
				</div>

				<div class="pagination-container">
					<div class="prev-button"><</div>
					<div class="number-button-wrapper">
<!-- 						<span class="number-button">1</span> -->
					</div>
					<div class="next-button">></div>
				</div> 

				<div class="bt_wrap">
					<a href="${pageContext.request.contextPath}/inform/write" class="on">WRITE</a>
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
		</div>
</body>
 <script type="text/javascript">
 var curl = '<c:url value="/"/>';
</script>
<script>
	// 비동기 요청 함수
	function searchInform() {

		// 수정 시작
		var category = $("#select").val(); // #select에 해당하는 ID로 수정
		var keyword = $("#search").val();
		// 수정 끝
		
		$.ajax({
			type : "GET",
			url : curl + "inform/search",
			data : {
				category : category, // 수정한 변수명 사용
				keyword : keyword
			},
			success : function(data) {
				// 성공적으로 데이터를 받았을 때 처리
				var informListContainer = $("#informListContainer");
				informListContainer.empty(); // 기존 행을 모두 지워줍니다.

				// 받은 데이터로 행을 추가합니다.
				$.each(data, function(index, inform) {
			    var row = "<li class='search-container'>" + 
			    "<a href='" + curl + "inform/detail?iNum=" + inform.iNum + "'>" +
			    "<div class='num'>" + inform.rowNum + "</div>" + 
			    "<div class='name'>" + inform.iName + "</div>" + 
			    "<div class='category'>" + inform.iRank + "</div>" + 
			    "<div class='title'>" + inform.iTitle + "</div>" + 
			    "<div class='date'>" + inform.iDate + "</div>" + 
			    "</a>" +
			    "</li>";
			    $("#informListContainer").append(row);
				});

			},
			error : function() {
				// 에러 발생시 처리
				alert("검색에 실패했습니다.");
			}
		});
	}
</script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
 <script src="${pageContext.request.contextPath}/js/inform/pagination.js"></script>
 <script src="https://kit.fontawesome.com/7dac82c2e1.js"
	crossorigin="anonymous"></script>
</html>
