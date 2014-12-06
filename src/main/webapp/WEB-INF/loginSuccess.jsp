<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="../header.jsp" %>
<html lang="en">
<head>
<title>YUN - CloudCoin</title>
<meta content="text/html;charset=utf-8" http-equiv="content-type">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	<style type="text/css">

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
.among{
 
 padding-top:5px;
 
}
</style>
<link href="bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">
	<link href="style/style-main.css" rel="stylesheet">
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="${path}/bootstrap/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${path}/bootstrap/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${path}/bootstrap/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${path}/bootstrap/ico/apple-touch-icon-57-precomposed.png">
<script type="text/javascript">
var selected = 2;
var addr = "";
function setting(url) {

	document
			.getElementById("myFrame").src = url;

}

function choose(s) {

	if (s == "All")
		selected = 2;
	else if (s == "True")
		selected = 1;
	else
		selected = 0;

	//alert(selected);
}

function search() {
   
	var key = document.getElementById("addressKey").value;
	addr = key;
	document.getElementById("myFrame").src = "${path}/search?walletAddress="+ key.trim()+ "&selected="+ selected;

}
</script>
</head>

<body>
	<div class="quickstart">
		<div class="container">
			<div class="row-fluid">
				<div class="span12">
					<h1>
						<span class="hidden-phone">My Wallet <small>Be Your
								Own Bank.</small></span>
					</h1>
				</div>
			</div>

			<div class="row-fluid" style="margin-top: 10px">
				<div class="span12 no-print">
					<ul class="nav nav-pills pull-left" style="margin-bottom: 3px">
						<li><a href="${path }/wallet" id="home-intro-btn">Wallet
								Home</a></li>
						<li><a id="my-transactions-btn">My Transactions</a></li>
						<li><a href="${path}/validate" class="hidden-phone"
							id="import-export-btn">validate</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 10px;">
		<div class="span6">
			<div class="page-header">
				<h3>Wallet Address List</h3>
			</div>
			<div>
				<input type="text" class="form-control" id="addressKey"
					placeholder="输入Address模糊查询" style="width: 200px">&nbsp;&nbsp;
					<select style="width: 100px; margin-left: 50px;"
					onchange="choose(this.options[selectedIndex].text)">
						<option>All</option>
						<option>True</option>
						<option>False</option>
				</select>
					<button id="smt" class="btn btn-primary" id="login-continue"
						style="vertical-align: top; margin-left: 50px" onclick="search()">Search</button>
			</div>
			<iframe src="wallet" width="570" height="260" frameborder="0"
				scrolling="no" id="myFrame"></iframe>
		</div>
		<div class="span5">
			<div class="page-header">
				<p align="right">
					<a class="btn btn-small btn-secondary recover-wallet-btn"
						id="btnAdd" onclick="setting('${path}/add')">新建钱包</a>
				</p>
			</div>

			<div class="form-horizontal">
				<form id="frm" method="post" action="${path}/createRecord"
					onsubmit="return check();">
					<div class="control-group">
						<label class="control-label">钱包地址:</label>
						<div class="controls">
							<input id="address" name="address" type="text" value=""
								readonly="readonly" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">当前地址余额:</label>

						<div class="controls">
							<input id="currentAmount" name="currentAmount" type="text"
								value="" readonly="readonly" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">锁定:</label>
						<div class="controls">
							<input id="locked" name="locked" type="text" value=""
								readonly="readonly" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">转账地址:</label>
						<div class="controls">
							<input id="toAddress" name="toAddress" type="text" value=""
								onblur="checkAddress()" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">回显信息:</label>
						<div class="controls">
							<input id="userName" name="userName" type="text" value=""
								readonly="readonly" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">转账金额:</label>
						<div class="controls">
							<input id="amount" name="amount" type="text" value="" />
						</div>
					</div>
					<div class="form-actions">
						<button id="smt" class="btn btn-primary" id="login-continue">转出云币</button>
					</div>
					
				</form>
				<form action="getFirstPage" method="post">
				   <input type="hidden" name="pageModel.queryKey1" value="1"/>
				   <input type="hidden" name="pageModel.queryKey2" value="1"/>
				   
				   <input type="submit" value="查看交易记录"/>
				</form>
			</div>
		</div>
	</div>



	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${path}/bootstrap/js/jquery.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-transition.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-alert.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-modal.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-dropdown.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-scrollspy.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-tab.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-tooltip.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-popover.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-button.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-collapse.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-carousel.js"></script>
	<script src="${path}/bootstrap/js/bootstrap-typeahead.js"></script>
	<script src="${path}/js/ajaxForWalletAddress.js"></script>
	<script type="text/javascript">
		function check() {
			var toAddress = $("#toAddress").val();
			var amount = $("#amount").val();
			var currentAmount = $("#currentAmount").val();
		    var locked = $("#locked").val();
            if(toAddress==""){
            	
            	alert("钱包地址不能为空，请看左边一栏");
            	return false;
            	
            }
			if (locked != "false") {
				alert("账户被锁定，不能进行交易！");
				return false;
			}

			if (toAddress == '') {
				alert("请输入你要汇款的地址！");
				$("toAddress").focus();
				return false;
			}

			
			if (amount == '') {
				alert("请输入你要汇款的金额！");
				$("amount").focus();
				return false;
			}
			if (isNaN(amount)) {
				alert("请输入数字");
				return false;

			} else if (amount > currentAmount) {

				alert("转出的余额大于现有的余额");
				return false;
			} else
				return true;
		}
	</script>
</body>
</html>
