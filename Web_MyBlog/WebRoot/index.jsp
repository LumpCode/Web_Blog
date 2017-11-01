<%@ page language="java" pageEncoding="utf-8"%>
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

<title>登陆</title>
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />

<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/check.js" charset="UTF-8"></script>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<div id="scene">
				<img src="images/scene.jpg" alt="" />
				<h1>博客网站系统</h1>
				<div id="scale_area">
					<div id="scale_knob">&raquo; Font Size &laquo;</div>
				</div>
				<div id="menu">
					<div class="holder"><a href="showAllArticle.jsp">博客首页</a></div>
					<div class="holder"><a href="register.jsp">新博客注册</a></div>
					<div class="holder"><a href="index.jsp">博客登录</a></div>
				</div>
			</div>
			<div id="content">
				<div id="col_left">
					<div class="post">
						<div class="meta"></div>
						<div class="comments">
							<div class="comment"></div>
							<h2>博客登录</h2>
							<form class="h" action="UesrServlet?action=login" method="post">
								<div>
									<label>用户名:</label> <input type="text" name="username" id="userName" placeholder="5-20个字符,包含数字和字母"/> <span class="span" id="uName"></span>
								</div>
								<div>
									<label>密码:</label> <input type="password" name="password" placeholder="6-32个字符"
										id="password" /> <span class="span" id="pwsd"></span>
								</div>
								<div>
									<label>登陆身份:</label> 
									<select style="float: left; height: 4%; " name="identity">
										<option selected="selected" value="user">--用&nbsp;&nbsp;&nbsp;&nbsp;户--</option>
										<option value="admin">--管理员--</option>
									</select>
								</div>
								<div>
									<label></label>
									<div class="clear"></div>
								</div>
								<div class="button_wrapper">
									<input name="提交" type="submit" class="button" value="登录" />
									<span class="span">${msg==null?"":msg}</span><%-- <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>  --%>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div id="col_right">
					<div id="search_box">
						<form action="http://www.baidu.com/" method="post">
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
							<li><a href="showAllArticle.jsp">博客首页</a></li>
							<li><a href="register.jsp">新博客注册</a></li>
							<li><a href="index.jsp">博客登录</a></li>
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
