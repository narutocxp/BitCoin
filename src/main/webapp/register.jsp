<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>注册</title>
   
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <style type="text/css">
   .back{
	   background-color:rgb(247,247,247);
	   padding-left:10%;
	   padding-bottom:100px;
	   margin-left:2%;
	   margin-right:2%;
   }
   .form-control{
	   width:200px;
   }
   .info{
	    width:300px;
   }
   .aware{
	    margin-top:20px;
	    background-color:rgb(217,237,247);
		width:50%;
	    height:100px;
		color:rgb(83,136,178);
		margin-left:2%;
		padding-left:10px;
		padding-top:10px;
   }
   .hr{
		width:500px;
		margin-left:-660px;
   }
   .btn btn-primary{
	   color:rgb(0,85,204);
   }
   .cs_title{
	   padding-top:20px;
	   padding-bottom:10px;
   }
   </style>
</head>
<body>

<form class="form-horizontal" role="form" action="register">
 <div class="back">
     <h4 class="cs_title"><strong>Create A new Wallet.</strong></h4>
     <h4><small> Please choose an alias and password for the new wallet.</small></h4><br />
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label"><p class="text-muted">
Email:</p></label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="firstname" name="user.userMail">
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="info">
            (Optional)-We will email you a link to your new wallet.
         </div>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label"><p class="text-muted">Password:</p></label>
      <div class="col-sm-10">
         <input type="password" class="form-control" id="lastname" name="user.userPassword">
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label"><p class="text-muted">Confirm Password:</p></label>
      <div class="col-sm-10">
         <input type="password" class="form-control" id="lastname" >
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="checkbox">
            <img id="id_verify_img_sor" src="img/vcode.jpg" alt="加载中..." onclick="this.src='img/vcode.jpg?'+ new Date().getTime()"/>
         </div>
      </div>
   </div>
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label"><p class="text-muted">Captcha:</p></label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="firstname" >
      </div>
   </div>
   
     <hr class="hr"/>
   
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Continue</button>
      </div>
   </div>
 </div>
 <div class="aware">
   <button type="button" class="close" aria-hidden="true">
      &times;
   </button>
   <strong>Don't Forget Your Password!</strong><br />
   WATNING:Forgotten passwords are UNRECOVERABLE and will results in <strong>LOSS of ALL of your CloudCoin!</strong>
   
 </div>

</form>

</body>
</html>
