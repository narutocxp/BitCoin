<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<title>Insert title here</title>
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
@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<div class="div">
		<div class="div1 bg-success">
			<button type="button" class="close button">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<p class="p  lead">
				${info.state}<br />${info.prompt}<a href="${path}/${info.url}">${info.next}</a>
			</p>
		</div>
		<div class="div2">
			<center>
				<img  src="${path}/img/${info.img}" class="img" />
			</center>
		</div>
	</div>
</body>
</html>