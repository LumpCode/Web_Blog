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

<title>${info }</title>

<link rel="stylesheet" href="image/style.css">

</head>

<body leftMargin="0" topMargin="0"  bgcolor="#f3f3f3">
	<form id="Form1" method="post">
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td height="100"></td>
			</tr>
			<tr>
				<td vAlign="top" align="center">
					<table
						style="background-color:#FFFFFF;BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; BORDER-BOTTOM: #cccccc 1px solid; BORDER-COLLAPSE: collapse"
						cellSpacing="0" cellPadding="0" width="500" border="1">
						<tr height="30">
							<td align="center" background="image/main/l-bg7.jpg" colSpan="2"><font
								color="#ffff66"><b>提示</b>
							</font>
							</td>
						</tr>
						<tr height="100">
							<td align="center">
								<table width="500" border="0">
									<tr align="center" height="100">
										<td>${info }</td>
										<%
											String url = (String) request.getAttribute("url");
											response.setHeader("Refresh", "3;url="+url);
										%>
									</tr>
									<tr height="50" align="center">
										<td>3秒后回到登陆页面</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
