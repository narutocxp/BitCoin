<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!--<script language="JavaScript" src="jquery-1.9.0.min.js" ></script>-->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<meta content="text/html;charset=utf-8" http-equiv="content-type">
<link rel="stylesheet"
	href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript">
    
    var addr;

	function modify(id,address) {
		$("#firstRow").hide();
		//var whichTr = $("#modify_" + id).parent().parent();//TR
		//var lockedTd = whichTr.children("#locked_" + id);//TD
       
		/*
		if (lockedTd.html().indexOf('value=') == -1) {

			lockedTd.html("<input type='input' name='lockedTd[" + id
							+ "]' id='locked' value='" + lockedTd.html()
							+ "' size=12>");

		} 
		
		*/
		
          if (window.confirm('确定要修改lock吗?')) {
				 $("#firstRow").hide();
				 location.href="${path}/update?walletAddress="+address+"&page="+${page};
		  }
		
	   }
	
	
	function deleteWallet(address,amount){
		
		if(amount>0)
			alert("该账户不能删除");
		else if(window.confirm('确定要删除吗?')){
		 
		    	
			location.href="${path}/delete?walletAddress="+address+"&page="+${page};
		
		}
	}
	
	function pass(address,amount,flag){
		 
		 window.parent.document.getElementById("address").value=address;
		 window.parent.document.getElementById("currentAmount").value=amount;
		 
		 if(flag==1)
		   window.parent.document.getElementById("locked").value="true";
		 else
		   window.parent.document.getElementById("locked").value="false";
	}
	
</script>
</head>
<body>
    <div style="width:500px;height:230px">
	<table id="main" class="table table-hover">
		<thead>
			<th>Address</th>
			<th>Amount</th>
			<th>Locked</th>
		</thead>
		<tbody>
			<tr id="firstRow" style="display: none">
				<td>&nbsp;</td>
			</tr>
               <c:forEach items="${requestScope.list}" var="wallet" varStatus="status"> 
				<tr>
					<td id="address_${status.index}" onclick="pass('${wallet.walletAddress}','${wallet.walletAmount}','${wallet.walletLocked}')" style="cursor:pointer">${wallet.walletAddress}</td>
					<td id="amount_${status.index}">${wallet.walletAmount}</td>
					<td id="locked_${status.index}"><c:if test="${wallet.walletLocked==0}">false</c:if>
					<c:if test="${wallet.walletLocked==1}">true</c:if>
					</td>
					<td id="Func"><a href="#" id="modify_${status.index}" onclick="modify(${status.index},'${wallet.walletAddress}')">修改</a>&nbsp;<a
					 onclick="deleteWallet('${wallet.walletAddress}',${wallet.walletAmount})" style="cursor:pointer">删除</a>&nbsp;</td>
				</tr>
		      </c:forEach>
		</tbody>
	</table>
	</div>
	 <c:if test="${curPage>0}"><a href="${path}/wallet?page=${curPage-1}">上一页</a></c:if>|当前第${curPage+1}页|共${totalPage}页|
     <c:if test="${curPage<totalPage-1}"><a href="${path}/wallet?page=${curPage+1}">下一页</a></c:if> 
</body>
</html>
