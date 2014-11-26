<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>激活</title>
   
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   <script type="text/javascript" src="js/ajaxForVcode.js"></script>
   <script type="text/javascript" src="js/getmd5.js"></script>
   <style type="text/css">
     li {
     	font-family: "微软雅黑";
     }
   </style>
</head>
<body>
<br />
<br />
<br />
<form class="form-horizontal" role="form" method="post" action="firstLogin" onsubmit="return canSubmit()">
 <div class="container">
 	<div class="row">
     <h4 class="col-md-2 col-sm-offset-1"><strong>Wallet validate</strong></h4>
    </div>
    <br />
    <div class="row">
    	<ul class="col-md-5 col-sm-offset-1">
    	   <li>设置个性化的用户名可以让汇款方回显到你，以确认你的身份</li>
    	   <li>请将你邮件中收到的验证码输入到验证码文本框中</li>
    	</ul>
    </div>
    <br />
    <br />
    
    <div class="form-group">
	    <label for="inputName" class="col-sm-2 control-label">用户名</label>
	    <div class="col-sm-3">
	      <input name="user.userName" type="text" class="form-control" id="inputName" placeholder="用户名" required>
	    </div>
 	</div>
  <div class="form-group">
	  
	    <label for="inputVcode" class="col-sm-2 control-label ">验证码</label>
	    <div class="col-sm-3">
	      <input name="user.userVerificationCode" type="text" class="form-control " id="inputVcode" placeholder="验证码" required >
	    </div>
	  
  </div>

	<br />
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">账户验证</button>
    </div>
  </div>
 </div>
<input type="hidden" name="user.userMail" value="${userEmail }"/>
</form>

</body>
</html>
