<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="loginCheck.jsp"%>
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

<title>个人信息设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>

</head>

<body>
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
							<h2>个性化设置</h2>
							<form class="h" action="UesrServlet?action=update&uid=${user.uid }" method="post">
								<div>
									<label>博客标题:</label> <input type="text" name="nickName" value="${sessionScope.user.nickName }" />
								</div>
								<div>
									<label>个性签名:</label> <input type="text" name="qianMing" value="${sessionScope.user.qianMing }" />
								</div>
								<div>
									<label>用户名:</label> <input type="text" name="userName" value="${sessionScope.user.userName }" />
								</div>
								<div>
									<label>新密码:</label> <input type="text" name="pwd" />
								</div>
								<div>
									<label>确认新密码:</label> <input type="text" name="repwd" />
								</div>
								<div>
									<label>邮箱:</label> <input type="text" name="email" value="${sessionScope.user.email }" />
								</div>
								<div>
									<label></label>
									<div class="clear"></div>
								</div>
								<div class="button_wrapper">
									<input name="提交" type="submit" class="button" value="提交" />
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
