<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
   <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <title>Document</title>
</head>
<body>
         <%
        // 세션 ID 가져오기
        String bid = (String) session.getAttribute("login");
    %>
        <aside>
           <div class="top">
             <div class="logo">
               <a href="${pageContext.request.contextPath}/dashboard">
    			<img src="${pageContext.request.contextPath}/image/logoB.png" alt="More View Image" class="bl" id="lightImage"></a>
				<a href="${pageContext.request.contextPath}/dashboard">
    			<img src="${pageContext.request.contextPath}/image/GTA_로고_pointColor.png" alt="More View Image" class="li" id="darkImage">
				</a>
             </div>
             <div class="close" id="close_btn">
              <span class="material-symbols-sharp">
                close
                </span>
             </div>
           </div>
           <!-- end top -->
            <div class="sidebar">
              <a href="${pageContext.request.contextPath}/dashboard">
                <span class="material-symbols-sharp">grid_view </span>
                <h3>Dashbord</h3>
             </a>
             <a href="${pageContext.request.contextPath}/detail">
                <span class="material-symbols-sharp">insights</span>
                <h3>Detail Of Energy</h3>
             </a>
             <a href="${pageContext.request.contextPath}/control">
               <span class="material-symbols-sharp">
                  toggle_on
                  </span>
                <h3>Control Management</h3>
             </a>
             <a href="${pageContext.request.contextPath}/eepad">
               <span class="material-symbols-sharp">
                  preview
                  </span>
                <h3>EE Health Pad</h3>
             </a>
             <a href="${pageContext.request.contextPath}/inform">
               <span class="material-symbols-sharp">
                  edit
                  </span>
                <h3>Inform</h3>
             </a>
             <a href="${pageContext.request.contextPath}/logout.do">
                <span class="material-symbols-sharp">login </span>
                <h3>logout</h3>
             </a>
            </div>
        </aside>
    </body>
</html>