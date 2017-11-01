<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if (session.getAttribute("admin") == null) {
				response.sendRedirect("../index.jsp");
				return;
			}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../Css/style.css" />
<script type="text/javascript" src="../Js/jquery.js"></script>
<script type="text/javascript" src="../Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../Js/bootstrap.js"></script>
<script type="text/javascript" src="../Js/ckform.js"></script>
<script type="text/javascript" src="../Js/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

</head>

<body>
<c:if test="${empty ulist}">
			<c:redirect url="../../AdminServlet?action=allUser" />
</c:if>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th style="text-align: center;">用户id</th>
				<th style="text-align: center;">用户名称</th>
				<th style="text-align: center;">用户密码</th>
				<th style="text-align: center;">用户昵称</th>
				<th style="text-align: center;">用户邮箱</th>
				<th style="text-align: center;">用户状态</th>
				<th style="text-align: center;">操作</th>
			</tr>
		</thead>
		<!-- 循环输出 -->
    <c:forEach items="${ulist }" var="ulist">
		<tr>
			<td style="text-align: center;">${ulist.uid }</td>
			<td style="text-align: center;">${ulist.userName }</td>
			<td style="text-align: center;">${ulist.pwd }</td>
			<td style="text-align: center;">${ulist.nickName }</td>
			<td style="text-align: center;">${ulist.email }</td>
			<td style="text-align: center;">${ulist.status==1?"正常":"禁言" }</td>
			<td style="text-align: center;"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="choose(this)" id="${ulist.uid }">管理</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
		$(function() {
			$('#addnew').click(function() {
				window.location.href = "add.html";
			});
		});
		function choose(obj) {
				var url = "../../AdminServlet?action=oneUser&uid="+obj.id;
				window.location.href = url;
		}
	</script>
</body>
</html>
