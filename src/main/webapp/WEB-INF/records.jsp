<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>交易记录</title>
   
<link rel="stylesheet"
	href="bootstrap/css/bootstrap.min.css">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="bootstrap/js/jquery.min.js"></script>
   <style type="text/css">
    .property{
    
      padding-top:20px;
    
    }
     .property li{
        display:inline;
        font-size:20px;
        width:30px;
      }
   </style>
 <script type="text/javascript">
      function toWallet(){
    	  
    	  location.href="${path}/returnAccount";
    	  
      }
 
 </script>
</head>
<body>
<div class="container">
<h2>My Transactions List</h2>
<p style="font-size:23px">我的交易列表</p>
<form action="${path}/getFirstPage" method="post">
<ul class="property">
<li>类型</li>
<li>
<select name="pageModel.queryKey1" style="width: 100px;margin-left:20px;">
	<option value="1" <c:if test="${1 == queryKey1 }">selected="selected"</c:if> >全部</option>
	<option value="2" <c:if test="${2 == queryKey1 }">selected="selected"</c:if> >汇入</option>
	<option value="3" <c:if test="${3 == queryKey1 }">selected="selected"</c:if> >汇出</option>
</select>
</li>
<li>
<span style="margin-left:30px">状态</span>
</li>
<li>
<select name="pageModel.queryKey2" style="width: 100px;margin-left:20px;">
	<option value="1" <c:if test="${1 == queryKey2 }">selected="selected"</c:if> >全部</option>
	<option value="2" <c:if test="${2 == queryKey2 }">selected="selected"</c:if> >等待</option>
	<option value="3" <c:if test="${3 == queryKey2 }">selected="selected"</c:if> >完成</option>
	<option value="4" <c:if test="${4 == queryKey2 }">selected="selected"</c:if> >失败</option>
</select>
</li>
<li>
<button id="smt" class="btn btn-primary" id="login-continue"
						style="vertical-align: top; margin-left: 50px">查询</button>
</li>
<li>
<button type="button" class="btn btn-primary" style="vertical-align: top; margin-left: 50px" onclick="toWallet()">返回转账页面</button>
</li>
</ul>
</form>
   <div style="height:230px;">
	<table class="table table-hover">
		<tr>
			<td>汇入/汇出地址</td>
			<td>类型</td>
			<td>数量</td>
			<td>状态</td>
			<td>时间</td>
		</tr>
		
		<c:forEach items="${results }" var="record">
		  <tr>
		  	<td>${record.address }</td>
		  	<td>${record.type }</td>
		  	<td>${record.amount }</td>
		  	<td>${record.state }</td>
		  	<td>${record.time }</td>
		  </tr>
		</c:forEach>
		
	
	</table>
   </div>
	<a href="${path}/getBeforePage?pageModel.currentPage=${page.currentPage }&pageModel.queryKey1=${queryKey1}&pageModel.queryKey2=${queryKey2}">上一页</a>|当前第${page.currentPage }页|共${page.totalPage }页|<a href="${path}/getAfterPage?pageModel.currentPage=${page.currentPage }&pageModel.queryKey1=${queryKey1}&pageModel.queryKey2=${queryKey2}">下一页</a>
</div>
</body>
</html>
