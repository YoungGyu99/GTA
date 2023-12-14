<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<script>
document.addEventListener("DOMContentLoaded", function() {
	  // 각 섹션을 참조하는 요소들을 가져옴
	  var datesSection = document.getElementById("datesSection");
	  var beSection = document.getElementById("beSection");
	  var levelSection = document.getElementById("levelSection");
	  //날짜 출력
	  var currentDateElement = document.getElementById('currentDate');
	  currentDateElement.textContent = getCurrentDate();
	  // 각 섹션에 show 클래스를 추가하여 나타나는 효과를 줌
	  setTimeout(function() {
	    datesSection.classList.add("show");
	  }, 500); // 예시로 0.5초 후에 첫 번째 섹션 나타나도록 설정

	  setTimeout(function() {
	    beSection.classList.add("show");
	  }, 700); // 예시로 1초 후에 두 번째 섹션 나타나도록 설정

	  setTimeout(function() {
	    levelSection.classList.add("show");
	  }, 900); // 예시로 1.5초 후에 세 번째 섹션 나타나도록 설정
	});
function formatNumberWithCommas(number) {
    return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
</script>
<body>
   <div class="container">
    <!-- header -->
    <%@ include file="/WEB-INF/views/header/header.jsp" %>
    <!-- main -->
    <!-- 대시보드 오늘의 날짜 % 사용량 & 예측 금액  -->
      <main>
           <h1>Dashbord</h1>
        <!-- 날짜 -->
        <div class="date" id="dateContainer">
            <div class="dates" id="datesSection">
               <span class="material-symbols-sharp">flash_on</span>
               <div class="middle">
                 <div class="left">
                   <h3>Electrical Engineering</h3>
                   <h1 id="currentDate"></h1>
                 </div>
               </div>
            </div>

            <!-- 건물 전체 에너지 사용량(어제 사용량)& 예측금액 -->
              <div class="be" id="beSection">
                <span class="material-symbols-sharp" onclick="toggleEnergyValue()" id ="paidblink">paid</span>
                <div class="middle">
                  <div class="left">
                    <h3>Total Consumption</h3>
                    <h1 id="energyValue">${dashboard}(Kwh)</h1>
                   </div>
                </div>
                <small>Month<br><strong id="month">${month}Kwh</strong></small>
              </div>

              <!-- 에너지 사용량 만족도 -->
              <div class="level" id="levelSection">
                <span class="material-symbols-sharp">mood</span>
                <div class="middle">
                  <div class="left">
                    <h3>Energy risk Level </h3>
                    <h1 id="energy-level">0 LV</h1>
                  </div>
                </div>
                <small>※ By energy percentage ※</small>
                <br>
                <small><strong id="level1">LV1&lt;50%&nbsp;&nbsp;</strong><strong id="level2"> 50%&lt;LV2&lt;80%&nbsp;&nbsp;</strong><strong id="level3">LV3&gt;80%</strong>
                </small>
              </div>
            </div>
            
            <!-- 건물 에너지 차트 & 사용량 예측 --> 
            <div class="be_chart">
              <h2>Usage Chart & Usage Estimate</h2>
              <!-- 날짜 주기 선택 --> 
              <div id="menu">
                <ul>
                  <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="now" onclick="get_data('now')">Now</a></li>
                  <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="day" onclick="get_data('day')">Day</a></li>
                  <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="week" onclick="get_data('week')">Week</a></li>
                  <li><a href="${pageContext.request.contextPath}/chart.do" class="menu-button" data-dataset="month" onclick="get_data('month')">Month</a></li>
                </ul>
              </div>
              <div class = "chart">
                <canvas id="myChart"></canvas>
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

            <div class="device">
              <h2>Active Appliances</h2>
              <div class="updates">
                <div class="update">
                </div>
                <canvas id ="horizontal-bar-chart" height="180px" width="100px"></canvas>
              </div>
            </div>

            <!-- 게시판 대시보드 (게시판과 이어지는 링크 부여)-->
            <div class="dashboard">
              <h2>Inform</h2>
              <div class="item onlion">
                <div class="transtition">
                  <div class="news">
                    <h3>transition<a href="${pageContext.request.contextPath}/inform">more view</a></h3> 
                    <table>
                      <thead>
                        <tr>
                          <th>NO</th>
                          <th>Title</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach var="info" items="${info}" varStatus="status">
                      
                        <tr>
                          <td><a href="<c:url value='/inform/detail?iNum=${info.iNum}' />">${status.count} </a></td>
                          <td><a href="<c:url value='/inform/detail?iNum=${info.iNum}' />">${info.iTitle }</a></td>
                        </tr>
                        
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
         </div>
                    
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.min.js"></script> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.bundle.min.js"></script> 
  <script type="text/javascript" charset="utf-8" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script> 
<script type="text/javascript">

var curl = '<c:url value="/"/>';
</script>
<script src="${pageContext.request.contextPath}/js/chart.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		get_data("month");
		var thisEnergy=0;
		var levelEnergy=0;
		var monthEnergy=0;
	});
	function get_data(search){
		let json_data = {
				searchType: search
		};
		$.ajax({
			 url :'<c:url value="/dashBoardData.do" />'
			,type :'POST'
			,contentType : 'application/json'
			,dataType : 'json'
			,data : JSON.stringify(json_data)
			,success:function(res){
				thisEnergy = res.beTotalEnergy;
				//레벨 부분 
				if(search == "month"){
				levelEnergy = parseFloat(res.beTotalEnergy).toFixed(2);
				monthEnergy = parseFloat(res.month, 2).toFixed(2);
				}
		        
				$("#energyValue").text(formatNumberWithCommas(res.beTotalEnergy)+"(Kwh)");
				$("#month").text(formatNumberWithCommas(res.month)+"(Kwh)");
				//레벨 값 계산
				var levelValue =parseFloat(levelEnergy/monthEnergy).toFixed(2);
				
				// 값에 따라 레벨 정하기
				if (0.8 < levelValue) {
				    $("#energy-level").text("LV3").css("color", "red");;
				} else if (levelValue >= 0.5 && levelValue < 0.8) {
					 $("#energy-level").text("LV2").css("color", "orange");;
				} else {
					 $("#energy-level").text("LV1").css("color", "green");;
				} 

			},error :function(e){
				console.log(e);
			}
		});
		//미니 차트 요청
	    $.ajax({
	    	  url: '<c:url value="/chart2.do" />',
	    	  type: 'POST',
	    	  contentType: 'application/json',
	    	  success: function (res) {
	    	    // Assuming res has properties bePlugEnergy, beLightEnergy, and beAcEnergy
	    	    let data = [res.bePlugEnergy, res.beAcEnergy, res.beLightEnergy];

	    	    new Chart(document.getElementById("horizontal-bar-chart"), {
	    	      type: 'bar',
	    	      data: {
	    	        labels: ["plug", "aircon", "light"],
	    	        datasets: [{
	    	          backgroundColor: ["#51EAEA", "#FCDDB0", "#FF9D76"],
	    	          data: data
	    	        }]
	    	      },
	    	      options: {
	    	        indexAxis: 'y',
	    	        plugins: {
	    	          title: {
	    	            display: true,
	    	            text: 'Energy consumption by device',
	    	          },
	    	          legend: {
	    	            display: false
	    	          }
	    	        },
	    	      },
	    	    });

	    	  },
	    	  error: function (e) {
	    	    console.log(e);
	    	  }
	    	});
	}
</script>
<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
</body>
</html>