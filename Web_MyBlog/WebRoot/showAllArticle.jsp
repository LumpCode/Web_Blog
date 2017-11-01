<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/mytag.tld" prefix="myTag" %> 
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

<title>博客系统首页</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script src="js/analogClock.js"></script>
<c:if test="${empty notice }">
		<c:redirect url="ArticleServlet?action=all" />
	</c:if>
</head>

<body>
	<c:if test="${empty allArt }">
		<c:redirect url="ArticleServlet?action=all" />
	</c:if>
	<div id="wrapper">
		<div id="container">
			<div id="scene">
				<img src="images/scene.jpg" alt="" />
				<h1>博客网站系统</h1>
				<div id="scale_area">
					<div id="scale_knob">&raquo; Font Size &laquo;</div>
				</div>
				<div id="menu">
					<div class="holder"><a href="ArticleServlet?action=all">博客首页</a></div>
					<div class="holder"><a href="register.jsp">新博客注册</a></div>
					<div class="holder"><a href="index.jsp">博客登录</a></div>
				</div>
			</div>
			<div id="content">
				<div id="col_left">
					<div class="post">
						<div class="meta">
							<a class="title" href="ArticleServlet?action=all">博客系统首页</a>
							<div class="clear"></div>
						</div>
						<!-- 循环输出 -->
						<c:forEach items="${allArt }" var="art">
						 <c:set var="str" value="${art.content}"></c:set>   
							<div class="comments">
								<div class="comment">
									<div class="meta">
										<span> <a style="font-size:20px" href="ArticleServlet?action=look&aid=${art.aid }&username=${art.userName }">
												${art.title } </a> <small style="font-size:16px">:<br />${myTag:substr(str,0,100)}...</small></span>
										<div class="clear"></div>
									</div>
								</div>
								<div class="comment alt">
									<div class="meta">
										<span class="datetime"> <!-- 发表时间 --> 发表于:${art.p_date
											} <!-- 评论与点击数 -->
											|评论(${art.hasRead})|点击(${art.clickNum})|作者:${art.userName} </span>
										<div class="clear"></div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="comment" align="center">
							当前第${page.currentPage}页，共${page.totalPage}页，每页显示${page.everyPage}条记录
							<a href="">首页</a> <a
								href="showAllArticle.action?currentPage=${page.currentPage -1 }">上一页</a>
							首页 上一页 <a
								href="showAllArticle.action?currentPage=${page.currentPage + 1 }">下一页</a>
							<a href="showAllArticle.action?currentPage=${page.totalPage }">尾页</a>
							下一页 尾页
						</div>
					</div>
				</div>
				<div id="col_right">
					<div id="search_box">
						<form action="#" target="_blank" method="post">
							<div>
								<input type="text" name="s" />
							</div>
							<div class="button_wrapper">
								<input type="submit" value="Search" class="button" />
							</div>
							<div class="clear"></div>
						</form>
					</div>
					<div id="sidebar">
						<div style="width: 280px;height: 200px;padding: 5px 5px;background-color: orange;border-radius:5px  ">
							<h1 style="font-size: 25px">管理员公告:</h1><hr>
							<div style="width: 260px;height: 180px;margin: 5px 5px;">
								<h1 style="font-size: 20px">${notice.noticeTitle } </h1>
								<span style="font-size: 18px">${notice.noticeDetail} </span>
							</div>
						</div>
						<br />
						<div id="clock2" class="clock">
							<script>
								AnalogClock("clock2", {
									width : 300,
									bgColor : "white"
								});
							</script>
						</div>
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
