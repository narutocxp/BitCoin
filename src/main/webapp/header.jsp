<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/base.jsp" %>
<link rel="shortcut icon" href="img/favicon.png" type="image/x-icon"/> 
<!DOCTYPE html>
<style type="text/css">
 body{
  
  padding:5px;
 
 }
 

</style>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap/js/jquery.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
<body>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">YUN - Cloud Coin</a>
   </div>
   <div class="among">
      <ul class="nav navbar-nav">
         <li><a href="#">Home</a></li>
         <li><a href="#">Stats</a></li>
         <li ><a href="#">API</a></li>
         <li><a href="#">Wallet</a></li>
         <li ><a href="${path}/latestprice">BitCoin最新情况</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right hidden-sm">
        <c:if test="${empty sessionScope.user}"><li><a href="${path}/login.jsp">Login</a></li></c:if>
        <c:if test="${! empty sessionScope.user}"><li><a href="#">Logged in as ${user.userName}</a></li></c:if>
        <c:if test="${! empty sessionScope.user}"><li><a href="${path}/logout">Logout</a></li></c:if>
        <li>&nbsp;&nbsp;</li>
      </ul>
   </div>
</nav>
</body>
