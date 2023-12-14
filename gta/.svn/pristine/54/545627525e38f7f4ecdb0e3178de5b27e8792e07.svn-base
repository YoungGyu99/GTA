<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/control/control.css">
</head>
<body>
    <div class="container">
        <!-- header -->
         <div id="header-container"></div>
        <main>
          <h1> Control Management</h1>
          <div class="conMenu">
            <div class="controlMenu">
              <ul>
                <li><a class="menu-button" onclick="updateView('plug', this)" data-dataset="plug">Plug<img src="./plug.png" alt="plug"></a></li>
                <li><a class="menu-button" onclick="updateView('aircon', this)" data-dataset="Aircon">Aircon<img src="./aircon.png" alt="aircon"></a></li>
                <li><a class="menu-button" onclick="updateView('light', this)" data-dataset="Light">Light<img src="./Light.png" alt="light"></a></li>
              </ul>
            </div>

              </div>
            <h2>Status By Floor</h2>         
          <div class ="control_status">
            <h3 id="aircons-heading">aircon control</h3>
              <table class="controla" id ="aircons">
                <thead>
                  <tr>
                    <th>구간</th>
                    <th>Temp</th>
                    <th>On/Off</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><strong>1Floor</strong></td>
                    <td>25°C</td>
                    <td>
                      <input type="checkbox" id="switch1" class="switch" onchange="handleSwitchChange(1)">
                      <label for="switch1" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>2Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch2" class="switch" onchange="handleSwitchChange(2)">
                      <label for="switch2" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>3Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch3" class="switch" onchange="handleSwitchChange(3)">
                      <label for="switch3" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>4Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch4" class="switch" onchange="handleSwitchChange(4)">
                      <label for="switch4" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>5Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch5" class="switch" onchange="handleSwitchChange(5)">
                      <label for="switch5" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>6Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch6" class="switch" onchange="handleSwitchChange(6)">
                      <label for="switch6" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>7Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch7" class="switch" onchange="handleSwitchChange(7)">
                      <label for="switch7" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                 
                </tbody>
              </table>
  
              <h3 id="lights-heading" style="display: none;">Light</h3>
              <table class="controla"  id ="lights" style="display: none;">
                <thead>
                  <tr>
                    <th>구간</th>
                    <th>Temp</th>
                    <th>On/Off</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><strong>1Floor</strong></td>
                    <td>25°C</td>
                    <td>
                      <input type="checkbox" id="switch8" class="switch" onchange="handleSwitchChange(8)">
                      <label for="switch8" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>2Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch9" class="switch" onchange="handleSwitchChange(9)">
                      <label for="switch9" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>3Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch10" class="switch" onchange="handleSwitchChange(10)">
                      <label for="switch10" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>4Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch11" class="switch" onchange="handleSwitchChange(11)">
                      <label for="switch11" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>5Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch12" class="switch" onchange="handleSwitchChange(12)">
                      <label for="switch12" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>6Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch13" class="switch" onchange="handleSwitchChange(13)">
                      <label for="switch13" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>7Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch14" class="switch" onchange="handleSwitchChange(14)">
                      <label for="switch14" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                </tbody>
              </table>
          
              <h3 id="plugs-heading" style="display: none;">Plug</h3>
              <table class="controla"  id ="plugs" style="display: none;">
                <thead>
                  <tr>
                    <th>구간</th>
                    <th>Temp</th>
                    <th>On/Off</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><strong>1Floor</strong></td>
                    <td>25°C</td>
                    <td>
                      <input type="checkbox" id="switch15" class="switch" onchange="handleSwitchChange(15)">
                      <label for="switch15" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>2Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch16" class="switch" onchange="handleSwitchChange(16)">
                      <label for="switch16" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>3Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch17" class="switch" onchange="handleSwitchChange(17)">
                      <label for="switch17" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>4Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch18" class="switch" onchange="handleSwitchChange(18)">
                      <label for="switch18" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>5Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch19" class="switch" onchange="handleSwitchChange(19)">
                      <label for="switch19" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>6Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch20" class="switch" onchange="handleSwitchChange(20)">
                      <label for="switch20" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                  <tr>
                    <td><strong>7Floor</strong></td>
                    <td>22°C</td>
                    <td>
                      <input type="checkbox" id="switch21" class="switch" onchange="handleSwitchChange(21)">
                      <label for="switch21" class="switch_label">
                        <div class="onf_btn"></div>
                      </label>
                    </td>
                  </tr>
                 
                </tbody>
              </table>
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
                <p>building</p>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
      </div>
    
</body>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
<script src = "${pageContext.request.contextPath}/js/control/1.js"></script>
</html>