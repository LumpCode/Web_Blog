<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'wangEditor.jsp' starting page</title>
<script type="text/javascript" src="js/wangEditor.js"></script>

</head>

<body>
	<div id="editor">
		<p>
			欢迎使用 <b>wangEditor</b> 富文本编辑器
		</p>
	</div>

	<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
	<script type="text/javascript" src="/wangEditor.min.js"></script>
	<script type="text/javascript">
		var E = window.wangEditor;
		var editor = new E('#editor');
		// 或者 var editor = new E( document.getElementById('#editor') )
		editor.create();
	</script>
</body>
</html>
