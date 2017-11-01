<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</head>
<body>
<form action="../../AdminServlet?action=edit&nid=${OneNotice.noticeId }" method="post" class="definewidth m20">
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover ">
    <tr>
        <td width="10%" class="tableleft">公告名称</td>
        <td><input type="text" name="grouptitle" value="${OneNotice.noticeTitle }"/></td>
    </tr>
    <tr>
        <td class="tableleft">公告内容</td>
        <td > <textarea rows="3" cols="3" name="content">${OneNotice.noticeDetail }</textarea> </td>
    </tr>  
    <tr>
        <td class="tableleft">状态</td>
        <td >
        	<select name="status" style="width: 60px">
        		<option selected="selected" value="1" >启用 </option>
        		<option value="0" >禁用 </option>
        	</select>
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" onclick="Save(this)" class="btn btn-primary" type="button" id="${OneNotice.noticeId }">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });
		function Save(obj){
				window.location.href="../../AdminServlet?action=edit&nid="+obj.id;
		 }
    });
</script>