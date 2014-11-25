<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<title>error</title>
<style type="text/css">
.div {
	margin-left: 10%;
	margin-right: 10%;
}

.div1 {
	font: Arial, Helvetica, sans-serif;
	width: 100%;
	height: 80px;
	float: left;
}

.div2 {
	margin-top: 20px;
	float: left;
	background-color: #CCC;
	width: 100%;
	height: 400px;
}

.font {
	font: Arial, Helvetica, sans-serif;
	font-size: 16px;
}

.img {
	width: 60%;
	height: 320px;
	margin-top: 40px;
}

.button {
	margin-right: 10px;
	margin-top: 10px;
}

.p {
	margin-left: 10px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="div">
		<div class="div1 bg-info">
			<button type="button" class="close button">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<p class="p lead">
				ERROR!<br /> warning:注册失败，你输入的行已被占用！<a href="register.jsp">点击返回</a>
			</p>
		</div>
		<div class="div2">
			<center>
				<img src="${path}/img/error.jpg" class="img" />
			</center>
		</div>
	</div>
</body>
</html>