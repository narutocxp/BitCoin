<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
      var cntDown=10;
      window.onload=function(){
    	  
    	  setInterval("countDown(this)",1000);
    	  
      }
      
     function countDown(me){
    	 
    	  if((cntDown--)>0)
    		  document.getElementById("id_cnt_down").innerHTML=cntDown;
    	  else{
    		  
    		  location.href="latestprice";
    		  clearInterval(me);
    		  
    	  }
    		  
    	 
     }
      
</script>
<head>
   <title>BitCoin 最新成交价</title>
   <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
<style type="text/css">
 thead tr th{
	
	text-align:center; 
	 
 }
</style>
<table class="table table-bordered" style=" text-align:center">
   <caption style="font-size:24px">BitCoin 最新报价</caption>
   <thead>
      <tr style="ext-align:center">
         <th></th>
         <th>当前兑换</th>
         <th>24小时最高成交价/th>
         <th>24小时最低成交价</th>
         <th>最新买入价</th>
         <th>最新卖出价</th>
         <th>24小时成交量</th>
      </tr>
   </thead>
   <tbody>
       <c:forEach items="${infoList}" var="info" varStatus="st">
         <c:if test="${st.index%7==0}"><tr></c:if>
         <td>${info}</td>
         <c:if test="${(st.index-6)%7==0}"></tr></c:if>
       </c:forEach>
   </tbody>
</table>
 <div style="text-align:center;font-size:28px;">上次更新在<b id="id_cnt_down"><script type="text/javascript">document.write

(cntDown)</script></b>前</div>
</body>
</html>