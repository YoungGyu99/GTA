<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/control/control.css">

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment-with-locales.min.js"></script>
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
                        <li><a class="menu-button" onclick="updateView('plug')" data-dataset="plug">Plug<img src="${pageContext.request.contextPath}/image/control_img/plug.png" alt="plug"></a></li>
                        <li><a class="menu-button" onclick="updateView('aircon')" data-dataset="Aircon">Aircon<img src="${pageContext.request.contextPath}/image/control_img/aircon.png" alt="aircon"></a></li>
                        <li><a class="menu-button" onclick="updateView('light')" data-dataset="Light">Light<img src="${pageContext.request.contextPath}/image/control_img/Light.png" alt="light"></a></li>
                    </ul>
                </div>
            </div>
            <h2>Status By Floor</h2>
            <div class="control_status">
                <h3>aircon control</h3>
                <div id="controlListContainer"></div>
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
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                </button></div>
        </div>

        <!-- 첫 번째 row -->
        <div class="products-row" style="display: flex;">
            <div class="product-cell image">
                <span>aircon</span>
            </div>
            <div class="product-cell category"><span class="cell-label">Floor:</span>1</div>
            <div class="product-cell status-cell">
                <span class="cell-label">Status:</span>
                <span class="status disabled">Disabled</span>
            </div>
            <div class="product-cell sales"><span class="cell-label">Active Record:</span>12/06 11:30</div>
        </div>

        <!-- 두 번째 row (추가한 부분) -->
        <div class="products-row" style="display: flex;">
            <div class="product-cell image">
                <span>aircon</span>
            </div>
            <div class="product-cell category"><span class="cell-label">Floor:</span>2</div>
            <div class="product-cell status-cell">
                <span class="cell-label">Status:</span>
                <span class="status active">Active</span>
            </div>
            <div class="product-cell sales"><span class="cell-label">Active Record:</span>12/06 12:30</div>
        </div>
    </div>

    <ul class="pagination modal-2" id="pagination">
        <li><a class="prev" onclick="handlePrevPage()">«</a></li>
        <li><a class="next" onclick="handleNextPage()">»</a></li>
    </ul>
    <div id="page-info">
        <p>Page <span id="current-page">1</span></p><p>/<span id="total-pages">1</span></p>
    </div>
    <button id="allClear" onclick="handleAllClear()">All Clear</button>
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
                        <%
                           // Retrieve loginId from the session
                           String loginId = (String) session.getAttribute("loginId");
                        %>
                        <p><%= loginId %></p>
                        <small class="text-muted"></small>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>
    <script src="${pageContext.request.contextPath}/js/control/control.js"></script>
   <script>
    $(document).ready(function () {
        function fetchData() {
            $.ajax({
                type: 'POST',
                url: '<%= request.getContextPath() %>/control/getControlList',
                data: {bwId: '<%= loginId %>'},
                dataType: 'json',
                success: function (data) {
                  
                    var htmlContent = '<table border="1"><thead><tr>' +
                        '<th>Floor</th><th>Temp</th><th>On/Off</th>' +
                        '</tr></thead><tbody>';

                    for (var i = 0; i < data.length; i++) {
                        var floor = data[i].bwFloor !== undefined ? data[i].bwFloor : 'N/A';
                        var temperature = data[i].maxBwInDegc !== undefined ? data[i].maxBwInDegc.toFixed(2) + '°C' : 'N/A';

                        htmlContent += '<tr><td><strong>' + floor + '</strong></td>' +
                            '<td>' + temperature + '</td>' +
                            '<td>' +
                            '<input type="checkbox" id="switch' + i + '" class="switch" onchange="handleSwitchChange(' + i + ')" ' +
                            (data[i].switchOn ? 'checked' : '') + '>' +
                            '<label for="switch' + i + '" class="switch_label">' +
                            '<div class="onf_btn"></div>' +
                            '</label>' +
                            '</td></tr>';
                    }
                    htmlContent += '</tbody></table>';

                    $('#controlListContainer').html(htmlContent);
                },
                error: function (error) {
                    console.error("Error fetching data:", error);
                }
            });
        }

        function startUpdating() {
            fetchData();
            var intervalId = setInterval(fetchData, 5000);
        }

        function manuallyFetchData() {
            fetchData();
        }

        startUpdating();
    });
</script>

</body>
</html>
