package com.blog.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.entity.User;
import com.blog.model.service.UserService;
import com.blog.model.service.Impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 9016303448185948051L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求响应编码格式
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取注册信息
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPwd(request.getParameter("password"));
		user.setNickName(request.getParameter("nickname"));
		user.setEmail(request.getParameter("email"));
		//实例化接口
		UserService us = new UserServiceImpl();
		if(us.registerService(user)) {
			request.setAttribute("url", "index.jsp");
			request.setAttribute("info", "注册成功");
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		}else {
			request.setAttribute("url", "register.jsp");
			request.setAttribute("info", "注册失败");
			request.getRequestDispatcher("error.jsp").forward(request,
					response);
		}
		
	}

}
