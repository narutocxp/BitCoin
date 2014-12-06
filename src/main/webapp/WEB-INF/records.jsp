<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="common/base.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>交易记录</title>
   
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   <script type="text/javascript" src="js/ajaxForVcode.js"></script>
   <script type="text/javascript" src="js/getmd5.js"></script>
   <style type="text/css">
     
   </style>
</head>
<body>
<div class="container">
<h2>My Transactions List</h2>
<p>我的交易列表</p>
<form action="${path}/getFirstPage" method="post">
类型
<select name="pageModel.queryKey1" >
	<option value="1" <c:if test="${1 == queryKey1 }">selected="selected"</c:if> >全部</option>
	<option value="2" <c:if test="${2 == queryKey1 }">selected="selected"</c:if> >汇入</option>
	<option value="3" <c:if test="${3 == queryKey1 }">selected="selected"</c:if> >汇出</option>
</select>
状态
<select name="pageModel.queryKey2" >
	<option value="1" <c:if test="${1 == queryKey2 }">selected="selected"</c:if> >全部</option>
	<option value="2" <c:if test="${2 == queryKey2 }">selected="selected"</c:if> >等待</option>
	<option value="3" <c:if test="${3 == queryKey2 }">selected="selected"</c:if> >完成</option>
	<option value="4" <c:if test="${4 == queryKey2 }">selected="selected"</c:if> >失败</option>
</select>
<input type="submit" value="查询"/>
</form>
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
	
	<a href="${path}/getBeforePage?pageModel.currentPage=${page.currentPage }&pageModel.queryKey1=${queryKey1}&pageModel.queryKey2=${queryKey2}">上一页</a>|当前第${page.currentPage }页|共${page.totalPage }页|<a href="${path}/getAfterPage?pageModel.currentPage=${page.currentPage }&pageModel.queryKey1=${queryKey1}&pageModel.queryKey2=${queryKey2}">下一页</a>
	
	<a href="${path}/returnAccount">返回转账页面</a>
</div>
</body>
</html>
