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
</head>
<body>
<c:if test="${empty oneUser }">
	<c:redirect url="../../AdminServlet?action=oneUser" />
</c:if>
<form action="../../AdminServlet?action=updateUser" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${oneUser.uid}" />
    <table class="table table-bordered table-hover definewidth m10">
         <tr>
            <td width="10%" class="tableleft">用户ID</td>
            <td><input type="text" readonly="readonly" name="uid" value='${oneUser.uid }'/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="username" value='${oneUser.userName }'/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password" value="${oneUser.pwd }"/></td>
        </tr>
        <tr>
            <td class="tableleft">用户昵称</td>
            <td><input type="text" name="realname" value="${oneUser.nickName }"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="${oneUser.email}"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
               <select name="status" style="width: 60px">
        				<option selected="selected" value="1" >启用 </option>
        				<option value="0" >禁用 </option>
        			</select>
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td>普通用户</td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button>				 &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });

    });
</script>
</body>
</html>
