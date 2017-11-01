<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
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

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
  	<c:if test="${empty Nlist }">
			<c:redirect url="../../AdminServlet?action=notice" />
		</c:if>
</head>
<body>

<form class="form-inline definewidth m20" action="index.html" method="get">  
    <button type="button" class="btn btn-success" id="addnew">新增公告</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th style="text-align: center;">公告编号</th>
        <th style="text-align: center;">公告标题</th>
        <th style="text-align: center;">公告内容</th>
        <th style="text-align: center;">公告状态</th>
        <th style="text-align: center;">管理操作</th>
    </tr>
    </thead>
    <!-- 循环输出 -->
    <c:forEach items="${Nlist }" var="nlist">
	     <tr>
            <td style="text-align: center;">${nlist.noticeId }</td>
            <td style="text-align: center;" id="${nlist.noticeId  }t">${nlist.noticeTitle }</td>
            <td style="text-align: center;" id="${nlist.noticeId  }c">${nlist.noticeDetail }</td>
            <td style="text-align: center;">${nlist.status==1?"启用":"未启用" }</td>
            <td style="text-align: center;width: 200px">
              <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="choose(this)" id="${nlist.noticeId }">编辑</button>&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" onclick="del(this,'${nlist.noticeId }')" class="btn btn-primary btn-lg" >删除</button>
            </td>
        </tr>
     </c:forEach>
     </table>
</html>
<script>
    $(function () {
			$('#addnew').click(function(){
				window.location.href="add.jsp";
		 	});
   	 });
		
			function choose(obj){
				window.location.href="../../AdminServlet?action=One&nid="+obj.id;
			}
			function del(obj,id)
			{
					if (confirm("确定要删除吗？")) {
						$(obj).parent().parent().remove(); 
//						var url = "../../AdminServlet?action=del&aid="+id;
//						$.post(url);
				}
		}
</script>