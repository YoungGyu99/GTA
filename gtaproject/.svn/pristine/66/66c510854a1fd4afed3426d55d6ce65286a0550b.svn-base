<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GTA:eePad</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar-darkmode/darkmode.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/eepad/eepad.css">
</head>
<body>
    <div class="container">
    <!-- header -->
    <%@ include file="/WEB-INF/views/header/header.jsp" %>
    <!-- main -->
    <main>
        <div class="box-container">
          <div class="box">
            <div class="billBox">
                <h1 class="billBoxTilte">Electricity Bill Save</h1>
                  <i class="fa-solid fa-piggy-bank"></i>
                <div class="box-content" id="billBoxIcon">
                  <span class="title">TARGET</span><br>
                  <fmt:formatNumber value="${result.averageMoney}" pattern="#,###" var="formattedAverageMoney" />
				  <span class="content">${formattedAverageMoney}</span><br>
                  <span class="title">CURRENT</span></br>
                  <fmt:formatNumber value="${result.currentMoney}" pattern="#,###" var="formattedCurrentMoney" />
                 <span class="content">${formattedCurrentMoney}</span><span> ₩</span>
                

                </div>
            </div>
          </div>
          <div class="box">
            <div class="energyBox">
                <h1 class="energyBoxTilte">Energy Saved</h1>
                  <i class="fa-solid fa-plug" id="energyBoxIcon"></i>
                <div class="box-content">
                  <span class="title">TARGET</span></br>
                  <fmt:formatNumber value="${result.averageEnergy}" pattern="#,###" var="formattedAverageEnergy" />
                  <span id="month" class="content">${formattedAverageEnergy}</span><span> kwh</span></br>
                  <span class="title">CURRENT</span></br>
                  <fmt:formatNumber value="${result.currentEnergy}" pattern="#,###" var="formattedCurrentEnergy" />
                  <span class="content">${formattedCurrentEnergy}</span><span> kwh</span>
                </div>
            </div>
          </div>
          <div class="box">
            <div class="co2Box">
                <h1 class="co2BoxTilte">CO2 Reduction</h1>
                  <i class="fa-solid fa-cloud" id="co2BoxIcon"></i>
                <div class="box-content">
                  <span class="title">TARGET</span></br>
                  <fmt:formatNumber value="${result.averageCo2}" pattern="#,###" var="formattedAverageCo2" />
                  <span class="content">${formattedAverageCo2}</span><span> M/T</span></br>
                  <span class="title">CURRENT</span></br>
                  <fmt:formatNumber value="${result.currentCo2}" pattern="#,###" var="formattedCurrentCo2" />
                  <span class="content">${formattedCurrentCo2}</span><span> M/T</span>
                </div>
            </div>
          </div>
          <div class="box">
            <div class="treeBox">
                <h1 class="treeBoxTilte">Tree Saved</h1>
                  <i class="fa-solid fa-tree" id="treeBoxIcon"></i>
                <div class="box-content">
                  <span class="title">TARGET</span></br>
				  <fmt:formatNumber value="${result.avgtree}" pattern="#,###" var="formattedAvgTree" />
				  <span class="content">${formattedAvgTree}</span><span> tree</span></br>
                  <span class="title">CURRENT</span></br>
                  <fmt:formatNumber value="${result.tree}" pattern="#,###" var="formattedTree" />
                  <span class="content">${formattedTree}</span><span> tree</span>
                </div>
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
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.min.js"></script> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.bundle.min.js"></script> 
  <script type="text/javascript" charset="utf-8" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script> 



<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
</body>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
<script src="https://kit.fontawesome.com/7dac82c2e1.js" crossorigin="anonymous"></script>

</html> 