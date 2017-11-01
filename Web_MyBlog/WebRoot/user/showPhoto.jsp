<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "loginCheck.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>相册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="../js/mootools.js"></script>
<script type="text/javascript" src="../js/site.js"></script>
<!-- <script type="text/javascript">
		    var GB_ROOT_DIR = "./greybox/";
</script>
<script type="text/javascript" src="greybox/AJS.js"></script>
<script type="text/javascript" src="greybox/AJS_fx.js"></script>
<script type="text/javascript" src="greybox/gb_scripts.js"></script>
<link href="greybox/gb_styles.css" rel="stylesheet" type="text/css" /> -->
	<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="./fancybox/jquery.fancybox-1.3.4.js"></script>
	<link rel="stylesheet" type="text/css" href="./fancybox/jquery.fancybox-1.3.4.css" media="screen" />
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			*   Examples - images
			*/

			$("a#example1").fancybox();

			$("a#example2").fancybox({
				'overlayShow'	: false,
				'transitionIn'	: 'elastic',
				'transitionOut'	: 'elastic'
			});

			$("a#example3").fancybox({
				'transitionIn'	: 'none',
				'transitionOut'	: 'none'
			});

			$("a#example4").fancybox({
				'opacity'		: true,
				'overlayShow'	: false,
				'transitionIn'	: 'elastic',
				'transitionOut'	: 'none'
			});

			$("a#example5").fancybox();

			$("a#example6").fancybox({
				'titlePosition'		: 'outside',
				'overlayColor'		: '#000',
				'overlayOpacity'	: 0.9
			});

			$("a#example7").fancybox({
				'titlePosition'	: 'inside'
			});

			$("a#example8").fancybox({
				'titlePosition'	: 'over'
			});

			$("a[rel=example_group]").fancybox({
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'titlePosition' 	: 'over',
				'titleFormat'		: function(title, currentArray, currentIndex, currentOpts) {
					return '<span id="fancybox-title-over">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
				}
			});

			/*
			*   Examples - various
			*/

			$("#various1").fancybox({
				'titlePosition'		: 'inside',
				'transitionIn'		: 'none',
				'transitionOut'		: 'none'
			});

			$("#various2").fancybox();

			$("#various3").fancybox({
				'width'				: '100%',
				'height'			: '100%',
				'autoScale'			: false,
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'type'				: 'iframe'
			});

			$("#various4").fancybox({
				'padding'			: 0,
				'autoScale'			: false,
				'transitionIn'		: 'none',
				'transitionOut'		: 'none'
			});
		});
	</script>
</head>
<body style="text-align:center">
<div id="wrapper">
  <div id="container">
    <div id="scene"> <img src="../images/scene.jpg" alt="" />
      <h1>${empty user.nickName ? "博客网站系统":user.nickName} <br /> <font
						size="8">${empty user.qianMing ? "我的签名":user.qianMing} 
      		</h1>
      <div id="scale_area">
        <div id="scale_knob">&raquo; Font Size &laquo;</div>
      </div>
      <div id="menu">
        	<div class="holder"> <a href="../ArticleServlet?action=all">博客首页</a> </div>
        	<div class="holder"> <a href="../ArticleServlet?action=one">用户首页</a> </div>
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
            <h2>上传图片</h2>
            <form action="showPhoto.jsp" method="post" enctype="multipart/form-data">
              <div>
                <label>选择要上传的图片：</label>
                <input type="file" name="myFile"/>
              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <input name="提交" type="submit" class="button" value="上传" />
              </div>
            </form>
          </div>
          
          <div class="comments">
            <h2>显示相册图片</h2>
             <div id="content" style="">
	<p>

		<a id="example1" href="./example/1_b.jpg"><img alt="example1" src="./example/1_s.jpg" /></a>

		<a id="example2" href="./example/2_b.jpg"><img alt="example2" src="./example/2_s.jpg" /></a>

		<a id="example3" href="./example/3_b.jpg"><img alt="example3" src="./example/3_s.jpg" /></a>

		<a id="example4" href="./example/4_b.jpg"><img class="last" alt="example4" src="./example/4_s.jpg" /></a>
	</p>

	<p>


		<a id="example5" href="./example/5_b.jpg" title="Lorem ipsum dolor sit amet, consectetur adipiscing elit."><img alt="example4" src="./example/5_s.jpg" /></a>

		<a id="example6" href="./example/6_b.jpg" title="Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Vivamus fringilla congue laoreet."><img alt="example5" src="./example/6_s.jpg" /></a>

		<a id="example7" href="./example/7_b.jpg" title="Cras neque mi, semper at interdum id, dapibus in leo. Suspendisse nunc leo, eleifend sit amet iaculis et, cursus sed turpis."><img alt="example6" src="./example/7_s.jpg" /></a>

		<a id="example8" href="./example/8_b.jpg" title="Sed vel sapien vel sem tempus placerat eu ut tortor. Nulla facilisi. Sed adipiscing, turpis ut cursus molestie, sem eros viverra mauris, quis sollicitudin sapien enim nec est. ras pulvinar placerat diam eu consectetur."><img class="last" alt="example7" src="./example/8_s.jpg" /></a>
	</p>

	<p>

		<a rel="example_group" href="./example/9_b.jpg" title="Lorem ipsum dolor sit amet"><img alt="" src="./example/9_s.jpg" /></a>

		<a rel="example_group" href="./example/10_b.jpg" title=""><img alt="" src="./example/10_s.jpg" /></a>

		<a rel="example_group" href="./example/11_b.jpg" title=""><img alt="" src="./example/11_s.jpg" /></a>

		<a rel="example_group" href="./example/12_b.jpg" title=""><img class="last" alt="" src="./example/12_s.jpg" /></a>
	</p>
</div>
           <%--  <table cellspacing="5" align="center" border="1">
           	<tr>
           	<s:iterator value="#request.photoList" id="photo" status="stu">
				<td>
					<a href='photo/${sessionScope.username}/<s:property value="photo"/>' title="我的相册" rel="gb_imageset[photos]">
						<img src='photo/${sessionScope.username}/<s:property value="photo"/>' width="100" height="120">
					</a>	
				</td>
				<s:if test="(#stu.index + 1) % 3 == 0">
					</tr>
					<tr>
				</s:if>
			</s:iterator> --%>
			</table>
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
            <div class="clear"> </div>
          </form>
        </div>
        <div id="sidebar" style="text-align: left;">
          <h2>页面导航</h2>
          <ul>
            <li><a href="../ArticleServlet?action=all">博客首页</a></li>
        		<li><a href="../ArticleServlet?action=one">用户首页</a></li>
        		<li><a href="user/editUserInfo.jsp">个性化设置</a></li>
        		<li><a href="user/addArticle.jsp">写日志</a></li>
       			<li><a href="user/showPhoto.jsp">相册</a></li>
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