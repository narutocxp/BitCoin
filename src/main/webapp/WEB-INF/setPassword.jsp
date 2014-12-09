<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>重置密码</title>
   
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/jquery.min.js"></script>
   <script type="text/javascript" src="${path}/js/getmd5.js"></script>
  <script type="text/javascript">
  
     function canSubmit(){
    	 
    	 
    	 var pwd=document.getElementById("password");
    	 var cfmPwd=document.getElementById("confimPassword");
    	 
    	 
          if(pwd.value!=cfmPwd.value){
        	  
        	  alert("前后密码不一致");
        	  return false;
          }
    		 
          pwd.value=hex_md5(pwd.value);
          cfmPwd.value=hex_md5(cfmPwd.value);
          
          return true;
          
   }
  
  </script> 
   
</head>
<body>

<form class="form-horizontal" role="form" method="post" action="resetPassword"  onsubmit="return canSubmit()">
 <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label"><p class="text-muted">New Password:</p></label>
      <div class="col-sm-3">
         <input type="password" class="form-control" id="password" name="newPassword" required pattern="^[A-Za-z]{1}[a-zA-Z0

-9.]{7,15}$" title="密码为8-16为，以字母开头,只能包含数字，字母及小数点" >
      </div>
  </div>
  
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label"><p class="text-muted">Confirm Password:</p></label>
      <div class="col-sm-3">
         <input type="password" class="form-control" id="confimPassword" required  pattern="^[A-Za-z]{1}[a-zA-Z0-9.]{7,15}$" 

title="密码为8-16为，以字母开头,只能包含数字，字母及小数点">
      </div>
   </div>
   
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary" >确定</button>
      </div>
   </div>
   <input type="hidden" name="mail" value="${mail}"/>
</form>

</body>
</html>
