<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>登录</title>
   
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   <script type="text/javascript" src="js/ajaxForVcode.js"></script>
   <script type="text/javascript" src="js/getmd5.js"></script>
   <style type="text/css">
    body {
    	font-family: "微软雅黑";
    }
    
    .button {
    	background-color: rgb(240,240,240);
    }
   </style>
</head>
<body>

<form class="form-horizontal" role="form" method="post" action="login.action" >
<div class="container">
	<div class="row">
		<h2 class="col-md-5 col-sm-offset-1">Welcome Back</h2>
		<h2 class="col-md-5 col-sm-offset-1">Forgotten Something</h2>
	</div>
	<br />
	<div class="row">
		<small><p class="col-md-5 col-sm-offset-1">Please enter your login detail below</p></small>
		<small><p class="col-md-5 col-sm-offset-1">Help I'v locked myself out of my account</p></small>
	</div>
	<br />
	<br />
	<div class="form-group">
	    <label for="inputEmail" class="col-sm-2 control-label col-sm-offset-1">E-Mail</label>
	    <div class="col-sm-3">
	      <input name="userMail" type="email" class="form-control" id="inputEmail" placeholder="enter your email"  required pattern="^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$" title="邮箱正确格式：xxx@xxx.xxx">
	    </div>
	    <h4 class="col-md-5 col-sm-offset-1">Lost Identifier or Alias</h4>
 	</div>
 	
 	<div class="form-group">
	    <label for="inputPassWord" class="col-sm-2 control-label col-sm-offset-1">Password</label>
	    <div class="col-sm-3">
	      <input name="userPassword" type="password" class="form-control" id="inputPassWord" placeholder="enter your password"  required pattern="^[A-Za-z]{1}[a-zA-Z0-9.]{7,15}$" title="密码为8-16为，以字母开头,只能包含数字，字母及小数点" >
	    </div>
	    <p class="col-md-5 col-sm-offset-1">If you have lost your wallet identifier first chech the comfirmation email you recieve during sign up. Can'n find the email? Click the button below  and we can send you a new one</p>
 	</div>
 	
 	<div class="form-group">
      <div class="col-sm-offset-2 col-sm-5">
         <div class="checkbox col-sm-offset-3">
            <img id="id_verify_img" src="img/vcode.jpg" alt="加载中..." onclick="this.src='img/vcode.jpg?'+ new Date().getTime()"/>
         </div>
      </div>
      <button type="button" class="btn btn-default col-md-1 col-sm-offset-2 button" ><small>Recover Wallet</small></button>
      <button type="button" class="btn btn-default col-md-1 button" onclick="window.location.href='register.jsp'"><small>注册新钱包</small></button>
   </div>
   
   <div class="form-group">
	    <label for="inputVcode" class="col-sm-2 control-label col-sm-offset-1">Captcha </label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="inputVcode" placeholder="enter the captcha"  required >
	    </div>
 	</div>
 	<br />
 	<div class="form-group">
      <div class="col-sm-offset-2 col-sm-5">
        <button type="submit" class="btn btn-primary" >Open Wallet</button>
      </div>
   </div>
</div>
</form>

</body>
</html>
