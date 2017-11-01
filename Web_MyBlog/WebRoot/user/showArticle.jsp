<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>我的文章</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/wangEditor.js"></script>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/zyComment.js"></script>
<link rel="stylesheet" href="css/semantic.css" type="text/css" />
<link rel="stylesheet" href="css/zyComment.css" type="text/css" />
<style type="text/css" media="print, screen">
	label {
	    font-weight: bold;
	}
	a {
		font-family: Microsoft YaHei;
	}
	#articleComment {
		width: 550px;
		height: 500x;
		overflow: auto;
	}
</style>

<script type="text/javascript">
     function editor() {
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.customConfig.uploadImgShowBase64 = true;
        editor.create();
    }
    function addEditor() {

        if ($("#title").val().trim() == ""
                || editor.txt.text().trim() == "请在此处编辑 评论内容") {
            alert("评论内容不能为空!!!");
        } else {

        }
    }
</script>
</head>
<body onload="editor()">
	<div id="wrapper">
		<div id="container">
			<div id="scene">
				<img src="images/scene.jpg" alt="" />
				<h1>
					${empty user.nickName ? "博客网站系统":user.nickName} <br /> <font
						size="8">${empty user.qianMing ? "我的签名":user.qianMing} 
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
						<div class="meta">
							<a class="title" href="">${art.title }</a>
							<div class="clear"></div>
						</div>
						<div class="comments">
							<div class="comment">
								<div class="meta">
									<span>${art.content } </span>
									<div class="clear">
										<span class="datetime">作者:${art.userName}</span>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					</div>
					
					 
					<div class="comment">
						<div id="articleComment">
							 <div id="articleComment"></div>
								<script type="text/javascript">
									var agoComment =[];
	    						<c:forEach items="${clist }" var="comment">
	        					var a ={"id":'${comment.cmt_id}',"userName":'${comment.userName}',"aid":'${comment.aid}',"sortID":0,"time":'${comment.cmtDate}',"content":'${comment.content}'};
	        					agoComment.push(a);
	  							</c:forEach>
									$("#articleComment").zyComment({ "width":"350","height":"30","agoComment":agoComment,
	    						"callback":function(comment){
	        				console.info("填写内容返回值：");
	        				console.info(comment);
	        				// 添加新的评论
	        				var content = $("#commentContent").val();
	        				var name = '${empty user.userName?"游客:":user.userName}';
	        				$("#articleComment").zyComment("setCommentAfter",{"name":name, "content":content, "time":getnowtime()});
	        				$.post('CommentServlet?action=add&aid=${art.aid}&content='+content+'&userName='+name+'&cmtDate='+getnowtime());
//      					$(location).attr("href", 'CommentServlet?action=add&aid=${art.aid}&content='+content+'&userName='+name+'&cmtDate='+getnowtime());
    										}
									});

										function getnowtime() {
							        var nowtime = new Date();
							        var year = nowtime.getFullYear();
							        var month = padleft0(nowtime.getMonth() + 1);
							        var day = padleft0(nowtime.getDate());
							        var hour = padleft0(nowtime.getHours());
							        var minute = padleft0(nowtime.getMinutes());
							        var second = padleft0(nowtime.getSeconds());
							        var millisecond = nowtime.getMilliseconds();
							        millisecond = millisecond.toString().length == 1 ? "00" + millisecond
							                : millisecond.toString().length == 2 ? "0" + millisecond
							                        : millisecond;
							        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":"
							                + second;
							    }
							    //补齐两位数
							    function padleft0(obj) {
							        return obj.toString().replace(/^[0-9]{1}$/, "0" + obj);
							    }
								</script>
						</div>
					</div>
				</div> 
			</div>
			<div id="col_right" style="height:100px !important;">
				<div id="search_box">
					<form action="" method="post">
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
</body>
</html>
