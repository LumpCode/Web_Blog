<%@ page language="java" contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if (session.getAttribute("admin") == null) {
				response.sendRedirect("../index.jsp");
				return;
			}
%>


<!DOCTYPE html>
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
 
<c:if test="${empty Alist }">
		<c:redirect url="../../AdminServlet?action=all" />
	</c:if>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">  
    <div class="modal-dialog" role="document">  
        <div class="modal-content">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
                    <span aria-hidden="true">×</span>  
                </button>  
                <h4 class="modal-title" id="myModalLabel"></h4>  
            </div>  
            <div class="modal-body">  
                <p id="con"></p>  
            </div>  
            <div class="modal-footer">  
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
            </div>  
        </div>  
    </div>  
</div> 
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th style="text-align: center;">文章ID</th>
				<th style="text-align: center;">文章标题</th>
				<th style="text-align: center; display: none">文章内容</th>
				<th style="text-align: center;">用户ID</th>
				<th style="text-align: center;">作者</th>
				<th style="text-align: center;">发表时间</th>
				<th style="text-align: center;">操作</th>
			</tr>
		</thead>
		<!-- 循环输出 -->
		<c:forEach items="${Alist }" var="alist">
		<tr>
			<td style="text-align: center;">${alist.aid }</td>
			<td style="text-align: center;" id="${alist.aid }t">${alist.title }</td>
			<td style="text-align: center; display: none" id="${alist.aid }c">${alist.content }</td>
			<td style="text-align: center;">${alist.uid }</td>
			<td style="text-align: center;">${alist.userName }</td>
			<td style="text-align: center;">${alist.p_date }</td>
			<td style="text-align: center;">
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="choose(this)" id="${alist.aid }">查看</button>&nbsp;&nbsp;
			&nbsp;&nbsp;<button type="button" onclick="del(this,'${alist.aid }')" class="btn btn-primary btn-lg" >删除</button>
			<%-- <a href="" onclick="del('${alist.aid }')">删除</a>  --%>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>

<script>
	$(function() {
		$('#addnew').click(function() {

			window.location.href = "add.html";
		});

	});
	var ali = new Array();

	function choose(obj){
		//设置对应的标题文章内容到模态框中
		$("#myModalLabel").html($("#"+obj.id+"t").html());
		$("#con").html($("#"+obj.id+"c").html());
	}

	function del(obj,id) {
		if (confirm("确定要删除吗？")) {
		$(obj).parent().parent().remove(); 
//			$("table tr").eq(obj).remove();
			var url = "../../AdminServlet?action=del&aid="+id;
			$.post(url);
//			window.location.href = url;
		}
	}
</script>