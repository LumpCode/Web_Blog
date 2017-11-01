<%@page import="com.blog.model.entity.Article"%>
<%@ include file = "loginCheck.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/wangEditor.js"></script>
<script type="text/javascript" src="js/addArticle.js"></script>
</head>
<body onload="editor()">
	<div id="wrapper">
		<div id="container">
			<div id="scene">
				<img src="images/scene.jpg" alt="" />
				<h1>
					${empty user.nickName ? "博客网站系统":user.nickName} <br /> <font
						size="8">${empty user.qianMing ? "我的签名":user.qianMing}</font>
				</h1>
				<div id="scale_area">
					<div id="scale_knob">&raquo; Font Size &laquo;</div>
				</div>
				<div id="menu">
					<div class="holder"> <a href="ArticleServlet?action=all">博客首页</a> </div>
        	<div class="holder"> <a href="ArticleServlet?action=one">用户首页</a> </div>
        	<div class="holder"> <a href="user/editUserInfo.jsp">个性化设置</a> </div>
        	<div class="holder"> <a href="user/addArticle.jsp">写日志</a> </div>
        	<div class="holder"> <a href="user/showPhoto.jsp">相册</a> </div>
				</div>
			</div>
			<div id="content">
				<div id="col_left">
					<div class="post">
						<div class="meta"></div>
						<div class="comments">
							<div class="comment"></div>
							<h2>添加文章</h2>
							<form class="h" action="ArticleServlet?action=add" method="post">
							<!-- ArticleServlet?action=add -->
							<input type="hidden" name="tit" id="tit" value=""> 
							<input type="hidden" name="content" id="content" value=""> 
							<input type="hidden" name="content_html" id="content_html" value="">
							<input type="hidden" name="time" id="time" value="">
							<div>
								<label>标题：</label> <input type="text" name="title" id="title" />
							</div>
							<br />
							<div>
								<label>内容：</label><br />
								<div style=" width:600px;height: 300px;margin:50px 0px ">
									<div id="editor">
										<p>
											请在此处编辑 <b>文章内容</b>
										</p>
									</div>
								</div>
							</div>

							<div>
								<label></label>
								<div class="clear"></div>
							</div>
							<div class="button_wrapper">
								<input name="提交" onclick="addEditor()" type="submit"
									class="button" value="提交" />
							</div>
							</form>
						</div>
					</div>
				</div>
				<div id="col_right">
					<div id="search_box">
						<form action="#" method="post">
							<div>
								<input type="text" name="search" />
							</div>
							<div class="button_wrapper">
								<input type="submit" value="Search" class="button" />
							</div>
							<div class="clear"></div>
						</form>
					</div>
					<div id="sidebar">
						<h2>页面导航</h2>
						<ul>
							<li><a href="../ArticleServlet?action=all">博客首页</a></li>
        			<li><a href="../ArticleServlet?action=one">用户首页</a></li>
        			<li><a href="editUserInfo.jsp">个性化设置</a></li>
        			<li><a href="addArticle.jsp">写日志</a></li>
       				<li><a href="showPhoto.jsp">相册</a></li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div id="footer">
				<div class="clear"></div>
				<hr />
				<p class="credit">博客网站系统</p>
			</div>
		</div>
	</div>

</body>
</html>
