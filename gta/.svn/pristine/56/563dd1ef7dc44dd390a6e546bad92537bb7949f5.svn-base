<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/control/control.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript">
    var curl = '<c:url value="/"/>';
</script>
     <script src="${pageContext.request.contextPath}/js/control/control.js"></script>
</head>
<body>
    <div class="container">
        <!-- header -->
          <%@ include file="/WEB-INF/views/header/header.jsp" %>
        <main>
          <h1> Control Management</h1>
          <div class="conMenu">
            <div class="controlMenu">
              <ul>
                <li><a class="menu-button" onclick="updateView('aircons',this)" data-dataset="aircons"  data-head="aircons-heading">Aircon<img src="${pageContext.request.contextPath}/image/control_img/aircon.png" alt="aircon"></a></li>
                <li><a class="menu-button" onclick="updateView('lights',this)" data-dataset="lights"  data-head="lights-heading">Light<img src="${pageContext.request.contextPath}/image/control_img/Light.png" alt="light"></a></li>
              </ul>
            </div>

              </div>
            <h2>Status By Floor</h2>         
          <div class ="control_status">
            <h3 class="heading" id="aircons-heading">aircon control</h3>
            <form id="airconForm">
              <table class="controla" id ="aircons">
                <thead>
                  <tr>
                    <th>구간</th>
                    <th>Temp(IN / OUT)</th>
                    <th>On/Off</th>
                  </tr>
                </thead>
                <tbody>
                  
                  <c:forEach var="data" items="${data}" varStatus="status">
                  <tr>
                  <td><strong>${data.bwFloor}Floor</strong></td>
                  <td id ="acdata${status.count }">${data.bwInDegc } /${data.bwOutDegc }</td>
                  <td>
                  <input type="checkbox" name="aircon" id="switch${status.count }" class="switch" >
                  <label for='switch${status.count }' class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                      </td>
                   </tr>
                  </c:forEach>
                  
                  
                </tbody>
              </table>
            </form>
              <h3 class="heading" id="lights-heading" style="display: none;">Light</h3>
              <form id="lightsForm">
              <table class="controla"  id ="lights" style="display: none;">
                <thead>
                  <tr>
                    <th>구간</th>
                    <th>Temp(Lux / SUN)</th>
                    <th>On/Off</th>
                  </tr>
                </thead>
                <tbody>
                  

                   <c:forEach var="data" items="${data}" varStatus="status">
                  <tr>
                  <td><strong>${data.bwFloor}Floor</strong></td>
                  <td id="lidata${status.count }">${data.bwInLux }/${data.bwOutSun }</td>
                  <td>
                  <input type="checkbox" name="aircon" id="switch1${status.count }" class="switch" >
                  <label for='switch1${status.count }' class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                      </td>
                   </tr>
                  </c:forEach>
                  
                  
                  
                </tbody>
              </table>
              </form>

            </div>

            <div class="control_table">
              <h3>TimeLine</h3>
              <div class="products-area-wrapper tableView">
                <div class="products-header">
                  <div class="product-cell image">
                    Device
                  </div>
                  <div class="product-cell category">Floor</div>
                  <div class="product-cell status-cell">Status</div>
                  <div class="product-cell sales">Active Record<button class="sort-button" onclick="handleButtonClick()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
                  </button></div>
                </div>

              </div>
              <ul class="pagination modal-2" id="pagination">
                <li><a class="prev" onclick="handlePrevPage()">&laquo;</a></li>
                <li><a class="next" onclick="handleNextPage()">&raquo;</a></li>
              </ul>
              <div id="page-info">
                <p>Page <span id="current-page">1</span></p><p>/<span id="total-pages">1</span></p>
              </div>
              <button id ="allClear" onclick="handleAllClear()">All Clear</button>
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
          <div class="setting">
            <span id = "settings" class="material-symbols-sharp"  onclick="rotateElement(this)">settings</span>
                <p class="arrow_box">Setting temp and Time</p>
            <small>Temp Setting</small>
            <div class="setTmp">
              <div class="inputTemp">
                <small>Setting Temp °C</small>
                <input type="text" id="temperatureInput" placeholder="ex&#41; 30"oninput="validateInput(this)">
                <div class="frame">
                  <button class="custom-btn btn-1" onclick="saveTemperature()">Save</button>
                </div>
                  <div class="inputTime">
                  <small>Warning Time Setting (s) </small>
                  <input type="text" id="timeInput" placeholder="ex&#41; 60">
                  <div class="Timeframe">
                    <button class="custom-btn btn-1" id="saveButton" >Save</button>
                  </div>
              </div>
              </div>
            </div>
        </div>
      </div>
    
</body>
<script src="${pageContext.request.contextPath}/js/script.js"></script>

<!-- <script src="control.js"></script> -->
</html>