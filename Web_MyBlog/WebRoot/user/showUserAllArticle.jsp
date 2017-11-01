<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "loginCheck.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="../WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>我的全部文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/main.css" media="all" />
<script type="text/javascript" src="../js/mootools.js"></script>
<script type="text/javascript" src="../js/site.js"></script>
<script type="text/javascript">
	function del(obj) {
				if(confirm("确定删除?")){//在页面上弹出对话框
					var url ="../ArticleServlet?action=delete&aid="+obj.id;
					window.location.href = url;
				} 
			}
</script>
</head>
<body>
<c:if test="${empty oneArt }">
		<c:redirect url="../ArticleServlet?action=one" />
	</c:if>
<div id="wrapper">
  <div id="container">
    <div id="scene"> c<img src="../images/scene.jpg" alt="" />
       <h1>${empty user.nickName ? "博客网站系统":user.nickName} <br/>
      		<font size="8">${empty user.qianMing ? "我的签名":user.qianMing}</font>
      		</h1>
      <div id="scale_area">
        <div id="scale_knob">&raquo; Font Size &laquo;</div>
      </div>
      <div id="menu">
        <div class="holder"> <a href="../ArticleServlet?action=all">博客首页</a> </div>
        <div class="holder"> <a href="../ArticleServlet?action=one">用户首页</a> </div>
        <div class="holder"> <a href="editUserInfo.jsp">个性化设置</a> </div>
        <div class="holder"> <a href="addArticle.jsp">写日志</a> </div>
        <div class="holder"> <a href="showPhoto.jsp">相册</a> </div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"><a class="title" href="">我的全部文章</a>
            <div class="clear"></div>
          </div>
        <!-- 循环输出 -->
		<c:forEach items="${oneArt }" var="art">
			<c:set var="str" value="${art.content}"></c:set>  
          <div class="comments">
            <div class="comment">
              <div class="meta"> <span><a style="font-size:20px" href="../ArticleServlet?action=look&aid=${art.aid }&username=${art.userName }">${art.title }</a> 
              <small>:<br /><p style="font-size:16px">${myTag:substr(str,0,100)}...</p></small></span>
                <div class="clear"> </div>
              </div>
            </div>
            <div class="comment alt">
              <div class="meta"><span class="datetime">
              	<!-- 发表时间 -->
														发表于:
														${art.p_date }
														<!-- 评论与点击数 -->
														|评论(${art.hasRead})|点击(${art.clickNum})|作者:${art.userName}|<a style="cursor: pointer;" onclick="del(this)" id="${art.aid }">删除</a>
              |<a href="../ArticleServlet?action=update&aid=${art.aid }">修改</a>
              </span>
                <div class="clear"> </div>
              </div>
            </div>
          </div>
		 </c:forEach>
		  <div class="comment" align="center">
		  	当前第${page.currentPage}页，共${page.totalPage}页，每页显示${page.everyPage}条记录
			<s:if test="#request.page.hasPrePage">
				<a href="showUserAllArticle.action?currentPage=1">首页</a>
				<a href="showUserAllArticle.action?currentPage=${page.currentPage -1 }">上一页</a>
			</s:if>
			<s:else>
				首页
				上一页
			</s:else>
			
			<s:if test="#request.page.hasNextPage">
				<a href="showUserAllArticle.action?currentPage=${page.currentPage + 1 }">下一页</a>
				<a href="showUserAllArticle.action?currentPage=${page.totalPage }">尾页</a>			
			</s:if>
			<s:else>
				下一页
				尾页
			</s:else>
		  </div>
        </div>
      </div>
      <div id="col_right">
        <div id="search_box">
          <form action="" method="post">
            <div>
              <input type="text" name="search" />
            </div>
            <div class="button_wrapper">
              <input type="submit" value="Search" class="button" />
            </div>
            <div class="clear"> </div>
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
      <div class="clear"> </div>
    </div>
    <div id="footer">
      <div class="clear"> </div>
      <hr />
      <p class="credit">博客网站系统</p>
    </div>
  </div>
</div>
</body>
</html>
