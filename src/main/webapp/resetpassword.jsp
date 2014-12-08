<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>重置密码</title>
   
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   <script type="text/javascript" src="js/ajaxForLogin.js"></script>
   <script type="text/javascript" src="js/getmd5.js"></script>
   
   
</head>
<body>

<form class="form-horizontal" role="form" method="post" action="${path}/sendEmail" >
<div class="container">

	<div class="form-group">
		<h4 class="col-sm-offset-2">请输入注册时的邮箱地址，我们将发送重置密码地址到您的邮箱</h4>
	</div>
		
	<div class="form-group">
	    <label for="inputEmail" class="col-sm-2 control-label col-sm-offset-1">E-Mail</label>
	    <div class="col-sm-3">
	      <input name="mail" type="email" class="form-control focus" id="inputEmail" placeholder="enter your email"  required pattern="^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$" title="邮箱正确格式：xxx@xxx.xxx">
	    </div>
 	</div>
 	<br />
 	<div class="form-group">
      <div class="col-sm-offset-5 col-sm-5">
        <button type="submit" class="btn btn-primary" >确定</button>
      </div>
   </div>
</div>
</form>

</body>
</html>
